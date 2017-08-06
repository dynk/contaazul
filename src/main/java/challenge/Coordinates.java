package challenge;

public class Coordinates {
    private int _x;
    private int _y;
    private int _orientation;
    public Coordinates(){};
    public Coordinates(int x, int y, int orientation){
        _x = x;
        _y = y;
        _orientation = orientation;
    }
    public Coordinates(Coordinates c){
        int[] xy = c.getXYPosition();
        _x = xy[0];
        _y = xy[1];
        _orientation = c.getOrientation();
    }
    public void setXYPosition(int x, int y) {
        _x = x;
        _y = y;
    }
    public void setOrientation(int orientation){
        _orientation = orientation;
    }
    public void incrementOrientation(int orientation){
        _orientation = (_orientation + orientation)%360;
    }

    public int getOrientation(){
        return _orientation;
    }

    public int[] getXYPosition() {
        int[] xy = {_x,_y};
        return xy;
    }
    public void incrementXY(int x, int y){
        _x = _x + x;
        _y = _y + y;

    }

}



























