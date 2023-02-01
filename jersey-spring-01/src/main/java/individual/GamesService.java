package individual;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class GamesService {

    private GamesRepository gamesRepository;

    public List<Game> selectAllGames() throws IOException {
        return gamesRepository.readFromFile();
    }

    public void insertGame(Game game) throws IOException {
        List<Game> games = gamesRepository.readFromFile();

        game.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 16));

        games.add(game);

        gamesRepository.writeToFile(games);
    }

}
