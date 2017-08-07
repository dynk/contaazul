package challenge;

import javax.swing.*;

public interface ISurface {
    public boolean isLegalPosition(ICoordinates c);
    public void setRobotMovements(IMoves[] m);
    public void moveRobot(ICoordinates currentPosition) throws Exception;
    public ICoordinates getRobotFinalPostion();
}
