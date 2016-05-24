/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import estados.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import mapa.Mapa;
import org.newdawn.slick.AppGameContainer;

/**
 *
 * @author Adrian de Juan
 */
public class App extends StateBasedGame {
    private Mapa mapa;
    public static final String name = "RPG";
    //dimensiones de la pantalla
    
    public static final int ALTO=500,ANCHO=800;
    
    //Estados
    
    public App() {
        super(name);
    }
    
    public static void main(String[] args) {
        try {
            AppGameContainer app;
            app = new AppGameContainer(new App());
            app.setDisplayMode(1200, 600, false);
            app.setShowFPS(false);
            app.start();
        }catch (SlickException e){
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
       this.addState(new Intro(0));//Intro
       this.addState(new MenuPrincipal(1));//Menú
       this.addState(new Juego(2));//Juego
       this.addState(new Pausa(3));//Pausa
       this.addState(new GameOver(4));//Game over
       
    }
    
}
