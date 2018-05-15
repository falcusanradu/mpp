package controller;

import entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import repository.GameRepository;

@RestController
@CrossOrigin
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Game> getAllProducts() {
        return this.gameRepository.findAll();
    }

    @RequestMapping(value = "/create/{team1}/{team2}/{title}/{tickets}/{priceOfTicket}", method = RequestMethod.POST)
    @ResponseBody
    public void createOrUpdateGame(@PathVariable("team1") String team1, @PathVariable("team2") String team2, @PathVariable("title") String title,
                                   @PathVariable("tickets") Integer tickets, @PathVariable("priceOfTicket") Integer priceOfTicket) {
        Game game = new Game(team1, team2, title, tickets, priceOfTicket);
        this.gameRepository.save(game);
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Game findGameById(@PathVariable("id") Integer id) {
        return this.gameRepository.findAllById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteGame(@PathVariable("id") Integer id) {
        if (this.findGameById(id) != null) {
            Game game = this.findGameById(id);
            this.gameRepository.delete(game);
        }
    }


}
