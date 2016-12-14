package com.trafficdata.Repositories;

import com.trafficdata.Models.LocationPair;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by minhmo on 12/8/16.
 */
@Repository
public interface LocationPairRepository extends MongoRepository<LocationPair, String> {
}
