package com.br.elton.aws.adapter.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.br.elton.aws.adapter.entity.ConsoleEntity;

@Repository
public class ConsoleRepositoryMock {
	

	private List<ConsoleEntity> list = Arrays.asList( new ConsoleEntity(1L, "Entertainment System", 1985),
												new ConsoleEntity(2L, "Super Nintendo Entertainment System", 1991),
												new ConsoleEntity(3L, "Nintendo 64", 1996),
												new ConsoleEntity(4L, "GameCube", 2001),
												new ConsoleEntity(5L, "Nintendo Wii", 2006),
												new ConsoleEntity(6L, "Nintendo Wii U", 2012),
												new ConsoleEntity(7L, "Nintendo Switch", 2017),
												new ConsoleEntity(8L, "Nintendo Switch - Teste", 2021),
												new ConsoleEntity(9L, "GameCube - Teste", 2020),
												new ConsoleEntity(10L, "XYSSS - Teste", 2021));
	
	public Optional<ConsoleEntity> findConsoleById(Long consoleId) {
		Optional<ConsoleEntity> console = list.stream().filter(e -> e.getId().equals(consoleId)).findFirst();
		return Optional.ofNullable(console.get());
	}

	public List<ConsoleEntity> findAllConsoles() {
		List<ConsoleEntity> listConsole = new ArrayList<ConsoleEntity>();
		list.stream().forEach(console -> {
			listConsole.add(new ConsoleEntity(console.getId(), console.getName(), console.getReleaseYear()));
		});
		return listConsole;
	}

	public ConsoleEntity saveConsole(ConsoleEntity console) {
		list.add(console);
		return console;
	}
	
}
