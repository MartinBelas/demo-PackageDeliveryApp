package com.demo;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.demo.parcelsInfoReader.ParcelsInfoFromConsoleReader;
import com.demo.parcelsInfoReader.ParcelsInfoFromFileReader;
import com.demo.parcelsInfoReader.ParcelsInfoReader;


/**
 * 
 * @author Martin
 *
 */
public class App {
    
    private static final Logger log = LogManager.getLogger(App.class);
    
    private static Store store = new Store();
    
    public static void main(String[] args) {
        
        log.info("The Application started.");
        
        ParcelsInfoReader reader; 
        if (args.length > 0) {
            log.info("App. argument, file with packages to read from: {}", args[0]);
            reader = new ParcelsInfoFromFileReader(args[0], store);
        } else {
            reader = new ParcelsInfoFromConsoleReader(store);
        }

        log.info("Start reading info about new packages...");
        
        try {
            reader.read();  //TODO v novem vlakne
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } 
        
    }
}
