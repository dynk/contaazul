package challenge;

public class ReceiverDefault implements IReceiver {
    private String _message;
    public boolean isValidMessage() {
        int size = _message.length();
        if(size == 0){
            return false;
        }
        for(int i = 0; i<size;i++){
            Character comp = _message.toLowerCase().charAt(i);
            if(comp != 'l' && comp != 'r' && comp != 'm'){
                return false;
            }
        }
        return true;
    }

    public void setReceivedMessage(String message) {
        _message = message;
    }

    public String getReceivedMessage() {
        return _message;
    }


}
