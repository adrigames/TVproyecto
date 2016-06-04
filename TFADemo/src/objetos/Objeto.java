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
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Sergio
 */

public abstract class Objeto implements Collidable {
    private float posX, posY;
    private GestorColisiones gestor;   
    private SpriteSheet spriteObj;
    private Animation animationObj;
    private Rectangle areaColision;

    public GestorColisiones getGestor() {
        return gestor;
    }

    public void setGestor(GestorColisiones gestor) {
        this.gestor = gestor;
    }

    public SpriteSheet getSpriteObj() {
        return spriteObj;
    }

    public void setSpriteObj(SpriteSheet spriteObj) {
        this.spriteObj = spriteObj;
    }

    public Animation getAnimationObj() {
        return animationObj;
    }

    public void setAnimationObj(Animation animationObj) {
        this.animationObj = animationObj;
    }

    public void setAreaColision(Rectangle areaColision) {
        this.areaColision = areaColision;
    }

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
    
    
    @Override
    abstract public Shape getAreaColision();
}
