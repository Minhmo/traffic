package com.trafficdata.Models;

import com.trafficdata.core.IRootEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by minhmo on 12/6/16.
 */
@Document
public class Location implements IRootEntity {
    @Id
    public String id;

    public String adress;

    public String cityName;

    public String districtName;

    public float xCoordinate;

    public float yCoordinate;
    public Date additionDate;

    public Location(String adress, String cityName){
        this.adress = adress;
        this.cityName = cityName;
    }
    public Location(){}

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public float getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public float getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public String toString(){
        return "Location [id=" + id + ", address=" + adress + ", cityName=" + cityName  + "  ]";
    }

    @Override
    public Date getAdditionDate() {
        return additionDate;
    }

    @Override
    public void setAdditionDate(Date date) {
        additionDate = date;
    }
}
