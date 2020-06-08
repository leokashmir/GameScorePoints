    package br.com.gamescorepoints.service;


    import br.com.gamescorepoints.dto.UserDtoIn;
    import br.com.gamescorepoints.dto.UserDtoOut;
    import br.com.gamescorepoints.repository.MemoryCache;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.*;
    import java.util.concurrent.*;
    import java.util.concurrent.atomic.AtomicInteger;

    /**
     * Serviço de pontuação
     * @version 1.0
     * @author Leonardo
     */
    @Service
    public class GameServiceImpl implements GameService {

        /** Looger da classe  */
        private static final Logger LOG =  LoggerFactory.getLogger(GameServiceImpl.class.getName());

        @Autowired
        /** Varivael para armazenar em memoria o ranking do jogo*/
        private transient MemoryCache memory;


        /**
         * Metodo para adicionar o jogador no ranking
         * de pontos e fazer a somatoria dos pontos
         * @param user UserDtoIn
         */
        public void addUserScore(final UserDtoIn user){

                if (memory.getMemory().containsKey(user.getUserId())) {

                    final int oldPoints = memory.getMemory().get(user.getUserId());
                    final int newPoints = user.getScore() + oldPoints;

                    memory.getMemory().replace(user.getUserId(), newPoints);
                } else {
                    memory.getMemory().put(user.getUserId(), user.getScore());
                }
         }


        /**
         * Metodo que retorna a posição do jogador no ranking
         * @param userId
         * @return UserDtoOut
         */
         public UserDtoOut currentPosition(final Integer userId) {
            final List<UserDtoOut> highscorelist = this.highscorelist();
             UserDtoOut user = new UserDtoOut();

            final Callable<UserDtoOut> callableObj = () -> {
                return (UserDtoOut) highscorelist.stream()
                        .filter(obj -> obj.getUserId() == userId)
                        .findAny()
                        .get();
            };
            try {

                final ExecutorService service = Executors.newSingleThreadExecutor();
                final Future<UserDtoOut> future = service.submit(callableObj);
                user = future.get();

            }catch (ExecutionException | InterruptedException e){
                LOG.error("========== > Erro buscando currentPosition ", e);
            }

          return user;

        }


        /**
         * Metodo que retorna uma lista ordenada pela pontuação do jogador
         * @return List<UserDtoOut>
         */
        public List<UserDtoOut> highscorelist(){
            final List highscorelist = new ArrayList();
            final AtomicInteger posicao = new AtomicInteger(1);

            memory.getOrderByPoints().forEach((c, y) -> {
                    highscorelist.add(new UserDtoOut(c, y, posicao.getAndIncrement()));
                });

            return highscorelist;
        }


    }
