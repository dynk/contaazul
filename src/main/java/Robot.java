public class Robot {
    IReceiver _receiver;
    ICoordinates _position;
    ICpu _cpu;
    public Robot(IReceiver receiver, ICoordinates position, ICpu cpu){
        _receiver = receiver;
        _position = position;
        _cpu = cpu;
    }
}
