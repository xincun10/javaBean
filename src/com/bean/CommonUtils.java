package com.bean;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class CommonUtils {

	/*
	 * 把map转换成指定类型的javaBean对象
	 */
	public static <T>T toBean(Map map, Class<T> clazz)
	{
		try	{
			//1.创建指定类型的javabean对象
			T bean = clazz.newInstance();
			//2.把数据封装到javabean里面
			BeanUtils.populate(bean, map);
			//3.返回javabean对象
			return bean;
		} catch(Exception e){
			throw new RuntimeException(e);
		}		
	}
}
