package com.maoyan.web.adminServlet;

import com.maoyan.entity.Picture;
import com.maoyan.service.MovieService;
import com.maoyan.service.PictureService;
import com.maoyan.service.serviceImpl.MovieServiceImpl;
import com.maoyan.service.serviceImpl.PictureServiceImpl;
import com.maoyan.util.UUIDUtils;
import com.maoyan.util.UploadUtils;
import com.maoyan.web.base.BaseServlet;
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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminPictureServlet", urlPatterns = "/AdminPictureServlet")
public class AdminPictureServlet extends BaseServlet {
  private PictureService pictureService = new PictureServiceImpl();

  public String findPicture(HttpServletRequest request, HttpServletResponse response) {
	String id = request.getParameter("id");
	List<Picture> pictureList = null;
	try {
	  pictureList = pictureService.findPicture(id);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "查询失败");
	  return "/admin/category/picture/list.jsp";
	}
	request.setAttribute("pictureList", pictureList);
	return "/admin/category/picture/list.jsp";
  }

  public String addPictureUI(HttpServletRequest request, HttpServletResponse response) {
    String id = request.getParameter("id");
    request.setAttribute("id",id);
	return "/admin/category/picture/add.jsp";
  }

  public String addPicture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	try {
	  DiskFileItemFactory factory = new DiskFileItemFactory();
	  ServletFileUpload upload = new ServletFileUpload(factory);
	  upload.setHeaderEncoding("utf-8");
	  upload.setFileSizeMax(1024 * 1024 * 20);
	  upload.setSizeMax(1024 * 1024 * 500);
	  List<FileItem> list = upload.parseRequest(request);
	  List<Picture> pictureList = new ArrayList<Picture>();
	  if (list != null) {
		Picture fileEntity = null;
		for (FileItem item : list) {
		  if (item != null && !item.equals("")) {
			if (item.isFormField()) {
			  //普通表单
			  fileEntity.setDescribe(item.getString("utf-8"));
			  pictureService.addPicture(fileEntity);
			  pictureList.add(fileEntity);
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
			  fileEntity.setMovie_id(id);
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
	  response.sendRedirect(request.getContextPath() + "/AdminPictureServlet?method=findPicture&id="+id);
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

  public String deleteAllPicture(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String id = request.getParameter("id");
	try {
	  pictureService.deleteAllPicture(id);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "删除失败");
	  return "/admin/category/picture/list.jsp";
	}
	response.sendRedirect(request.getContextPath() + "/AdminPictureServlet?method=findPicture");
	return null;
  }

  public String deletePicture(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String id = request.getParameter("id");
	String movieId = request.getParameter("movieId");
	try {
	  pictureService.deletePicture(id);
	} catch (SQLException e) {
	  e.printStackTrace();
	  request.setAttribute("msg", "删除失败");
	  return "/admin/category/picture/list.jsp";
	}
	response.sendRedirect(request.getContextPath() + "/AdminPictureServlet?method=findPicture&id="+movieId);
	return null;
  }

  public String download(HttpServletRequest request, HttpServletResponse response) throws SQLException {
	String id = request.getParameter("id");
	if (!(id == null && id.equals(""))) {
	  try {
		Picture file = pictureService.download(id);
		String fileName = file.getName();
		String path = file.getPath();
		InputStream in = this.getServletContext().getResourceAsStream(path);
		fileName = URLEncoder.encode(fileName, "utf-8");
		//对文件加密,解决中文乱码
		//user-agent 可以获取浏览器类型，操作系统类型等
		String userAgent = request.getHeader("user-agent");
		String content = "";
		//Trident为ie
		if (userAgent.contains("Trident")) {
		  //IE
		  content = "attachment;filename=" + fileName;
		} else {
		  //非IE
		  content = "attachment;filename*=" + fileName;
		}
		//通过响应头content-disposition,attachment;filename=文件名   让浏览器以下载方式打开资源
		response.setHeader("content-disposition", content);
		OutputStream out = response.getOutputStream();//以流响应给客户端
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = in.read(buf)) != -1) {
		  out.write(buf, 0, len);//把文件内容写出到浏览器
		}
		out.close();
		in.close();

	  } catch (SQLException | UnsupportedEncodingException e) {
		e.printStackTrace();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
	}
	return null;
  }


}
