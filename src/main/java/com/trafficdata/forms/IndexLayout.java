package com.trafficdata.forms;

import com.trafficdata.Models.Location;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by minhmo on 12/12/16.
 */
@Component
@Scope("prototype")
public class IndexLayout extends Index {

    @Autowired
    private LocationForm _locationForm;

    @Autowired
    private LocationPairForm _locationPairForm;

    public IndexLayout(){
    }

    @PostConstruct
    private void init() {
        menuButton1.addClickListener(event -> {
            scroll_panel.setContent(_locationForm);
        });
        menuButton2.addClickListener(event -> {
            _locationPairForm.initForm();
            scroll_panel.setContent(_locationPairForm);
        });
    }


}
