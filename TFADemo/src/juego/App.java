/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

import estados.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import mapa.Mapa;

/**
 *
 * @author Adrian de Juan
 */
public class App extends StateBasedGame {
    
    private AppGameContainer contenedor;
    private Mapa mapa;
    //dimensiones de la pantalla
    
    public static final int ALTO=500,ANCHO=800;
    
    //Estados
    
    public App() throws SlickException {
        super("RPG");
        contenedor = new AppGameContainer(this);
        contenedor.setDisplayMode(800, 600, false);
        contenedor.setShowFPS(false);
        contenedor.start();
    }
    
    public static void main(String[] args) {
        try {
            new App();
        } catch (SlickException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        
        this.addState(new Intro());                 //ID 0
        this.addState(new MenuPrincipal());         //ID 1
        this.addState(new Juego());                 //ID 2
        this.addState(new ControlesPrincipal());    //ID 3
        this.addState(new Pausa());                 //ID 4
        this.addState(new ControlesPausa());        //ID 5
        this.addState(new GameOver());              //ID 6
       
    }
    
}
