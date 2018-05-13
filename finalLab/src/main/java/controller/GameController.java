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


}
