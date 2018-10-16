package es.upm.miw;

import org.apache.commons.text.RandomStringGenerator;

public class Stadium {
    private String id;
    private int capacity;
    private boolean covered;
    private String name;

    public Stadium() {
    }

    public Stadium(String id, int capacity, boolean covered, String name) {
        this.id = id;
        this.capacity = capacity;
        this.covered = covered;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static class Builder {

        String id;
        String name;
        int capacity;
        boolean covered;

        private static final int KEY_LENGTH = 20;

        public Builder() {
            // Generates a 20 code point string, using only the letters a-z
            RandomStringGenerator generator = new RandomStringGenerator.Builder().build();
            this.id = generator.generate(KEY_LENGTH);
        }

        public Builder named(String name) {
            this.name = name;

            return this;
        }

        public Builder withCapacityFor(int capacity) {
            this.capacity = capacity;

            return this;
        }

        public Builder isCovered(boolean covered) {
            this.covered = covered;

            return this;
        }

        public Stadium build() {
            Stadium stadium = new Stadium();

            stadium.setId(id);
            stadium.setCapacity(capacity);
            stadium.setCovered(covered);
            stadium.setName(name);

            return stadium;
        }

    }

}
