package com.trafficdata.Scheduler;

import com.trafficdata.Models.Location;
import com.trafficdata.Models.LocationPair;
import com.trafficdata.Repositories.LocationPairRepository;
import com.trafficdata.Repositories.LocationRepository;
import com.trafficdata.TrafficDataCollector.DataCollector;
import com.trafficdata.core.IDataCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * Created by minhmo on 12/12/16.
 */
@Component
public class CollectTravelTimes {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LocationPairRepository _locationPairRep;

    @Autowired
    LocationRepository _locationRep;

    @Autowired
    IDataCollector _dataCollector;

    @Scheduled(cron = "0 0/5 12 * * ?")
    public void cronJob(){
        logger.info("> Cron job");
        logger.info("Startin Collecting travel times: ");

        try {
            _dataCollector.CollectData();
        } catch (Exception e) {
            logger.info("data collecting exception");
            logger.info(e.getMessage());
        }
        logger.info("< Job Completed");

    }
}
