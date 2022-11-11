package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

//need to write an array of taxis
//test hasAvailableTaxis if any taxis available - I decide whether all/some taxis are already booked
//test scenarios where no taxis, one available taxi, multiple available taxis
//test getNextTaxis to pull an available taxi
public class TaxiCompany {
    private static final Logger LOGGER = LogManager.getLogger(TaxiCompany.class.getName());
    private ArrayList<Taxi> taxis;
    public boolean hasAvailableTaxis() {
        boolean hasTaxi = false;
        for(Taxi taxi : taxis) {
            if(taxi.isBooked()) {
                LOGGER.info("Available taxi found " + taxi);
            }
        }
        return hasTaxi;
    }
    public Taxi getNextTaxi() {
        for(Taxi taxi : taxis) {
            if(taxi.isBooked()) {
                LOGGER.info("Available taxi found " + taxi);
                return taxi;
            }
        }
        return null;
    }
    public void addTaxi(Taxi taxi) {
        taxis.add(new Taxi());
    }
}
