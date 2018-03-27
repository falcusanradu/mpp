package model;

import java.util.List;

public class Game {

    private Integer id;
    private String team1;
    private String team2;
    private String title;
    //    private List<Ticket> tickets;
    private Integer tickets;
    private Integer priceOfTicket;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTickets() {
        return tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }

    public Integer getPriceOfTicket() {
        return priceOfTicket;
    }

    public void setPriceOfTicket(Integer priceOfTicket) {
        this.priceOfTicket = priceOfTicket;
    }
}

