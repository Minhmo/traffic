package com.trafficdata.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by minhmo on 12/7/16.
 */
@Document
public class TripInformation {
    @Id
    private String id;

    private Location from;

    private Location to;

    private int estimatedHours;

    private int estimatedSeconds;

    private int estimatedMinutes;

    private Date estimationTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(int estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public int getEstimatedSeconds() {
        return estimatedSeconds;
    }

    public void setEstimatedSeconds(int estimatedSeconds) {
        this.estimatedSeconds = estimatedSeconds;
    }

    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public void setEstimatedMinutes(int estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }

    public Date getEstimationTime() {
        return estimationTime;
    }

    public void setEstimationTime(Date estimationTime) {
        this.estimationTime = estimationTime;
    }
}
