package com.apporio.ubereats.mvp.di.others.events;

/**
 * Created by lenovo on 4/21/2018.
 */

public class LocationSessionEvent {

    public Double latitude;
    public Double longitude;
    public String geographic_location;


    public LocationSessionEvent(Double latitude, Double longitude, String geographic_location) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.geographic_location = geographic_location;

    }

    public LocationSessionEvent() {

    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getGeographic_location() {
        return geographic_location;
    }

    public void setGeographic_location(String geographic_location) {
        this.geographic_location = geographic_location;
    }
}
