import org.junit.Test;

import static org.junit.Assert.*;

public class ReceiverDefaultTest {

    ReceiverDefault _receiver = new ReceiverDefault();

    @Test
    public void isValidMessage() throws Exception {
        String[] validMessages = new String[3];
        String[] invalidMessages = new String[3];
        validMessages[0] = "m";
        validMessages[1] = "MlmlmrlrmrlrmrlrmrllMMlllrM";
        validMessages[2] = "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM";
        invalidMessages[0] = "";
        invalidMessages[1] = "k";
        invalidMessages[2] = "MLMLMLMLKMLRLMR";
        for(String m : validMessages){
            assertTrue(_receiver.isValidMessage(m));
        }
        for(String m : invalidMessages){
            assertFalse(_receiver.isValidMessage(m));
        }

    }

}