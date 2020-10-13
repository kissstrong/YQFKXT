package com.yqfk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author cyz
 * @date 2020-10-12 11:02
 */
@Configuration
public class MyRestTemplate {

    @Bean
    public RestTemplate get(){
        return new RestTemplate();
    }
}
