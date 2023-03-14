package spc;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Version {

    private String id;
    private String name;
    private String version;
    private String release;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    @JsonIgnore
    public int getLatest() {
        String[] numbers = version.split("\\.");

        int result = 0;
        int multiplier = 10000;

        for (String number : numbers) {
            int n = Integer.parseInt(number);

            result += n * multiplier;

            multiplier = multiplier / 100;
        }

        return result;
    }

}
