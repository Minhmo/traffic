package com.trafficdata.Services;

import com.trafficdata.Models.Location;
import com.trafficdata.Repositories.LocationRepository;
import com.trafficdata.TrafficDataCollector.GoogleGeoAPIWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by minhmo on 12/10/16.
 */
@Service
public class LocationService implements com.trafficdata.core.ILocationService {
    @Autowired
    private LocationRepository _locationRepository;

    @Autowired
    private GoogleGeoAPIWrapper _geolocationApiService;

    public void SaveLocation(Location location) throws Exception {
        location.setAdditionDate(new Date());
        _geolocationApiService.fillLocationInfo(location);
        _locationRepository.save(location);
    }
}
