/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Sergio
 */
public class Heroe extends Personaje {
    private Animation ataque;
    private ArrayList inventario;

    public Heroe(SpriteSheet sprite, float jugadorX, float jugadorY, Animation jugador, Animation up, Animation down, Animation left, Animation right) {
        super(sprite, jugadorX, jugadorY, jugador, up, down, left, right);
    }
    

    @Override
    public void movement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
