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
    public String processRequest(){

        return "teste";
    }
//    public String printPosition(){
//
//    }
//
}
