package challenge;

public interface ITranslator {
    public String coordXY2string(ICoordinates coord);
    public String translateOrientation(int orientation);
    public Moves[] string2moves(String message);
}
