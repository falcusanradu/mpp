package model;

public class Client {
    private String name;
    private int nrSeats;
    private int gameId;

    public Client() {
    }

    public Client(String name, int nr_seats, int game_id) {
        this.name = name;
        this.nrSeats = nr_seats;
        this.gameId = game_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNrSeats() {
        return nrSeats;
    }

    public void setNrSeats(int nrSeats) {
        this.nrSeats = nrSeats;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
