package com.br.elton.aws.config;

public class Path {

    public static final String API = "/api";
    public static final String SEPARATOR = "/";
    public static final String ID = "{id}";

    // Game
    public static final String GAMES = "/games"; 

    // Console
    public static final String CONSOLES = "/consoles";
    public static final String CONSOLE_SINGLE = CONSOLES + SEPARATOR + ID;
    public static final String CONSOLE_GAMES = CONSOLE_SINGLE + GAMES;

}
