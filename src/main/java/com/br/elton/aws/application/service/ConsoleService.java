package com.br.elton.aws.application.service;

import com.br.elton.aws.adapter.entity.ConsoleEntity;
import com.br.elton.aws.domain.model.ConsoleResponse;
import com.br.elton.aws.adapter.repository.ConsoleRepositoryMock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsoleService {

    @Autowired
    private ConsoleRepositoryMock consoleRepository;

    public ConsoleResponse saveConsole(ConsoleResponse consoleResponse) {
        ConsoleEntity consoleEntity =
                consoleRepository.saveConsole(new ConsoleEntity(consoleResponse.getId(), consoleResponse.getName(), consoleResponse.getReleaseYear()));
        return new ConsoleResponse(consoleEntity);
    }

    public ConsoleResponse getConsole(Long consoleId) {
        Optional<ConsoleEntity> consoleOptional = consoleRepository.findConsoleById(consoleId);
        if (!consoleOptional.isPresent()) {
            throw new RuntimeException("Console with id " + consoleId + " was not found");
        }
        return new ConsoleResponse(consoleOptional.get());
    }

    public List<ConsoleResponse> getAllConsoles() {
        List<ConsoleResponse> consoleResponses = new ArrayList<ConsoleResponse>();
        try {
            List<ConsoleEntity> consoles = consoleRepository.findAllConsoles();
            consoles.stream().forEach(con -> {
                consoleResponses.add(new ConsoleResponse(con));
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return consoleResponses;
    }

}
