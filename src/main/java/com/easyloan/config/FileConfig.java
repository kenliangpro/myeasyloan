package com.easyloan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FileConfig extends WebMvcConfigurerAdapter{
	
	@Value("${web.upload-path}")
	private String path;
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/loanimg/**").addResourceLocations("file:" + path);
        //配置模板资源路径
        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
        registry.addResourceHandler("/static").addResourceLocations("classpath:/static");
        super.addResourceHandlers(registry);
    }
}
