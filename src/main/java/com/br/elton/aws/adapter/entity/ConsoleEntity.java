package com.br.elton.aws.adapter.entity;

public class ConsoleEntity {

    private Long id;
    private String name;
    private Integer releaseYear;

    public ConsoleEntity() {

    }
    
    public ConsoleEntity(Long id, String name, Integer releaseYear) {
		this.id = id;
		this.name = name;
		this.releaseYear = releaseYear;
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
        if (releaseYear < 0) {
            throw new NumberFormatException("Console release year must be a positive number");
        }
        this.releaseYear = releaseYear;
    }

}
