package com.trafficdata.TrafficDataCollector;

import com.trafficdata.Models.LocationPair;
import com.trafficdata.Models.TripInformation;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;
import com.google.maps.model.TravelMode;
import com.google.maps.model.Unit;
import com.trafficdata.Repositories.LocationPairRepository;
import com.trafficdata.Repositories.TripInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by minhmo on 12/8/16.
 */
@Component
@Scope("singleton")
public class DataCollector implements com.trafficdata.core.IDataCollector {

    private final GeoApiContext context;
    
    @Autowired
    private LocationPairRepository _locationPairRepository;

    @Autowired
    private TripInformationRepository _tripInformationRepository;


    public DataCollector(){
        context = new GeoApiContext().setApiKey(API_KEY);
        DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(context);
        DistanceMatrixApi.getDistanceMatrix(context,new String [] {"test"}, new String[] {"test"});
    }

    private TripInformation fillTripInformation(LocationPair location, DistanceMatrixRow row) {
        TripInformation tripInformation = new TripInformation();
        tripInformation.setFrom(location.getOrigin());
        tripInformation.setTo(location.getDestination());

        tripInformation.setEstimatedSeconds((int) row.elements[0].duration.inSeconds);
        tripInformation.setEstimationTime(new Date());
        return tripInformation;
    }

    private DistanceMatrixApiRequest initRequest(LocationPair location) {
        DistanceMatrixApiRequest request = DistanceMatrixApi.newRequest(context);
        request.destinations(location.getDestination().getAdress());
        request.origins(location.getOrigin().getAdress());
        request.mode(TravelMode.DRIVING);
        request.units(Unit.METRIC);
        return request;
    }

    @Override
    public void CollectData() throws Exception {
        List<LocationPair> allLocations = _locationPairRepository.findAll();

        for (LocationPair location : allLocations)
        {
            DistanceMatrixApiRequest request = initRequest(location);
            DistanceMatrix response = request.await();

            TripInformation tripInformation = fillTripInformation(location, response.rows[0]);
            _tripInformationRepository.save(tripInformation);

        }
    }
}

