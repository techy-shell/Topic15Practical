package org.example;

import org.apache.commons.math3.analysis.function.Multiply;
import org.joda.time.DateTime;
import org.joda.time.Duration;

//point of code is to work out how much the fare will be
//need to add taxis
//test calcCost works for different times - day & night
//nighttime means fare per minute is 1.5 of day fare so 1.25
public class Taxi {
    private boolean isBooked;
    private double baseFare = 5;
    private double farePerMinute = 0.5;
    private double nightTimeFactor = 1.5;
    public boolean isBooked() {
        return isBooked;
    }
    public void setBooked(boolean booked) { isBooked = booked;
    }
    public double calcCost(DateTime startTime, DateTime endTime) { //don't change this, 6pm is start of nighttime
        boolean isNight = startTime.isAfter(6);
        Duration duration = new Duration(endTime, startTime); //works out number of minutes * fare per minute
        Multiply multiply = new Multiply();
        double timeCost = multiply.value(duration.getStandardMinutes(), farePerMinute);
        double totalCost = isNight ? timeCost + baseFare * nightTimeFactor: timeCost + baseFare; //ternary statement to include nighttime factor
        return totalCost; //returns timefare + base fare
    }
}

