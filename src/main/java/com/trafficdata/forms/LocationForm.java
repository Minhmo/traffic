package com.trafficdata.forms;

import com.trafficdata.Models.Location;
import com.trafficdata.Repositories.LocationRepository;
import com.trafficdata.Services.LocationService;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ShortcutAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by minhmo on 12/10/16.
 */
@Component
public class LocationForm extends LocationPairLayout {

    private final BeanItemContainer<Location> dataSource;
    private Location location;

    @Autowired
    private LocationService _locationService;
    @Autowired
    private LocationRepository _locationRepository;


    public LocationForm() {
        dataSource = new BeanItemContainer<>(Location.class);
        table.setContainerDataSource(dataSource);
        resetForm();

        save.addClickListener(click->{
            try {
                _locationService.SaveLocation(location);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dataSource.addBean(location);
            resetForm();
        });
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        cancel.addClickListener(cancel ->{
            resetForm();
        });
    }

    @PostConstruct
    private void initForm(){
        dataSource.removeAllItems();
        dataSource.addAll(_locationRepository.findAll());

    }

    private void resetForm() {
        location = new Location();
        BeanFieldGroup.bindFieldsUnbuffered(location, this);
    }
}
