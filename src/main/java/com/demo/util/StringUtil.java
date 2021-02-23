package com.demo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringUtil {

    private static final Logger log = LogManager.getLogger(StringUtil.class);
    
    //TODO I haven't found better way recently.
    public int getFirstWhiteSpaceIndex(String s) {
        
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
