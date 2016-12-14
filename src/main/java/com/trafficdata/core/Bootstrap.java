package com.trafficdata.core;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.trafficdata.JavaScriptPlusServlet;
import com.trafficdata.TrafficAppUI;

import javax.servlet.annotation.WebListener;

/**
 * Created by minhmo on 12/14/16.
 */
@WebListener
public class Bootstrap extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                serve("/*").with(JavaScriptPlusServlet.class);
            }
        });
    }
}
