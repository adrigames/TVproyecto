/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import java.util.ArrayList;
import logica.Collidable;
import objetos.Puerta;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Shape;

/**
 *
 * @author Sergio
 */
public class Heroe extends Personaje {
    private Animation ataque;
    private ArrayList inventario;
    private boolean cambioDeMapa;
    private Puerta puerta;
    private Shape areaColision;

    public Heroe(GameContainer container, float jugadorX, float jugadorY, float vida, float daño) {
        super(container, jugadorX, jugadorY, vida, daño);
        down = new Animation(sprite,0,0,2,0,true,150,false);
        left = new Animation(sprite,0,1,2,1,true,150, false);
        right = new Animation(sprite,0,2,2,2,true,150, false);
        up = new Animation(sprite,0,3,2,3,true,150,false);
    }

    public boolean getCambioDeMapa(){
        return cambioDeMapa;
    }
    //Esta función iría en el update 
    public void movement(int delta) {
        float jugadorAnteriorX = jugadorX; float jugadorAnteriorY = jugadorY;

        Input input = container.getInput();
        if (input.isKeyDown(Input.KEY_UP)) {
                 jugador = up;
                 jugador.update(delta);
                 jugadorY -= delta * 0.1f;
            }
        else if (input.isKeyDown(Input.KEY_DOWN)){
            jugador = down;
            jugador.update(delta);
            jugadorY += delta * 0.1f;
        }
        else if (input.isKeyDown(Input.KEY_LEFT)){
            jugador = left;
            jugador.update(delta);
            jugadorX -= delta * 0.1f;
        }
        else if (input.isKeyDown(Input.KEY_RIGHT))
        {
            jugador = right;
            jugador.update(delta);
            jugadorX += delta * 0.1f;
        }
        /*int a = (int)((jugadorX+8+jugador.getWidth())/tileWidth);
        int b = (int)((jugadorY+jugador.getHeight())/ tileHeight);
        int c = (int)((jugadorX-8+jugador.getWidth())/tileWidth);
        int d = (int)((jugadorY+jugador.getHeight())/tileHeight);
        if (blocked[a][b] || blocked[c][d]) {
                jugadorX = jugadorAnteriorX;
                jugadorY = jugadorAnteriorY;
                }*/
    }

    @Override
    public void action() {
        Input input = container.getInput();
        if (input.isKeyDown(Input.KEY_J)) {
             jugador = ataque;
             //jugador.update(delta);
        }
        
    }

    @Override
    public Shape getAreaColision() {
        return areaColision;    
    }

    //Las interacciones de los objetos con el personaje van aquí.
    @Override
    public void alColisionar(Collidable colision) {
        if(colision.getClass().getSimpleName().equals("Puerta")){
            this.puerta = (Puerta)colision;
            Input input = container.getInput();
            if(input.isKeyDown(Input.KEY_J)){
                cambioDeMapa = true;
            }
        }
    }

    @Override
    public void sincronizarArea() {
        areaColision.setX(jugadorX);
        areaColision.setY(jugadorY);    
    } 
}
