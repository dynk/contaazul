public interface IReceiver {
    public boolean isValidMessage();
    public void setReceivedMessage(String message);
    public String getReceivedMessage();
}
