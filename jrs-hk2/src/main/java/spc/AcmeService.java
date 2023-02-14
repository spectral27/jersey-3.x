package spc;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashMap;
import java.util.Map;

public class AcmeService {

    public Map<String, String> getAcme() throws JsonProcessingException {
        Map<String, String> result = new HashMap<>();
        result.put("service", AcmeService.class.getSimpleName());

        return result;
    }

}
