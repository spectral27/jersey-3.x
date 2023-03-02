package spc;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class AcmeService {

    public void serviceMethod(Map<String, String> input) {
        input.put(AcmeService.class.getName(), LocalTime.now().withNano(0).toString());
    }

}
