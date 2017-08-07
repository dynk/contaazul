package challenge;

public class Robot {
    private IReceiver _receiver;
    private ICoordinates _gps;
    private ITranslator _translator;
    private ISurface _surface;
    public Robot(IReceiver receiver, ITranslator translator, ISurface surface){
        _receiver = receiver;
        _translator = translator;
        _surface = surface;
        _gps = new Coordinates(0,0,90);
    }

    public void listenMessage(String message){
        _receiver.setReceivedMessage(message);
    }
    public boolean isValidMessage() throws InvalidInput{
        if(!_receiver.isValidMessage()){
            throw new InvalidInput("");
        }
        return _receiver.isValidMessage();
    }
    public void translateMessage(){
        _surface.setRobotMovements(_translator.string2moves(_receiver.getReceivedMessage()));
    }
    public void processRequest() throws InvalidInput{
        try{
            _surface.moveRobot(_gps);
            _gps = _surface.getRobotFinalPostion();
        }catch(Exception e){
            throw new InvalidInput("");
        }
    }
    public String getPosition(){
        return _translator.coordXY2string(_gps);
    }

    public String executeAll(String message){
        try{
            listenMessage(message);
            isValidMessage();
            translateMessage();
            processRequest();
            return getPosition();
        }catch (Exception e){
            return "400 Bad Request";
        }

    }



}
