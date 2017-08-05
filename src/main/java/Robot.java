public class Robot {
    private IReceiver _receiver;
    private Coordinates _gps;
    private ICpu _cpu;
    public Robot(IReceiver receiver, Coordinates gps, ICpu cpu){
        _receiver = receiver;
        _gps = gps;
        _cpu = cpu;
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
