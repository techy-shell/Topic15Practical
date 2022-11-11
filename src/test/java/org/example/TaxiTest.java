package org.example;
import org.apache.commons.math3.analysis.function.Multiply;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class TaxiTest {

    private Taxi taxi;
    @BeforeEach
    public void setup(){
        taxi = new Taxi();
    }
    DateTime st = new DateTime(2022,11,11,14,10);
    DateTime et = new DateTime(2022,11,11,14,20);
    @org.junit.jupiter.api.Test
    void calcCost() {
        double result = taxi.calcCost((st),(et));
        assertEquals(10, result, "testing fare charge");
    }
}