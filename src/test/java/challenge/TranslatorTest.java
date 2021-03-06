package challenge;

import challenge.Coordinates;
import challenge.Moves;
import challenge.Translator;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class TranslatorTest {
    Translator trans = new Translator();

    @Test
    public void string2moves() throws Exception {
        HashMap<Character, Moves> movesMap = new HashMap();
        movesMap.put('M', new Moves(1,0));
        movesMap.put('L', new Moves(0,90));
        movesMap.put('R', new Moves(0,-90));

        String message = "MMM";
        Moves[] moves = trans.string2moves(message);
        for(int i = 0; i < message.length(); i++){
            Character key = message.charAt(i);
            assertEquals(movesMap.get(key).getRotation(),moves[i].getRotation());
            assertEquals(movesMap.get(key).getStep(),moves[i].getStep());
        }
        message = "LRLL";
        moves = trans.string2moves(message);
        for(int i = 0; i < message.length(); i++){
            Character key = message.charAt(i);
            assertEquals(movesMap.get(key).getRotation(),moves[i].getRotation());
            assertEquals(movesMap.get(key).getStep(),moves[i].getStep());
        }
        message = "LLRMLRMLMMRMMLMRLMRLMRMMMLRMRLMRLMRLMRLMRLMMRLL";
        moves = trans.string2moves(message);
        for(int i = 0; i < message.length(); i++){
            Character key = message.charAt(i);
            assertEquals(movesMap.get(key).getRotation(),moves[i].getRotation());
            assertEquals(movesMap.get(key).getStep(),moves[i].getStep());
        }

    }



    @Test
    public void coordXY2string() throws Exception {
        HashMap<String, Coordinates> coordMap = new HashMap();
        coordMap.put("(0, 0, N)",new Coordinates(0,0,90));
        coordMap.put("(0, 0, N)",new Coordinates(0,0,-270));
        coordMap.put("(0, 2, W)",new Coordinates(0,2,180));
        coordMap.put("(0, 0, W)",new Coordinates(0,0,-180));
        coordMap.put("(1, 0, E)",new Coordinates(1,0,0));
        coordMap.put("(1, 0, E)",new Coordinates(1,0,0));
        coordMap.put("(1, 0, S)",new Coordinates(1,0,-90));
        coordMap.put("(3, 3, S)",new Coordinates(3,3,270));

        for(Map.Entry<String,Coordinates> e : coordMap.entrySet()){
            String v = e.getKey();
            Coordinates c = e.getValue();
            assertEquals(v,trans.coordXY2string(c));
        }

    }

    @Test
    public void translateOrientation() throws Exception {
        int[] East = {0};
        int[] North = {90,-270};
        int[] West = {180,-180};
        int[] South = {270,-90};
        for(int i:East){
            assertEquals("E", trans.translateOrientation(i));
        }
        for(int i:North){
            assertEquals("N", trans.translateOrientation(i));
        }
        for(int i:West){
            assertEquals("W", trans.translateOrientation(i));
        }
        for(int i:South){
            assertEquals("S", trans.translateOrientation(i));
        }
    }

}