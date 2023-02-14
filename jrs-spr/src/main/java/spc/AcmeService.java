package spc;

import java.util.HashMap;
import java.util.Map;

public class AcmeService {

    public Map<String, String> getAcme() {
        Map<String, String> result = new HashMap<>();
        result.put(String.valueOf(this), AcmeService.class.getSimpleName());

        return result;
    }

}
