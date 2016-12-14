package com.trafficdata;

import com.mongodb.MongoClient;
import com.trafficdata.Services.LocationService;
import com.trafficdata.forms.IndexLayout;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.server.SpringVaadinServlet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class AppConfig {

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoClient mongoClient = new MongoClient("localhost");
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, "test");
        return new MongoTemplate(mongoDbFactory);
    }
    @Bean
    VaadinServlet vaadinServlet(){
        return new SpringVaadinServlet();
    }

    @Bean
    IndexLayout indexLayout(){
        return new IndexLayout();
    }
}
