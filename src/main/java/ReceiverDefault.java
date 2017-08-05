public class ReceiverDefault implements IReceiver {
    public boolean isValidMessage(String message) {
        if(message.length() == 0){
            return false;
        }
        for(int i = 0; i<message.length();i++){
            Character comp = message.toLowerCase().charAt(i);
            if(comp != 'l' && comp != 'r' && comp != 'm'){
                return false;
            }
        }
        return true;
    }

    public String[] translateMessage() {
        return new String[0];
    }
}
