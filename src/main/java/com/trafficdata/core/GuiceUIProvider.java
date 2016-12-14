package com.trafficdata.core;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.trafficdata.TrafficAppUI;
import com.trafficdata.forms.IndexLayout;
import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;


public class GuiceUIProvider extends UIProvider{
    @Inject
    private Injector injector;

    @Override
    public TrafficAppUI createInstance(UICreateEvent event) {
        return injector.getInstance(TrafficAppUI.class);
    }

    @Override
    public Class<TrafficAppUI> getUIClass(UIClassSelectionEvent event) {
        return TrafficAppUI.class;
    }
}
