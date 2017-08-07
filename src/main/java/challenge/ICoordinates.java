package challenge;

public interface ICoordinates {
    public void setPosition(int x, int y);
    public int[] getPosition();
    public void incrementPosition(int x, int y);
    public void setOrientation(int x);
    public int getOrientation();
    public void incrementOrientation(int orientation);
}
