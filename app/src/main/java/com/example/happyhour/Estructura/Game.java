package com.example.happyhour.Estructura;

import java.util.Date;

public class Game {
    public String id;
    public int id_game;
    public Date data_inici;
    public Date data_fi;


    public Game(String id,Date data_inici,Date data_fi,int id_game){
        this.id = id;
        this.data_inici = data_inici;
        this.data_fi = data_fi;
        this.id_game = id_game;
    }

    public Game(){}

}
