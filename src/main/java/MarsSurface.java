public class MarsSurface implements ISurface {
    private Coordinates _min;
    private Coordinates _max;
    public MarsSurface(){
        _min = new Coordinates(0,0,0);
        _max = new Coordinates(5,5,0);
    }
    public boolean isLegalPosition(Coordinates c) {
        int[] cxy = c.getXYPosition();
        int[] minxy = _min.getXYPosition();
        int[] maxxy = _max.getXYPosition();
        if(cxy[0] < minxy[0] || cxy[1] < minxy[1] ||cxy[0] > minxy[0] ||cxy[1] > minxy[1] ){
            return false;
        }
        return true;
    }
}
