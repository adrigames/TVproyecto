/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import logica.Collidable;
import logica.GestorColisiones;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.GameContainer;

/**
 *
 * @author Sergio
 */
public class Puerta extends Objeto {

    public Puerta(float posX, float posY, GestorColisiones gestor) {
        super(posX, posY, gestor);
        //spriteObj = "";
        gestor.recordItem(this);
    }

    
    @Override
    public Shape getAreaColision() {
        return this.getAreaColision();
    }

    @Override
    public void alColisionar(Collidable colision) {
        
    }

    @Override
    public void sincronizarArea() {
        this.getAreaColision().setX(this.getPosX());
        this.getAreaColision().setY(this.getPosY());

    }
    
    
}
