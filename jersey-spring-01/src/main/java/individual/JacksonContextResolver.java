package individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

    private ObjectMapper jackson;

    @Override
    public ObjectMapper getContext(Class<?> type) {
        jackson = new ObjectMapper();
        jackson.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return jackson;
    }

}
