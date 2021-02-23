package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Store {

    private Map<String, List<Parcel>> parcels = new ConcurrentHashMap<>();

    public void put(Parcel parcel) {

        if (parcels.containsKey(parcel.getDestinationPostalCode())) {
            parcels.get(parcel.getDestinationPostalCode()).add(parcel);
        } else {
            List<Parcel> parcelsForPostalCode = new ArrayList<>();
            parcelsForPostalCode.add(parcel);
            parcels.put(parcel.getDestinationPostalCode(), parcelsForPostalCode);
        }
    }

    public Map<String, Double> getPostalCodesInfo() {
        
        return parcels.entrySet().stream()
            .collect(
                Collectors.toMap(
                        e -> e.getKey(), 
                        e -> e.getValue().stream()
                            .mapToDouble(Parcel::getWeight)
                            .sum()));
    }
}
