package model;

public class Keyword {
    private final String key;
    private final Integer weight;

    public Keyword(String key, Integer weight) {
        this.key = key;
        this.weight = weight;
    }

    public String getKey() {
        return key;
    }

    public Integer getWeight() {
        return weight;
    }
}
