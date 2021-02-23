package com.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.demo.storeHandler.ParcelsInfoConsoleWriter;
import com.demo.storeHandler.ParcelsInfoFromConsoleReader;
import com.demo.storeHandler.ParcelsInfoFromFileReader;
import com.demo.storeHandler.ParcelsInfoReader;


/**
 * 
 * @author Martin
 *
 */
public class App {
    
    private static final Logger log = LogManager.getLogger(App.class);

    private static Store store = new Store();
    
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        
        log.info("The Application started.");
        
        ParcelsInfoReader reader; 
        if (args.length > 0) {
            log.info("App. argument, file with packages to read from: {}", args[0]);
            reader = new ParcelsInfoFromFileReader(args[0], store);
        } else {
            reader = new ParcelsInfoFromConsoleReader(store);
        }

        log.info("Start reading info about new packages...");
        
        executorService.submit(reader);
        
        ScheduledExecutorService schExecutorService = Executors.newScheduledThreadPool(5);
        schExecutorService.scheduleAtFixedRate(new ParcelsInfoConsoleWriter(store), 0, 10, TimeUnit.SECONDS);
    }
}
