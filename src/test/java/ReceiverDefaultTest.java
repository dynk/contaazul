import challenge.ReceiverDefault;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceiverDefaultTest {
    ReceiverDefault _receiver = new ReceiverDefault();

    @Test
    public void setAndGetReceivedMessage() throws Exception {
        String message = "LMLRLM";
        _receiver.setReceivedMessage(message);
        assertEquals(message,_receiver.getReceivedMessage());
    }



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
            _receiver.setReceivedMessage(m);
            assertTrue(_receiver.isValidMessage());
        }
        for(String m : invalidMessages){
            _receiver.setReceivedMessage(m);
            assertFalse(_receiver.isValidMessage());
        }

    }

}