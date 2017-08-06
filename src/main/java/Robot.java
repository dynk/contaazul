public class Robot {
    private IReceiver _receiver;
    private Coordinates _gps;
    private ITranslator _translator;
    private ISurface _surface;
    private Moves[] _movements;
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
        _movements = _translator.string2moves(_receiver.getReceivedMessage());
    }
    public String executeAll(String message){
        try{
            listenMessage(message);
            isValidMessage();
            translateMessage();
            processRequest();
            return _translator.coordXY2string(_gps);
        }catch (Exception e){
            return "400 Bad Request";
        }


//        listenMessage(message);
//        if(!isValidMessage()){
//            throw new InvalidInput("400 Bad Request");
//        }
//        translateMessage(message);
//        processRequest();
//
//
//        return "teste";
    }
    public void processRequest() throws InvalidInput{
        Coordinates desiredPosition;
        Coordinates currentPosition = new Coordinates(_gps);
        int incX;
        int incY;
        for(Moves m:_movements){
            if(m.getStep() > 0){
                incX = (int)Math.round(Math.cos(Math.toRadians(currentPosition.getOrientation())));
                incY = (int)Math.round(Math.sin(Math.toRadians(currentPosition.getOrientation())));
                desiredPosition = new Coordinates(currentPosition);
                desiredPosition.incrementXY(incX,incY);
                if(!_surface.isLegalPosition(desiredPosition)){
                    throw new InvalidInput("");
                }else{
                    currentPosition = new Coordinates(desiredPosition);
                }
            }
            if(m.getRotation() != 0){
                currentPosition.incrementOrientation(m.getRotation());
            }
        }
        _gps = new Coordinates(currentPosition);
    }

    public String getPosition(){
        return _translator.coordXY2string(_gps);
    }
//    public String printPosition(){
//
//    }
//
}
