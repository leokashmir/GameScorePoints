package br.com.gamescorepoints.dto;

/**
 * @version 1.0
 */
public class UserDtoIn {

    /** Id jogador */
    private int userId;

    /** Pontos jogador */
    private int score;

    /** Retorna o ID do usuario */
    public int getUserId() {
        return userId;
    }

    /** Retorna o Score do usuario */
    public int getScore() {
        return score;
    }

    /** Adiciona score ao usuario */
    public void setScore(final int score) {
        this.score = score;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
