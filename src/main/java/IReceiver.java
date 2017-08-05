public interface IReceiver {
    public boolean isValidMessage(String message);
    public String[] translateMessage();
}
