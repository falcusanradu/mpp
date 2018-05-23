package controller;

import entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.GameRepository;

@RestController
@CrossOrigin
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @RequestMapping(value = "/games", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Game> games() {
        return this.gameRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Game game) {
        this.gameRepository.save(game);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") Integer id, @RequestBody Game game) {
        if (this.gameRepository.findById(id).isPresent()) {
            Game g = this.gameRepository.findById(id).get();
            g.setTeam1(game.getTeam1());
            g.setTeam2(game.getTeam2());
            g.setTitle(game.getTitle());
            g.setTickets(game.getTickets());
            g.setPriceOfTicket(game.getPriceOfTicket());
            this.gameRepository.save(g);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findGameById(@PathVariable("id") Integer id) {

        Game game = this.gameRepository.findAllById(id);
        if (game == null)
            return new ResponseEntity<>("404", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        System.out.println("Deleting game ... " + id);
        if (this.gameRepository.findAllById(id) != null) {
            Game game = this.gameRepository.findAllById(id);
            this.gameRepository.delete(game);
            return new ResponseEntity<Game>(HttpStatus.OK);
        }
        return null;
    }

}
