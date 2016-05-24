/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Sergio
 */
public abstract class Personaje {
    private SpriteSheet sprite;
    private float jugadorX, jugadorY;
    private Animation jugador, up, down, left, right;

    public Personaje(SpriteSheet sprite, float jugadorX, float jugadorY, Animation jugador, Animation up, Animation down, Animation left, Animation right) {
        this.sprite = sprite;
        this.jugadorX = jugadorX;
        this.jugadorY = jugadorY;
        this.jugador = jugador;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public SpriteSheet getSprite() {
        return sprite;
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

    public Animation getUp() {
        return up;
    }

    public Animation getDown() {
        return down;
    }

    public Animation getLeft() {
        return left;
    }

    public Animation getRight() {
        return right;
    }
    
    
    abstract public void movement();
    
    abstract public void action();  
}

    

