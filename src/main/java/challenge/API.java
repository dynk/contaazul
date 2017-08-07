package challenge;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class API {


    @RequestMapping("/rest/mars/{command}")
    public String index(@PathVariable("command") String command) {
        IReceiver receiver = new ReceiverDefault();
        ITranslator translator = new Translator();
        ISurface surface = new MarsSurface();
        ICoordinates coordinates = new Coordinates(0,0,90);
        Robot robot = new Robot(receiver,translator,surface, coordinates);
        String result = robot.executeAll(command);

        return result;
    }

}
