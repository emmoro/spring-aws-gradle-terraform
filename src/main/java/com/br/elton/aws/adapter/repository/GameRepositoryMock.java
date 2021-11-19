package com.br.elton.aws.adapter.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.br.elton.aws.adapter.entity.ConsoleEntity;
import com.br.elton.aws.adapter.entity.GameEntity;

@Repository
public class GameRepositoryMock {
	
	private List<GameEntity> list = Arrays.asList( new GameEntity(1L, "Super Mario Bros.", 1985, (new ConsoleEntity(1L, "Entertainment System", 1985))),
			new GameEntity(2L, "Super Mario Bros. 3", 1988, (new ConsoleEntity(1L, "Entertainment System", 1985))),
			new GameEntity(3L, "The Legend of Zelda", 1986, (new ConsoleEntity(1L, "Entertainment System", 1985))),
			new GameEntity(4L, "Super Mario World", 1990, new ConsoleEntity(2L, "Super Nintendo Entertainment System", 1991)),
			new GameEntity(5L, "Donkey Kong Country", 1994, new ConsoleEntity(2L, "Super Nintendo Entertainment System", 1991)),
			new GameEntity(6L, "Super Mario Kart", 1992, new ConsoleEntity(2L, "Super Nintendo Entertainment System", 1991)),
			new GameEntity(7L, "Super Mario 64", 1996, new ConsoleEntity(3L, "Nintendo 64", 1996)),
			new GameEntity(8L, "Banjo-Kazooie", 1998, new ConsoleEntity(3L, "Nintendo 64", 1996)),
			new GameEntity(9L, "Paper Mario", 2000, new ConsoleEntity(3L, "Nintendo 64", 1996)),
			new GameEntity(10L, "Super Smash Bros. Melee", 2001, new ConsoleEntity(4L, "GameCube", 2001)));
	
	
	 public List<GameEntity> findAllGames() {
		 List<GameEntity> games = new ArrayList<GameEntity>();
		 list.stream().forEach(game -> {
			 games.add(new GameEntity(game.getId(), game.getTitle(), game.getReleaseYear(), game.getConsole()));
		 });
		 
		 return games;
	 }
	 
	 public List<GameEntity> findAllGamesByConsole(Long consoleId) {
		 List<GameEntity> games = list.stream().filter(ga -> ga.getConsole().getId().equals(consoleId)).collect(Collectors.toList());
		 
		 List<GameEntity> gamesResponse = new ArrayList<GameEntity>();
		 games.stream().forEach(game -> {
			 gamesResponse.add(new GameEntity(game.getId(), game.getTitle(), game.getReleaseYear(), game.getConsole()));
		 });

		 return gamesResponse;
	 }

	 public GameEntity saveGame(GameEntity game) {
		 list.add(game);
		 return game;
	 }

}
