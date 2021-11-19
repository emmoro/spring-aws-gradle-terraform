package com.br.elton.aws.domain.model;

import com.br.elton.aws.adapter.entity.ConsoleEntity;

public class ConsoleResponse {

    private Long id;
    private String name;
    private Integer releaseYear;

    public ConsoleResponse() {
    }

    public ConsoleResponse(ConsoleEntity console) {
        this.id = console.getId();
        this.name = console.getName();
        this.releaseYear = console.getReleaseYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
}
