package spc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class VersionService {

    private final FileRW fileRW;
    public static String origin;

    public VersionService(FileRW fileRW) {
        this.fileRW = fileRW;
    }

    public List<Version> read() throws IOException {
        return fileRW.readFromFile();
    }

    public List<Version> latest() throws IOException {
        List<Version> versions = fileRW.readFromFile();

        List<String> names = versions.stream()
                .map(Version::getName)
                .distinct()
                .toList();

        List<Version> latestVersions = new ArrayList<>();

        for (String name : names) {
            Version version = versions.stream()
                    .filter(r -> r.getName().equals(name))
                    .max(Comparator.comparing(Version::getLatest))
                    .orElse(null);

            latestVersions.add(version);
        }

        return latestVersions;
    }

    public void insertVersion(Version version) throws IOException {
        List<Version> versions = fileRW.readFromFile();

        version.setId(generateId(version));

        versions.add(version);

        fileRW.writeToFile(versions);
    }

    public String generateId(Version version) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(version.getName().charAt(0)).toUpperCase());

        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        Random r = new Random();

        for (int j = 0; j < 15; j++) {
            sb.append(characters.charAt(r.nextInt(characters.length())));
        }

        return sb.toString();
    }

    public void write(List<Version> versions) throws IOException {
        fileRW.writeToFile(versions);
    }

}
