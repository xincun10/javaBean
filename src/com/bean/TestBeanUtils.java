package com.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/**
 * 演示BeanUtils类
 *
 */
public class TestBeanUtils {

	@Test
	public void fun1() throws Exception
	{
		String className = "com.bean.Person";
		Class clazz = Class.forName(className);
		Object bean = clazz.newInstance();
		
		BeanUtils.setProperty(bean, "name", "zhangsan");
		BeanUtils.setProperty(bean, "age", 20);
		BeanUtils.setProperty(bean, "gender", "男");
		
		String age = BeanUtils.getProperty(bean, "age");
		
		System.out.println(bean);
		System.out.println(age);
	}
	
	//把map中的属性直接封装到一个bean中
	/*
	 * Map:{"username":"zhangsan", "password":"123"}
	 * 我们要把map的数据封装到一个javabean中，要求map的key与bean的属性名相同！
	 */
	@Test
	public void fun2() throws Exception
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "zhangsan");
		map.put("password", "123");
		
		User user = new User();
		BeanUtils.populate(user, map);
		System.out.println(user);
	}
	
	//调用封装的方法
	@Test
	public void fun3()
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "zhangsan");
		map.put("password", "123");
		
		User user = CommonUtils.toBean(map, User.class);
		System.out.println(user);
	}
}
