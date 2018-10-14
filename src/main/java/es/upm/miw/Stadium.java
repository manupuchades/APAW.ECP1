package es.upm.miw;

public class Stadium {
    String id;
    int capacity;
    boolean covered;
    String name;

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
}
