package com.hello.spring;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class MainApp {
	private static ApplicationContext context;

	public static void main(String[] args) {
		
		//Spring BeanFatory Container
		
		XmlBeanFactory factory = new XmlBeanFactory (new ClassPathResource("Beans.xml"));
		HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
		obj.setMessage("Con ga di lac");
		obj.getMessage();
		
		HelloWorld obj1 = (HelloWorld) factory.getBean("helloWorld");
		obj1.getMessage();
		
		//Spring ApplicationContext Container
		
		context = new FileSystemXmlApplicationContext
				("D:\\java\\git\\java-training\\SpringExample\\src\\Beans.xml");
		HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld");
		obj2.getMessage();
	}
}
