import challenge.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RobotTest {



    IReceiver receiver = new ReceiverDefault();
    Translator translator = new Translator();
    ISurface surface = new MarsSurface();
    Robot robot = new Robot(receiver,translator,surface);



    @Test(expected = InvalidInput.class)
    public void checkInvalidMessage() throws Exception {
        robot.listenMessage("MMLRT");
        robot.isValidMessage();
    }

    @Test(expected = InvalidInput.class)
    public void processBadRequest() throws Exception {
        robot.listenMessage("MMMMMMMMMMMM");
        robot.translateMessage();
        robot.processRequest();
    }

    @Test
    public void executeAll() throws Exception {
//        Legal inputs
        HashMap<String,String> inpOutMap = new HashMap<String, String>();
        inpOutMap.put("M","(0, 1, N)");
        inpOutMap.put("MM","(0, 2, N)");
        inpOutMap.put("MMMM","(0, 4, N)");
        inpOutMap.put("R","(0, 0, E)");
        inpOutMap.put("RR","(0, 0, S)");
        inpOutMap.put("RRR","(0, 0, W)");
        inpOutMap.put("RRRR","(0, 0, N)");
        inpOutMap.put("L","(0, 0, W)");
        inpOutMap.put("LL","(0, 0, S)");
        inpOutMap.put("LLL","(0, 0, E)");
        inpOutMap.put("LLLL","(0, 0, N)");
        inpOutMap.put("MRMLMRM","(2, 2, E)");
        inpOutMap.put("MRMLMRMRMMRMM","(0, 0, W)");
        inpOutMap.put("MMMMRMMMM","(4, 4, E)");
        inpOutMap.put("MRMLMRMLMRMLMRML","(4, 4, N)");

        for(Map.Entry<String,String> e : inpOutMap.entrySet()){
            String input = e.getKey();
            String output = e.getValue();
            String result;
            Robot robot = new Robot(receiver,translator,surface);
            result = robot.executeAll(input);
            assertEquals(output,result);
        }

        HashMap<String,String> inpOutMapIlegal = new HashMap<String, String>();
        String badRequest = "400 Bad Request";
        inpOutMapIlegal.put("",badRequest);
        inpOutMapIlegal.put("MMMMM",badRequest);
        inpOutMapIlegal.put("LM",badRequest);
        inpOutMapIlegal.put("LLM",badRequest);
        inpOutMapIlegal.put("RRM",badRequest);
        inpOutMapIlegal.put("RRRM",badRequest);

        for(Map.Entry<String,String> e : inpOutMapIlegal.entrySet()){
            String input = e.getKey();
            String output = e.getValue();
            String result;
            Robot robot = new Robot(receiver,translator,surface);
            result = robot.executeAll(input);
            assertEquals(output,result);
        }

    }




}