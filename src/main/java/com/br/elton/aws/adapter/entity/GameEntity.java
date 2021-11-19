package com.br.elton.aws.adapter.entity;

public class GameEntity {

    private Long id;

    private String title;

    private Integer releaseYear;

    private ConsoleEntity console;

    @Deprecated
    public GameEntity() {
    }

    public static GameEntity create(String title, Integer releaseYear, ConsoleEntity console) {
        GameEntity game = new GameEntity();
        game.setTitle(title);
        game.setReleaseYear(releaseYear);
        game.setConsole(console);
        return game;
    }
    

    public GameEntity(Long id, String title, Integer releaseYear, ConsoleEntity console) {
		super();
		this.id = id;
		this.title = title;
		this.releaseYear = releaseYear;
		this.console = console;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        if (releaseYear < 0) {
            throw new NumberFormatException("Game release year must be a positive number");
        }
        this.releaseYear = releaseYear;
    }

    public ConsoleEntity getConsole() {
        return console;
    }

    public void setConsole(ConsoleEntity console) {
        this.console = console;
    }

}
