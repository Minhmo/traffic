package com.trafficdata.Repositories;

import com.trafficdata.Models.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by minhmo on 12/7/16.
 */
@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
}
