package challenge;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinatesTest {
    @Test
    public void setGetPosition() throws Exception {
        Coordinates c = new Coordinates(1,2,90);
        assertEquals(1,c.getPosition()[0]);
        assertEquals(2,c.getPosition()[1]);
        assertEquals(90,c.getOrientation());
    }

    @Test
    public void setGetOrientation() throws Exception {
        Coordinates c = new Coordinates(0,0,0);
        c.setOrientation(90);
        assertEquals(90,c.getOrientation());

    }

    @Test
    public void incrementPosition() throws Exception {
        Coordinates c = new Coordinates(0,0,0);
        c.incrementPosition(1,2);
        assertEquals(1,c.getPosition()[0]);
        assertEquals(2,c.getPosition()[1]);
    }



    @Test
    public void incrementOrientation() throws Exception {
        Coordinates c = new Coordinates(0,0,0);
        c.incrementOrientation(90);
        assertEquals(90,c.getOrientation());
    }

}