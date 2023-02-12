package individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GamesRepository {

    private ObjectMapper jackson = new ObjectMapper();

    public List<Game> readFromFile() throws IOException {
        String gamesJson = Files.readString(Path.of("games.json"));

        TypeReference<List<Game>> gamesTypeReference = new TypeReference<>(){};

        List<Game> games = jackson.readValue(gamesJson, gamesTypeReference);

        return games;
    }

    public void writeToFile(List<Game> games) throws IOException {
        String gamesJson = jackson.writerWithDefaultPrettyPrinter()
                .writeValueAsString(games);

        Files.writeString(Path.of("games.json"), gamesJson);
    }

}
