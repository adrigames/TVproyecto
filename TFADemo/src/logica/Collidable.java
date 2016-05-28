/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Sergio
 */
public interface Collidable {

    
    public Shape getAreaColision();
   
    public void alColisionar(Collidable colision);
    
    public void sincronizarArea ();

    
}
