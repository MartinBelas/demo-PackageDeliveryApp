package com.demo.parcelsInfoReader;

import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.demo.Parcel;
import com.demo.Store;

public class ParcelsInfoFromConsoleReader implements ParcelsInfoReader {

    private static final Logger log = LogManager.getLogger(ParcelsInfoFromConsoleReader.class);
    
    private static final String[] QUIT_READING = { "quit", "q" };

    private final Store store;

    public ParcelsInfoFromConsoleReader(Store store) {
        this.store = store;
    }

    @Override
    public void read() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            String input = "";
            String weightString = null;
            int firstWhiteSpace = -1;
            
            boolean isNumeric = false;
            while (!isNumeric) {
                
                System.out.println("\nPlease enter the package weight in kg and destination postal code separated by a space: ");
                
                input = sc.nextLine().trim();
                
                if (Arrays.asList(QUIT_READING).contains(input)) {
                    sc.close();
                    break;
                }
                
                firstWhiteSpace = getFirstWhiteSpaceIndex(input);
                
                if (firstWhiteSpace < 1) {
                    break;
                }
                
                weightString = input.substring(0, firstWhiteSpace).trim();
                
                isNumeric = NumberUtils.isParsable(weightString);
                if (!isNumeric) {
                    System.out.println("Weight must be a number.");
                }
            }
            
            if (Arrays.asList(QUIT_READING).contains(input)) {
                break;
            }
            
            if (firstWhiteSpace > 0) {
                final Float weight = Float.parseFloat(weightString);
                final String destinationPostalCode = input.substring(firstWhiteSpace).trim();
                store.put(new Parcel(weight, destinationPostalCode));
                log.info("New package stored.");
            }
        }
    }
    
    //TODO I haven't found better way recently.
    int getFirstWhiteSpaceIndex(String s) {
        
        s = s.trim();

        int firstSpace = s.indexOf(" ");
        int firstTab = s.indexOf("\t");
        
        if (firstSpace < 1 && firstTab < 1) {
            log.warn("Input must contain at least one white space char.");
            return -1;
        }

        int firstWhite = -1;
        
        if (firstSpace > 0)
            firstWhite = firstSpace;

        if ((firstWhite < 0 && firstTab > 0) || (firstWhite > 0 && firstTab > 0 && firstTab < firstWhite))
            firstWhite = firstTab;

        return firstWhite;
    }
}
