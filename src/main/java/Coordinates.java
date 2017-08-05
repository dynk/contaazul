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
    public void setXYPosition(int x, int y) {
        _x = x;
        _y = y;
    }
    public void set_orientation(int orientation){
        _orientation = orientation;
    }

    public int get_orientation(){
        return _orientation;
    }

    public int[] getXYPosition() {
        int[] xy = {_x,_y};
        return xy;
    }
}



























