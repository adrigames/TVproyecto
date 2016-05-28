/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import logica.Collidable;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Sergio
 */
public abstract class Personaje implements Collidable{
    protected SpriteSheet sprite;
    protected GameContainer container;
    protected float jugadorX, jugadorY;
    protected Animation jugador, up, down, left, right;
    protected Rectangle rect;
    protected float vida;
    protected float daño;

    public Personaje(GameContainer container, float jugadorX, float jugadorY, float vida, float daño) {
        this.container = container;
        this.jugadorX = jugadorX;
        this.jugadorY = jugadorY;
        this.vida = vida;
        this.daño = daño;
    }
    
    public float getJugadorX() {
        return jugadorX;
    }

    public float getJugadorY() {
        return jugadorY;
    }

    public Animation getJugador() {
        return jugador;
    }
    
    abstract public void action();  
}

    

