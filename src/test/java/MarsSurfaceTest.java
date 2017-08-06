import challenge.Coordinates;
import challenge.MarsSurface;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarsSurfaceTest {
    MarsSurface mars = new MarsSurface();
    @Test
    public void isLegalPosition() throws Exception {
        Coordinates[] legalCoords = new Coordinates[3];
        Coordinates[] ilegalCoords = new Coordinates[3];
        legalCoords[0] = new Coordinates(0,0,0);
        legalCoords[1] = new Coordinates(4,4,0);
        legalCoords[2] = new Coordinates(3,2,0);
        ilegalCoords[0] = new Coordinates(-1,0,0);
        ilegalCoords[1] = new Coordinates(0,5,0);
        ilegalCoords[2] = new Coordinates(-1,9,0);
        for(Coordinates c: legalCoords){
            assertTrue(mars.isLegalPosition(c));
        }
        for(Coordinates c: ilegalCoords){
            assertFalse(mars.isLegalPosition(c));
        }


    }

}