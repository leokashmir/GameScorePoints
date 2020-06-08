package br.com.gamescorepoints.dto;

/**
 * @version 1.0
 */
public class UserDtoOut {
    /** Id jogador */
    private int userId;
    /** Pontos do jogador */
    private int score;
    /** Posicao do jogador */
    private int position;

    /** Construtor padrao */
    public UserDtoOut() {}

    /** Construtor com argumentos */
    public UserDtoOut(final int userId, final int score, final int position) {
        this.userId = userId;
        this.score = score;
        this.position = position;
    }

    /** Retorna o ID do usuario */
    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
