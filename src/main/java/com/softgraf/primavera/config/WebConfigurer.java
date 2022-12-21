package com.softgraf.primavera.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfigurer implements WebMvcConfigurer {
	
		//  "D:\\JAVA-Amanda\\primavera\\uploads"
		private final static String uploadDirectory = System.getProperty("user.dir") + "\\uploads";

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			
			registry.addResourceHandler("/uploads/**", "/images/**")
			.addResourceLocations("file:" + uploadDirectory + "\\", "classpath:\\static\\images\\" );
			
		}
		
}