/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import logica.Collidable;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
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
    protected Animation jugador, up, down, left, right, atacarUp, atacarDown, atacarLeft, atacarRight, muerte;
    protected Rectangle rect;
    protected float vida;
    protected float daño;
    protected int delta;

    public Personaje(GameContainer container) {
        this.container = container;
    }
    
    public void update(int delta) throws SlickException{
        this.delta = delta;
        action();
    }
    
    public float getJugadorX() {
        return jugadorX;
    }

    public void setJugadorX(float jugadorX) {
        this.jugadorX = jugadorX;
    }

    public void setJugadorY(float jugadorY) {
        this.jugadorY = jugadorY;
    }

    public float getJugadorY() {
        return jugadorY;
    }

    public Animation getJugador() {
        return jugador;
    }
    
    abstract public void action();  
    
    abstract void render(int delta, Graphics g) throws SlickException;
}

    

