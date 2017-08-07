package challenge;

public class Moves implements IMoves {
    private int _step;
    private int _rotation;

    public Moves(int step, int rotation){
        _step = step;
        _rotation = rotation;
    }
    public int getStep(){
        return _step;
    }
    public int getRotation(){
        return _rotation;
    }
}
