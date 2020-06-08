package br.com.gamescorepoints.controller;


import br.com.gamescorepoints.dto.UserDtoIn;
import br.com.gamescorepoints.dto.UserDtoOut;
import br.com.gamescorepoints.service.GameServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @version 1.0
 * @author leonardo
 */
@RestController
@RequestMapping("v1/game/")
public class GameController {


    /** Looger da classe  */
    private static final Logger LOG =  LoggerFactory.getLogger(GameController.class.getName());

    /** Injecao do GameService  */
    @Autowired
    private transient GameServiceImpl game;




    /**
     * @apiNote  Metodo que insere o jogador no ranking e contabiliza seus pontos
     * @param user UserDtoIn
     *
     */
    @PostMapping("score")
    @ResponseBody
    public void addScorePoints(final @RequestBody UserDtoIn user){

        final Runnable task = () -> {
            game.addUserScore(user);
        };
        final Thread thread = new Thread(task);
        thread.start();
     }

    /**
     * @apiNote Metodo para exibir a posição no ranking de um jogador
     * @param userId
     * @return UserDtoOut
     */
    @GetMapping("{userId}/position")
    public UserDtoOut getCurrentPosition(final @PathVariable int userId){
       return game.currentPosition(userId);
    }

    /**
     * @apiNote End-Point para listar o Ranking do jogo
     * @return List<UserDtoOut>
     */
    @GetMapping("highscorelist")
    public List<UserDtoOut> getHighScoreList(){
        List<UserDtoOut> listHighScore = new ArrayList<>();

        final Callable<List<UserDtoOut>> callableObj = () -> {
                return game.highscorelist();
        };
        try {

            final ExecutorService service = Executors.newFixedThreadPool(4);
            final Future<List<UserDtoOut>> future = service.submit(callableObj);
            listHighScore = future.get();


        }catch (ExecutionException | InterruptedException e){

            LOG.error("========== > Erro buscando socrelist ", e);
        }

        return listHighScore;
    }


}
