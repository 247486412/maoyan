package com.maoyan.web.adminServlet;

import com.maoyan.entity.Area;
import com.maoyan.entity.Credits;
import com.maoyan.entity.Movie;
import com.maoyan.entity.PagingBean;
import com.maoyan.entity.Picture;
import com.maoyan.entity.Type;
import com.maoyan.entity.Year;
import com.maoyan.service.MovieService;
import com.maoyan.service.serviceImpl.AreaServiceImpl;
import com.maoyan.service.serviceImpl.MovieServiceImpl;
import com.maoyan.service.serviceImpl.TypeServiceImpl;
import com.maoyan.service.serviceImpl.YearServiceImpl;
import com.maoyan.util.UUIDUtils;
import com.maoyan.util.UploadUtils;
import com.maoyan.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminMovieServlet", urlPatterns = "/AdminMovieServlet")
public class AdminMovieServlet extends BaseServlet {
  private MovieService movieService = new MovieServiceImpl();

  public String findMovie(HttpServletRequest request, HttpServletResponse response) throws SQLException {
    String currentPage = request.getParameter("currentPage");
	PagingBean<Movie> page = movieService.findMovie(Integer.parseInt(currentPage));
	request.setAttribute("page", page);
	return "/admin/movie/list.jsp";
  }

  public String deleteMovie(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String id = request.getParameter("id");
	try {
	  movieService.deleteMovie(id);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "删除失败");
	  return "/admin/movie/list.jsp";
	}
	response.sendRedirect(request.getContextPath() + "/AdminMovieServlet?method=findMovie");
	return null;
  }

  public String addMovieUI(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	List<Type> typeList = new TypeServiceImpl().findAllType();
	List<Year> yearList = new YearServiceImpl().findYear();
	List<Area> areaList = new AreaServiceImpl().findArea();
	request.setAttribute("typeList", typeList);
	request.setAttribute("yearList", yearList);
	request.setAttribute("areaList", areaList);
	return "/admin/movie/add.jsp";
  }

  public String addMovie(HttpServletRequest request, HttpServletResponse response) {
	String movieName = request.getParameter("movieName");
	String duration = request.getParameter("duration");
	String typeName = request.getParameter("typeName");
	String yearName = request.getParameter("yearName");
	String areaName = request.getParameter("areaName");
	String status = request.getParameter("status");
	Movie movie = new Movie();
	movie.setType_id(typeName);
	movie.setArea_id(areaName);
	movie.setDuration(duration);
	movie.setYears_id(yearName);
	movie.setFlag(Integer.parseInt(status));
	movie.setName(movieName);
	movie.setId(UUIDUtils.getId());
	request.getSession(true).setAttribute("movie", movie);
	request.setAttribute("msg", "请上传影片封面图");
	return "/admin/movie/addPicture.jsp";
  }

  public String addPicture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
	  Movie movie = (Movie) request.getSession().getAttribute("movie");
	  DiskFileItemFactory factory = new DiskFileItemFactory();
	  ServletFileUpload upload = new ServletFileUpload(factory);
	  upload.setHeaderEncoding("utf-8");
	  upload.setFileSizeMax(1024 * 1024 * 20);
	  upload.setSizeMax(1024 * 1024 * 500);
	  List<FileItem> list = upload.parseRequest(request);
	  if (list != null) {
		Picture fileEntity = null;
		for (FileItem item : list) {
		  if (item != null && !item.equals("")) {
			if (item.isFormField() && item.getFieldName().equals("pictureName")) {
			  //普通表单
			  fileEntity.setDescribe(item.getString("utf-8"));
			  movie.setPicture(fileEntity);
			  movie.setPicture_id(fileEntity.getId());
			} else {//组件
			  fileEntity = new Picture();
			  String uuid = UUIDUtils.getId();
			  String fileName = item.getName();
			  Long size = item.getSize();
			  //随机文件名称，避免重复
			  String realPath = this.getServletContext().getRealPath("/img/moviePicture");
			  String oldFilename = item.getName();//得到文件名
			  String newFilename = UploadUtils.getUUIDName(oldFilename);//生成新的文件名,UUID加上以前的后缀名
			  //传入任意字符串生成一个，得到其hash值在转换为16进制的字符串,该串的每个字符为一个目录名，最后生成一个随机的8级目录
			  String fileDir = UploadUtils.getDir(newFilename);
			  String path = realPath + fileDir;
			  File newPath = new File(path);//创建一个新目录
			  if (!newPath.exists()) {//如果该目录不存在
				newPath.mkdirs();//创建这个目录
			  }
			  File finalFile = new File(newPath, newFilename);//创建一个文件，传入file对象和文件名
			  if (!finalFile.exists()) {//如果该文件不存在则创建这个文件
				finalFile.createNewFile();
			  }
			  InputStream in = item.getInputStream();//通过FileItem获取到输入流对象,通过输入流可以获取到图片二进制数据
			  OutputStream out = new FileOutputStream(finalFile);//创建一个文件输出流，构造方法的参数为一个接收这个流的file
			  IOUtils.copy(in, out);//把得到的file数据输出到文件输出流的文件里
			  IOUtils.closeQuietly(out);//释放资源
			  IOUtils.closeQuietly(in);
			  fileEntity.setId(uuid);
			  fileEntity.setName(fileName);
			  fileEntity.setMovie_id(movie.getId());
			  fileEntity.setPath("img/moviePicture" + fileDir + newFilename);
			  //计算文件大小
			  String sizeStr = "";
			  if (size >= 1024 && size < 1024 * 1024) {
				sizeStr = (size / 1024) + "KB";
			  } else if (size > 1024 * 1024 && size <= 1024 * 1024 * 1024) {
				sizeStr = (size / (1024 * 1024)) + "MB";
			  } else if (size >= 1024 * 1024 * 1024) {
				sizeStr = (size / (1024 * 1024 * 1024)) + "GB";
			  } else {
				sizeStr = size + "B";
			  }
			  fileEntity.setSize(sizeStr);
			}

		  } else {
			request.setAttribute("msg", "请选择上传的文件");
			request.getRequestDispatcher("/admin/category/picture/add.jsp").forward(request, response);
		  }
		}
	  } else {
		request.setAttribute("msg", "上传失败");
		request.getRequestDispatcher("/admin/category/picture/add.jsp").forward(request, response);
	  }

	  request.setAttribute("msg", "请录入相关演职人员");
	  return "/admin/movie/addCredits.jsp";
	} catch (FileUploadBase.FileSizeLimitExceededException e) {//每个文件的限制
	  request.setAttribute("msg", "每个文件不能超过20M");
	  request.getRequestDispatcher("/admin/category/picture/add.jsp").forward(request, response);
	} catch (FileUploadBase.SizeLimitExceededException e) { //总文件限制
	  request.setAttribute("msg", "总文件大小不能超过500M");
	  request.getRequestDispatcher("/admin/category/picture/add.jsp").forward(request, response);
	} catch (Exception e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "上传失败");
	  request.getRequestDispatcher("/admin/category/picture/add.jsp").forward(request, response);
	}
	return null;

  }

  public String addCredits(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
	Map<String, String[]> map = request.getParameterMap();
	Credits credits = new Credits();
	BeanUtils.populate(credits, map);
	credits.setId(UUIDUtils.getId());
	Movie movie = (Movie) request.getSession().getAttribute("movie");
	movie.setCredits_id(credits.getId());
	String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
	try {
	movie.setCredits(credits);
	movie.setCredits_id(credits.getId());
	movie.setCreate_time(date);
	  movieService.addMovie(movie);
	  movie.setScore(8.0);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg","添加影片失败");
	  return "/admin/movie/addCredits.jsp";
	}
	request.getSession().removeAttribute("movie");
	response.sendRedirect(request.getContextPath() + "/AdminMovieServlet?method=findMovie");
	return null;
  }

  public String editMovieUI(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	List<Type> typeList = new TypeServiceImpl().findAllType();
	List<Year> yearList = new YearServiceImpl().findYear();
	List<Area> areaList = new AreaServiceImpl().findArea();
	request.setAttribute("typeList", typeList);
	request.setAttribute("yearList", yearList);
	request.setAttribute("areaList", areaList);
	String id = request.getParameter("id");
	request.setAttribute("id",id);
	return "/admin/movie/edit.jsp";
  }

  public String editMovie(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String movieId = request.getParameter("movieId");
	String movieName = request.getParameter("movieName");
	String duration = request.getParameter("duration");
	String typeName = request.getParameter("typeName");
	String yearName = request.getParameter("yearName");
	String areaName = request.getParameter("areaName");
	String status = request.getParameter("status");
	Movie movie = new Movie();
	movie.setType_id(typeName);
	movie.setArea_id(areaName);
	movie.setDuration(duration);
	movie.setYears_id(yearName);
	movie.setFlag(Integer.parseInt(status));
	movie.setName(movieName);
	movie.setId(movieId);
	try {
	  movieService.editMovie(movie);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg","修改失败");
	  return "/admin/movie/edit.jsp";
	}
	response.sendRedirect(request.getContextPath() + "/AdminMovieServlet?method=findMovie");
	return null;
  }

}
