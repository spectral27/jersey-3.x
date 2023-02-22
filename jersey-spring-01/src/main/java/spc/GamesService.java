package spc;

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

    public void updateGame(String id, Game game) throws IOException, NullPointerException {
        List<Game> games = gamesRepository.readFromFile();

        int counter = 0;

        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getId().equals(id)) {
                Game gameToUpdate = games.get(i);

                if (game.getName() != null && game.getName().length() > 0) {
                    gameToUpdate.setName(game.getName());
                }

                if (game.getDeveloper() != null && game.getDeveloper().length() > 0) {
                    gameToUpdate.setDeveloper(game.getDeveloper());
                }

                if (game.getPublisher() != null && game.getPublisher().length() > 0) {
                    gameToUpdate.setPublisher(game.getPublisher());
                }

                if (game.getPlatform() != null && game.getPlatform().length() > 0) {
                    gameToUpdate.setPlatform(game.getPlatform());
                }

                if (game.getYear() > 0) {
                    gameToUpdate.setYear(game.getYear());
                }

                if (game.getSerialNumber() != null && game.getSerialNumber().length() > 0) {
                    gameToUpdate.setSerialNumber(game.getSerialNumber());
                }

                if (game.getBarcode() != null && game.getBarcode().length() > 0) {
                    gameToUpdate.setBarcode(game.getBarcode());
                }

                counter++;
            }
        }

        if (counter == 0) {
            throw new NullPointerException("No game found with id " + id);
        }

        gamesRepository.writeToFile(games);
    }

    public void deleteGame(String id) throws IOException, NullPointerException {
        List<Game> games = gamesRepository.readFromFile();

        int counter = 0;

        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getId().equals(id)) {
                games.remove(i);

                counter++;
            }
        }

        if (counter == 0) {
            throw new NullPointerException("No game found with id " + id);
        }

        gamesRepository.writeToFile(games);
    }

}
