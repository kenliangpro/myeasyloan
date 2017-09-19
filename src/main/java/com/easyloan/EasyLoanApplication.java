package com.easyloan;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />

/**
 * <tx:annotation-driven/> 就是支持事务注解的（@Transactional） 、<mvc:annotation-driven> 就是支持mvc注解的，说白了就是使Controller中可以使用MVC的各种注解。
 * @author ken_liang
 *
 */
@EnableCaching
@SpringBootApplication
public class EasyLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyLoanApplication.class, args);
	}
	
	/**
	 * 生成验证码配置类
	 * @return
	 */
	@Bean(name = "captchaProducer")
	public DefaultKaptcha getKaptchaBean(){  
        DefaultKaptcha defaultKaptcha=new DefaultKaptcha();  
        Properties properties=new Properties();  
        properties.setProperty("kaptcha.border", "yes");  
        properties.setProperty("kaptcha.border.color", "105,179,90");  
        properties.setProperty("kaptcha.textproducer.font.color", "blue");  
        properties.setProperty("kaptcha.image.width", "125");  
        properties.setProperty("kaptcha.image.height", "45");  
        properties.setProperty("kaptcha.session.key", "code");  
        properties.setProperty("kaptcha.textproducer.char.length", "4");  
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");          
        Config config=new Config(properties);  
        defaultKaptcha.setConfig(config);  
        return defaultKaptcha;  
    }
}
