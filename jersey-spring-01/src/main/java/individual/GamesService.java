package individual;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
public class GamesService {

    private GamesRepository gamesRepository;

    public static String origin;

    public List<Game> selectAllGames() throws IOException {
        return gamesRepository.readFromFile();
    }

    public void insertGame(Game game) throws IOException {
        List<Game> games = gamesRepository.readFromFile();

        game.setId(UUID.randomUUID().toString().replace("-", "").substring(0, 16));
        game.setOrigin(origin);

        games.add(game);

        gamesRepository.writeToFile(games);
    }

    public void bulkInsert(List<Game> newGames) throws IOException {
        List<Game> games = gamesRepository.readFromFile();

        List<String> gamesIds = games.stream()
                .map(g -> g.getId())
                .collect(Collectors.toList());

        for (int i = 0; i < newGames.size(); i++) {
            if (!gamesIds.contains(newGames.get(i).getId())) {
                games.add(newGames.get(i));

                gamesIds.add(newGames.get(i).getId());
            }
        }

        gamesRepository.writeToFile(games);
    }

}
