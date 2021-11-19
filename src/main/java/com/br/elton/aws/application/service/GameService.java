package com.br.elton.aws.application.service;

import com.br.elton.aws.adapter.entity.ConsoleEntity;
import com.br.elton.aws.adapter.entity.GameEntity;
import com.br.elton.aws.adapter.repository.ConsoleRepositoryMock;
import com.br.elton.aws.domain.model.GameResponse;
import com.br.elton.aws.domain.model.GameWithConsoleResponse;
import com.br.elton.aws.adapter.repository.GameRepositoryMock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepositoryMock gameRepository;

    @Autowired
    private ConsoleRepositoryMock consoleRepository;

    public GameWithConsoleResponse saveGame(GameWithConsoleResponse gameWithConsoleResponse) {
        GameEntity gameEntity = new GameEntity();
        gameEntity.setTitle(gameWithConsoleResponse.getTitle());
        gameEntity.setReleaseYear(gameWithConsoleResponse.getReleaseYear());
        gameEntity.setConsole(new ConsoleEntity(gameWithConsoleResponse.getConsole().getId(), gameWithConsoleResponse.getConsole().getName(),
                gameWithConsoleResponse.getConsole().getReleaseYear()));

        gameEntity = gameRepository.saveGame(gameEntity);
        return new GameWithConsoleResponse(gameEntity);
    }

    public List<GameWithConsoleResponse> getAllGames() {
        List<GameWithConsoleResponse> gameResponses = new ArrayList<GameWithConsoleResponse>();
        List<GameEntity> games = gameRepository.findAllGames();
        games.stream().forEach(ga -> {
            gameResponses.add(new GameWithConsoleResponse(ga));
        });

        return gameResponses;
    }

    public List<GameResponse> getAllGamesByConsole(Long consoleId) {
        List<GameResponse> gameResponses = new ArrayList<GameResponse>();
        Optional<ConsoleEntity> console = consoleRepository.findConsoleById(consoleId);
        if (console.isPresent()) {
            List<GameEntity> games = gameRepository.findAllGamesByConsole(console.get().getId());
            games.stream().forEach(ga -> {
                gameResponses.add(new GameResponse(ga));
            });
        }

        return gameResponses;
    }
    
}
