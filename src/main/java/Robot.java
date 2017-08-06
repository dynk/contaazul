public class Robot {
    private IReceiver _receiver;
    private Coordinates _gps;
    private ICpu _cpu;
    private Translator _translator;
    public Robot(IReceiver receiver, ICpu cpu, Translator translator){
        _receiver = receiver;
        _cpu = cpu;
        _translator = translator;
        _gps = new Coordinates(0,0,90);
    }

    public void listenMessage(String message){
        _receiver.setReceivedMessage(message);
    }
    public String executeCommand() throws InvalidInput {
        if(!_receiver.isValidMessage()){
            throw new InvalidInput("400 Bad Request");
        }

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
