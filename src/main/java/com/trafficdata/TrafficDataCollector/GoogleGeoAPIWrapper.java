package com.trafficdata.TrafficDataCollector;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.trafficdata.Models.Location;
import org.springframework.stereotype.Service;

/**
 * Created by minhmo on 12/11/16.
 */

@Service
public class GoogleGeoAPIWrapper {
    public static final String API_KEY = "AIzaSyA161XK-wPSnhxZWN_1k6V7eFIVrfQy8n4";
    private final GeoApiContext context;

    public GoogleGeoAPIWrapper(){
        context = new GeoApiContext().setApiKey(API_KEY);
    }

    public void fillLocationInfo(Location location) throws Exception {
        if (location.getAdress() != null){
            GeocodingResult[] results =  GeocodingApi.geocode(context, location.getAdress()).await();
            if (results.length > 0){
                location.setAdress(results[0].formattedAddress);
                location.setxCoordinate((float) results[0].geometry.location.lat);
                location.setyCoordinate((float) results[0].geometry.location.lng);
            }
        }
    }
}
