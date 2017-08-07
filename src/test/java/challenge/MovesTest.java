package challenge;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovesTest {
    @Test
    public void getStep() throws Exception {
        Moves m = new Moves(1,0);
        assertEquals(1,m.getStep());
    }

    @Test
    public void getRotation() throws Exception {
        Moves m = new Moves(0,90);
        assertEquals(90,m.getRotation());
    }


}