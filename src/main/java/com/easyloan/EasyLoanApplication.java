package com.easyloan;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
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
@EnableScheduling
@MapperScan("com.easyloan.dao")
public class EasyLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyLoanApplication.class, args);

	}
	

}
