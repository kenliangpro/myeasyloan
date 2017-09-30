package com.easyloan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FileConfig extends WebMvcConfigurerAdapter{
	
	@Value("${web.headImg.upload-path}")
	private String headImgPath;
    @Value("${web.personalLoan.upload-path}")
	private String personalLoanImg;

    @Value("${web.userCertification.idNumber-ImgPath}")
    private String idNumberImgPath;
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/loanimg/**").addResourceLocations("file:" + headImgPath);
        registry.addResourceHandler("/personLoanImg/**").addResourceLocations("file:" + personalLoanImg);
        registry.addResourceHandler("/personalCertificationImg/**").addResourceLocations("file:" + idNumberImgPath);
        //配置模板资源路径
        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
        registry.addResourceHandler("/static").addResourceLocations("classpath:/static");
        registry.addResourceHandler("/templates").addResourceLocations("classpath:/templates");
        super.addResourceHandlers(registry);
    }
}
