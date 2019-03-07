package com.maoyan.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import java.util.Map;

public class MyBeanUtils {

  public static void populate(Object obj, Map<String, String[]> map) {
	try {
	  // 由于BeanUtils将字符串"1992-3-3"向user对象的setBithday();方法传递参数有问题,手动向BeanUtils注册一个时间类型转换器
	  //因为客服端传过来的是字符串，不知道转换为什么格式的时间，所以有时间格式的时候就需要手动注册一个时间类型转换器
	  // 1_创建时间类型的转换器
	  DateConverter dt = new DateConverter();
	  // 2_设置转换的格式
	  dt.setPattern("yyyy-MM-dd");
	  // 3_注册转换器
	  ConvertUtils.register(dt, java.util.Date.class);
	  BeanUtils.populate(obj, map);
	} catch (Exception e) {
	  throw new RuntimeException(e);
	}
  }

  public static void populateObject(Object obj, Map<String, Object> map) {
	try {
	  DateConverter dt = new DateConverter();
	  dt.setPattern("yyyy-MM-dd");
	  ConvertUtils.register(dt, java.util.Date.class);
	  BeanUtils.populate(obj, map);
	} catch (Exception e) {
	  throw new RuntimeException(e);
	}
  }

  public static <T> T populate(Class<T> clazz, Map<String, String[]> map) {
	try {

	  T obj = clazz.newInstance();
	  // 由于BeanUtils将字符串"1992-3-3"向user对象的setBithday();方法传递参数有问题,手动向BeanUtils注册一个时间类型转换器
	  // 1_创建时间类型的转换器
	  DateConverter dt = new DateConverter();
	  // 2_设置转换的格式
	  dt.setPattern("yyyy-MM-dd");
	  // 3_注册转换器
	  ConvertUtils.register(dt, java.util.Date.class);
	  BeanUtils.populate(obj, map);
	  return obj;
	} catch (Exception e) {
	  throw new RuntimeException(e);
	}
  }

}
