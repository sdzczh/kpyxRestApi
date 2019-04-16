package com.zh.program;

import com.zh.program.Common.authorization.AuthorizationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@MapperScan("com.zh.program.Dao")
public class ProgramApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgramApplication.class, args);
    }

    //mvc控制器
    @Configuration
    static class WebMvcConfigurer extends WebMvcConfigurerAdapter {
        //增加拦截器
        public void addInterceptors(InterceptorRegistry registry){
            registry.addInterceptor(new AuthorizationInterceptor())    //指定拦截器类
                    .addPathPatterns("/*");        //指定该类拦截的url
        }
    }

}
