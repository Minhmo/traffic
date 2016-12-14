package com.trafficdata;

import com.trafficdata.forms.IndexLayout;
import com.trafficdata.forms.LocationForm;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by minhmo on 12/10/16.
 */
@Theme("valo")
public class TrafficAppUI extends UI {

    private static final long serialVersionUID = 1L;

    @Autowired
    IndexLayout form;

    Navigator navigator;
    protected static final String MAINVIEW = "main";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Example");
        setContent(form);
    }


}
