package com.trafficdata;

import javax.servlet.Servlet;

import com.trafficdata.core.GuiceUIProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class TrafficApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
		SpringApplication.run(TrafficApplication.class, args);
	}

    @Bean
    public RegistrationBean vaangularServlet(final org.springframework.context.ApplicationContext context)
    {
        final Servlet servlet = new JavaScriptPlusServlet(new GuiceUIProvider());
        return new ServletRegistrationBean(servlet, "/*");
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application)
    {
        return application.sources(TrafficApplication.class);
    }

}
