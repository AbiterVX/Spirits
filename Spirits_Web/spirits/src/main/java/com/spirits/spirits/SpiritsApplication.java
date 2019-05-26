package com.spirits.spirits;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpiritsApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(SpiritsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(this.getClass());
    }
}


/*
http://localhost:9999/
http://www.abitervx.top:9999/
*/

/*
@MapperScan("com.spirits.spirits.dao")
@ComponentScan(basePackages={"com.spirits.spirits.controller","com.spirits.spirits.service"})
*/
