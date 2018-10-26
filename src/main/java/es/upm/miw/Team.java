package es.upm.miw;

import java.util.List;

public class Team {
    private String id;
    private String name;
    private String address;
    private int points;
    private List<Player> squad;

    public Team(String id, String name, String address, List<Player> squad) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.squad = squad;
    }

    public Team() {
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Player> getSquad() {
        return squad;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setSquad(List<Player> squad) {
        this.squad = squad;
    }
}
