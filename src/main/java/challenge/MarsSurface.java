package challenge;

public class MarsSurface implements ISurface {
    private Coordinates _min;
    private Coordinates _max;
    private Coordinates robotPosition;
    private Moves[] movements;
    public MarsSurface(){
        _min = new Coordinates(0,0,0);
        _max = new Coordinates(4,4,0);
    }
    public boolean isLegalPosition(ICoordinates c) {
        int[] cxy = c.getPosition();
        int[] minxy = _min.getPosition();
        int[] maxxy = _max.getPosition();
        if(cxy[0] <= maxxy[0] && cxy[1] <= maxxy[1] && cxy[0] >= minxy[0] && cxy[1] >= minxy[1] ){
            return true;
        }
        return false;
    }
    public void setRobotMovements(IMoves[] m){
        movements = (Moves[]) m;
    }
    public void moveRobot(ICoordinates currentPostion) throws InvalidInput{
        Coordinates desiredPosition;
        Coordinates currentPosition = new Coordinates(currentPostion);
        int incX;
        int incY;
        for(Moves m: movements){
            if(m.getStep() > 0){
                incX = (int)Math.round(Math.cos(Math.toRadians(currentPosition.getOrientation())));
                incY = (int)Math.round(Math.sin(Math.toRadians(currentPosition.getOrientation())));
                desiredPosition = new Coordinates(currentPosition);
                desiredPosition.incrementPosition(incX,incY);
                if(!isLegalPosition(desiredPosition)){
                    throw new InvalidInput("");
                }else{
                    currentPosition = new Coordinates(desiredPosition);
                }
            }
            if(m.getRotation() != 0){
                currentPosition.incrementOrientation(m.getRotation());
            }
        }
        robotPosition = new Coordinates(currentPosition);
    }
    public ICoordinates getRobotFinalPostion(){
        return robotPosition;
    }

}
