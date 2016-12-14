package com.trafficdata;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.trafficdata.core.GuiceUIProvider;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.*;

import javax.servlet.annotation.WebServlet;


@Singleton
@VaadinServletConfiguration(ui = TrafficAppUI.class, productionMode = false, widgetset = "de.akquinet.engineering.vaadin.javascriptplus.JavaScriptPlusForVaadin")
public class JavaScriptPlusServlet extends VaadinServlet implements SessionInitListener{

    protected final GuiceUIProvider applicationProvider;
    @Inject
    public JavaScriptPlusServlet(GuiceUIProvider applicationProvider) {
        this.applicationProvider = applicationProvider;
    }

    private static final long serialVersionUID = 1L;


    @Override
    protected void servletInitialized() {
        getService().addSessionInitListener(this);
    }

    @Override
    public void sessionInit(SessionInitEvent event) throws ServiceException {
        event.getSession().addUIProvider(applicationProvider);
    }
}
