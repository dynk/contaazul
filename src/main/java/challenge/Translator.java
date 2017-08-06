package challenge;

public class Translator implements ITranslator{
    public Translator(){};
    public String coordXY2string(Coordinates coord){
        int[] xy = coord.getXYPosition();
        String orientation = translateOrientation(coord.getOrientation());

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(xy[0]);
        sb.append(", ");
        sb.append(xy[1]);
        sb.append(", ");
        sb.append(orientation);
        sb.append(")");

        return sb.toString();
    }

    public String translateOrientation(int orientation){
        String result;
        int value = orientation%360;
        switch(value) {
            case 0 :
                result = "E";
                break; // optional

            case 90 :
            case -270 :
                result = "N";
                break;
            case 180 :
            case -180 :
                result = "W";
                break;
            case 270 :
            case -90 :
                result = "S";
                break;

            default :
                result = "N";
        }
        return result;
    }

    public Moves[] string2moves(String message){

        Moves[] moves = new Moves[message.length()];
        for(int i = 0; i < message.length(); i++){

            switch (message.charAt(i)){
                case 'M':
                case 'm':
                   moves[i] = new Moves(1,0);
                   break;
                case 'L':
                case 'l':
                    moves[i] = new Moves(0,90);
                    break;
                case 'R':
                case 'r':
                    moves[i] = new Moves(0,-90);
                    break;
                default:
                    moves[i] = new Moves(0,0);
            }
        }
        return moves;
    }


}
