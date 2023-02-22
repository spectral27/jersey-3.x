package spc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Getter
@Setter
public class GamesRepository {

    // private ObjectMapper jackson = new ObjectMapper();
    private ObjectMapper jackson;

    public List<Game> readFromFile() throws IOException {
        String gamesJson = Files.readString(Path.of("games.json"));

        TypeReference<List<Game>> gamesTypeReference = new TypeReference<>(){};

        return jackson.readValue(gamesJson, gamesTypeReference);
    }

    public void writeToFile(List<Game> games) throws IOException {
        String gamesJson = jackson.writerWithDefaultPrettyPrinter()
                .writeValueAsString(games);

        Files.writeString(Path.of("games.json"), gamesJson);
    }

}
