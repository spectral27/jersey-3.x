package spc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileRW {

    private final ObjectMapper jackson = new ObjectMapper();

    public List<Version> readFromFile() throws IOException {
        String versionsJson = Files.readString(Path.of("versions.json"));

        TypeReference<List<Version>> versionsTypeReference = new TypeReference<>(){};

        return jackson.readValue(versionsJson, versionsTypeReference);
    }

    public void writeToFile(List<Version> versions) throws IOException {
        ObjectWriter objectWriter = jackson.writerWithDefaultPrettyPrinter();

        String versionsJson = objectWriter.writeValueAsString(versions);

        Files.writeString(Path.of("versions.json"), versionsJson);
    }

}
