package Topic15;

import org.apache.commons.math3.analysis.function.Multiply;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalTime;

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
    public void setBooked(boolean booked) {
        isBooked = booked;
    }
    public double calcCost(DateTime startTime, DateTime endTime) {
        DateTime night = new DateTime(2022,11,11,18,00);
        boolean isNight = startTime.getHourOfDay() >= 18;
        Duration duration = new Duration(startTime, endTime); //works out number of minutes * fare per minute
        Multiply multiply = new Multiply();
        double timeCost = multiply.value(duration.getStandardMinutes(), farePerMinute);
        if (!isNight) {
          double totalCost =  baseFare + timeCost;
          return totalCost;
        } else {
           double totalCost = baseFare + (timeCost*nightTimeFactor);
           return totalCost;
        }
        //double totalCost = isDay ? baseFare + (timeCost * nightTimeFactor): timeCost + baseFare; //ternary statement to include nighttime factor
       //return totalCost; //returns timefare + base fare
    }
}

