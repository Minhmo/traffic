package com.trafficdata.forms;

import com.trafficdata.Models.Location;
import com.trafficdata.Repositories.LocationPairRepository;
import com.trafficdata.Repositories.LocationRepository;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.ComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;

/**
 * Created by minhmo on 12/12/16.
 */
@Component
public class LocationPairForm extends LocationPair {

    private BeanItemContainer<com.trafficdata.Models.Location> locationPairBeanItemContainerFrom;
    private BeanItemContainer<Location> locationBeanItemContainerTo;

    private BeanItemContainer<com.trafficdata.Models.LocationPair> locationPairBeanItemContainer;
    private String originAdressField ="origin.adress";
    private String destinationAddressField= "destination.adress";


    @Autowired
    private LocationPairRepository _locationPairRep;
    @Autowired
    private LocationRepository _locationRep;


    private com.trafficdata.Models.LocationPair location;

    public LocationPairForm() {

        saveButton.addClickListener(event -> {
            com.trafficdata.Models.LocationPair pair = new com.trafficdata.Models.LocationPair();
            Location entity = (Location) from.getValue();
            pair.setOrigin(_locationRep.findOne(entity.getId()));

            Location toEntity = (Location) to.getValue();
            pair.setDestination(_locationRep.findOne(toEntity.getId()));
            _locationPairRep.save(pair);

            locationPairBeanItemContainer.addBean(pair);
        });

        deleteSelected.addClickListener(event ->{
           com.trafficdata.Models.LocationPair entity = (com.trafficdata.Models.LocationPair) pairTable.getValue();
            _locationPairRep.delete(entity.getId());
            locationPairBeanItemContainer.removeItem(entity.getId());
        });

        deleteAll.addClickListener(event->{
            _locationPairRep.deleteAll();
            initForm();
        });

    }

    @PostConstruct
    public void initForm() {

        initComboBoxes();
        initLocationPairTable();

        locationPairBeanItemContainer.removeAllItems();
        locationBeanItemContainerTo.removeAllItems();
        locationPairBeanItemContainerFrom.removeAllItems();

        locationBeanItemContainerTo.addAll(_locationRep.findAll());
        locationPairBeanItemContainerFrom.addAll(_locationRep.findAll());
        locationPairBeanItemContainer.addAll(_locationPairRep.findAll());
    }

    private void initComboBoxes() {
        locationPairBeanItemContainerFrom = new BeanItemContainer<>(Location.class);
        locationBeanItemContainerTo = new BeanItemContainer<>(Location.class);

        from.setContainerDataSource(locationPairBeanItemContainerFrom);
        from.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
        from.setItemCaptionPropertyId("adress");

        to.setContainerDataSource(locationPairBeanItemContainerFrom);
        to.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
        to.setItemCaptionPropertyId("adress");
    }

    private void initLocationPairTable() {
        locationPairBeanItemContainer = new BeanItemContainer<>(com.trafficdata.Models.LocationPair.class);
        locationPairBeanItemContainer.addNestedContainerProperty(originAdressField);
        locationPairBeanItemContainer.addNestedContainerProperty(destinationAddressField);
        pairTable.setColumnHeader(originAdressField, "Origin address");
        pairTable.setColumnHeader(destinationAddressField, "Destination address");
        pairTable.setContainerDataSource(locationPairBeanItemContainer);
        pairTable.setVisibleColumns(new Object[]{originAdressField, destinationAddressField});
    }

    private void fillComboBox(Collection<com.trafficdata.Models.Location> data, ComboBox box) {

        for (com.trafficdata.Models.Location pair : data) {
            box.addItem(pair.getId());
            box.setItemCaption(pair.getId(), pair.getAdress());
        }
    }
}
