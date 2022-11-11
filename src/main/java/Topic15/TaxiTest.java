package Topic15;
import Topic15.Taxi;
import org.joda.time.DateTime;
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
        Assertions.assertEquals(10, result, "testing fare charge");
    }
}