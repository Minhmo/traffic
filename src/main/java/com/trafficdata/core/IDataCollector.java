package com.trafficdata.core;

import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.model.DistanceMatrix;
import com.trafficdata.Models.LocationPair;
import com.trafficdata.Models.TripInformation;

import java.util.List;

/**
 * Created by minhmo on 12/13/16.
 */
public interface IDataCollector {
    String API_KEY = "AIzaSyCFQptX5uQQnREF_2v8xJB8NA4DQAZfcFo";

    void CollectData() throws Exception;
}
