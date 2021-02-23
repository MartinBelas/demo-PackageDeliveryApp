package com.demo.storeHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.demo.Parcel;
import com.demo.Store;

public class ParcelsInfoFromFileReader implements ParcelsInfoReader {

    private static final Logger log = LogManager.getLogger(ParcelsInfoFromFileReader.class);

    private final String filePath;
    private final Store store;

    public ParcelsInfoFromFileReader(String filePath, Store store) {
        this.filePath = filePath;
        this.store = store;
    }

    @Override
    public void run() {

        File inputFile = provideInputFile(this.filePath);
        if (!inputFile.exists()) {
            String errMsg = String.format("File %s does not exist.", inputFile);
            log.error(errMsg);
            System.exit(-1);
        }

        log.info("Reading from file: {}", inputFile.getAbsolutePath());

        try (FileInputStream inputStream = new FileInputStream(inputFile);
                Scanner sc = new Scanner(inputStream, "UTF-8");) {

            String line;
            while (sc.hasNextLine()) {
                
                //TODO remove in "production", it is here because of simulation of long lasting non-blocking reading operation 
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                line = sc.nextLine();
                if (!line.isEmpty()) {
                    String[] packageArray = line.split(",");
                    Validate.isTrue(packageArray.length == 2, "Incorrect input data for package.");
                    Parcel p = new Parcel(Float.parseFloat(packageArray[0]), packageArray[1].trim());
                    store.put(p);
                    log.debug("Imported parcel: {}", p);
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        log.info("The application was terminated correctly after reading from file.");
        System.exit(0);
    }

    private File provideInputFile(String inputFileName) {
        File f = new File(inputFileName);
        log.info("Input file name: {}", inputFileName);
        return f;
    }
}
