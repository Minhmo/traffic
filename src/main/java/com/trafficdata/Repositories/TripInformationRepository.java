package com.trafficdata.Repositories;

import com.trafficdata.Models.TripInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by minhmo on 12/7/16.
 */
@Repository
public interface TripInformationRepository extends MongoRepository<TripInformation, String> {
}
