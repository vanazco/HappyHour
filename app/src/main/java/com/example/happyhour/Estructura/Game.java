package com.example.happyhour.Estructura;

public class Game {
    public String id;
    public int id_game;
    public String data_inici;
    public String data_fi;


    public Game(String id, String data_inici, String data_fi,int id_game){
        this.id = id;
        this.data_inici = data_inici;
        this.data_fi = data_fi;
        this.id_game = id_game;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id='" + id + '\'' +
                ", id_game=" + id_game +
                ", data_inici=" + data_inici +
                ", data_fi=" + data_fi +
                '}';
    }

}
