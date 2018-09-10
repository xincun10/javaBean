package com.bean;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class CommonUtils {

	/*
	 * ��mapת����ָ�����͵�javaBean����
	 */
	public static <T>T toBean(Map map, Class<T> clazz)
	{
		try	{
			//1.����ָ�����͵�javabean����
			T bean = clazz.newInstance();
			//2.�����ݷ�װ��javabean����
			BeanUtils.populate(bean, map);
			//3.����javabean����
			return bean;
		} catch(Exception e){
			throw new RuntimeException(e);
		}		
	}
}
