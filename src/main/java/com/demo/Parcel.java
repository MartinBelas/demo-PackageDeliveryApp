package com.demo;

public class Parcel {

    private Float weight;
    private String destinationPostalCode;
    
    public Parcel(Float weight, String destinationPostalCode) {
        this.weight = weight;
        this.destinationPostalCode = destinationPostalCode;
    }

    public Float getWeight() {
        return weight;
    }

    public String getDestinationPostalCode() {
        return destinationPostalCode;
    }
    
    @Override
    public String toString() {
        return String.format("Weight: %s, postal code: %s", this.weight, this.destinationPostalCode);
    }
}
