package org.example;

import java.util.HashMap;
import java.util.Map;

public class AcmeService {

    public Map<String, String> getAcme() {
        Map<String, String> result = new HashMap<>();
        result.put("service", AcmeService.class.getSimpleName());
        return result;
    }

}
