package com.bean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/**
 * ��ʾBeanUtils��
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
		BeanUtils.setProperty(bean, "gender", "��");
		
		String age = BeanUtils.getProperty(bean, "age");
		
		System.out.println(bean);
		System.out.println(age);
	}
	
	//��map�е�����ֱ�ӷ�װ��һ��bean��
	/*
	 * Map:{"username":"zhangsan", "password":"123"}
	 * ����Ҫ��map�����ݷ�װ��һ��javabean�У�Ҫ��map��key��bean����������ͬ��
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
	
	//���÷�װ�ķ���
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
