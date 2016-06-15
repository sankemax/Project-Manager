package com.max.project.manager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.max.project.manager.dao.ProjectDao;

public class App {
	public static void main(String[] args) {
		
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		ProjectDao projectDao = (ProjectDao) context.getBean("projectDao");
		
		System.out.println(projectDao.get(1));

		((FileSystemXmlApplicationContext) context).close();
	}
}

		     