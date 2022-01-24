package com.freewater.mybatis.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class MybatisSpringBootDemoApplication {

    private String serverName = "localhost";

    @Value("${server.port}")
    private Integer port;

    @Value("${spring.h2.console.path}")
    private String h2Path;

    private final CityMapper cityMapper;

    public MybatisSpringBootDemoApplication(CityMapper cityMapper) {
        this.cityMapper = cityMapper;

    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(MybatisSpringBootDemoApplication.class).web(WebApplicationType.SERVLET).run(args);

    }

    @Bean
    CommandLineRunner sampleCommandLineRunner() {
        return args -> {
            log.info("H2 Web Console: http://" + serverName + ":" + port + h2Path);
            System.out.println(this.cityMapper.findByName("Chengdu"));
            City city = new City();
            city.setName("San Francisco");
            city.setState("CA");
            city.setCountry("US");
            cityMapper.insert(city);
            System.out.println(this.cityMapper.findById(city.getId()));
        };
    }
}
