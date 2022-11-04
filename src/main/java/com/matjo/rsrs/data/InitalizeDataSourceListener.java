package com.matjo.rsrs.data;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;



@WebListener
public class InitalizeDataSourceListener implements ServletContextListener {
	private static final String JDBC_FILE_PATH = "/WEB-INF/classes/jdbc.properties";
	

    public void contextDestroyed(ServletContextEvent event)  { 
        
    }

    
    public void contextInitialized(ServletContextEvent event)  { 
    	ServletContext context = event.getServletContext();
        InputStream is = null;
        try {
        	is = context.getResourceAsStream(JDBC_FILE_PATH);
        	Properties prop = new Properties();
        	prop.load(is);
        	
        	String jdbcDriver = prop.getProperty("jdbc.driver");
        	String jdbcUrl = prop.getProperty("jdbc.url");
        	String jdbcUser = prop.getProperty("jdbc.user");
        	String jdbcPasswd = prop.getProperty("jdbc.passwd");
        	
        	DataSource dataSource = new DataSource(jdbcDriver, jdbcUrl, jdbcUser, jdbcPasswd);
        	
        	NamingService namingService = NamingService.getInstance();
        	namingService.setAttribute("dataSource", dataSource);
        	
        	
        	System.out.println("DataSource has been initlized.");
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
	
}
