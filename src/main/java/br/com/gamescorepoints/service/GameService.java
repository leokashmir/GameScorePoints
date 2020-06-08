package br.com.gamescorepoints.service;

import br.com.gamescorepoints.dto.UserDtoIn;
import br.com.gamescorepoints.dto.UserDtoOut;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GameService {

    public void addUserScore(final UserDtoIn user);

    public UserDtoOut currentPosition(final Integer userId);

    public List<UserDtoOut> highscorelist();
}
