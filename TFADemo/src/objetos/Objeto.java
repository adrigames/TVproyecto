/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import logica.Collidable;
import logica.GestorColisiones;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Sergio
 */

public abstract class Objeto implements Collidable {
    protected float posX, posY;
    protected GestorColisiones gestor;   
    protected SpriteSheet spriteObj;
    protected Animation animationObj;
    protected Rectangle areaColision;

    public Objeto(float posX, float posY, GestorColisiones gestor) {
        this.posX = posX;
        this.posY = posY;
        this.gestor = gestor;

    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }
    
    public void draw(){
        animationObj.draw(posX, posY); 
    }
    
    public void update(int delta){
        sincronizarArea();
    }
}