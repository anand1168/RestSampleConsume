package com.selleniumexpress.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyRestAppInitlizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		Class[] config= {MyAppConfig.class};
		return config;
	}

	@Override
	protected String[] getServletMappings() {

		String[] str={"/"};
		
		return str;
	}

}
