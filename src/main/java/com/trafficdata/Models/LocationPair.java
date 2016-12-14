package com.trafficdata.Models;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by minhmo on 12/8/16.
 */
@Document
public class LocationPair {
    @org.springframework.data.annotation.Id
    private String Id;

    public Location origin;

    public Location destination;

    public Location getOrigin() {
        return origin;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }
}
