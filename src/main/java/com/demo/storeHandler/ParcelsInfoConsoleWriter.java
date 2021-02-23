package com.demo.storeHandler;

import com.demo.Store;

public class ParcelsInfoConsoleWriter implements Runnable {
    
    private Store store;

    public ParcelsInfoConsoleWriter(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        
        System.out.println("-----------------------------");
        System.out.println("PARCELS STORE INFO: ");
        
        store.getPostalCodesInfo()
            .forEach((k, v) -> {
                System.out.println(String.format("   - Postal code: %s, total weight: %s: ", k, v));
            });
        
        System.out.println("-----------------------------");
    }

}
