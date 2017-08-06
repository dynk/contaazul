public class Robot {
    private IReceiver _receiver;
    private Coordinates _gps;
    private Translator _translator;
    private ISurface _surface;
    private Moves[] _movements;
    public Robot(IReceiver receiver, Translator translator, ISurface surface){
        _receiver = receiver;

        _translator = translator;
        _surface = surface;
        _gps = new Coordinates(0,0,90);
    }

    public void listenMessage(String message){
        _receiver.setReceivedMessage(message);
    }
    public boolean isValidMessage(){
        return _receiver.isValidMessage();
    }
    public void translateMessage(String message){
        _movements = _translator.string2moves(_receiver.getReceivedMessage());
    }
    public String executeAll(String message) throws InvalidInput {
        listenMessage(message);
        if(!isValidMessage()){
            throw new InvalidInput("400 Bad Request");
        }
        translateMessage(message);
        processRequest();


        return "teste";
    }
    public void processRequest()throws InvalidInput{
        Coordinates desiredPosition;
        Coordinates currentPosition = _gps;
        int incX;
        int incY;
        for(Moves m:_movements){
            if(m.getStep() > 0){
                incX = (int)Math.round(Math.sin(Math.toRadians(_gps.getOrientation())));
                incY = (int)Math.round(Math.cos(Math.toRadians(_gps.getOrientation())));
                desiredPosition = currentPosition;
                desiredPosition.incrementXY(incX,incY);
                if(_surface.isLegalPosition(desiredPosition)){
                    throw new InvalidInput("400 Bad Request");
                }else{
                    currentPosition = desiredPosition;
                }
            }
            if(m.getRotation() != 0){
                _gps.setOrientation(m.getRotation());
            }
        }
        _gps = currentPosition;
    }
//    public String printPosition(){
//
//    }
//
}
