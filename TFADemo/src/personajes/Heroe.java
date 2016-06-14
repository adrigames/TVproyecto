/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import java.util.ArrayList;
import logica.Collidable;
import objetos.Puerta;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.*;

public class Heroe extends Personaje {
    private Animation ataque;
    private ArrayList inventario;
    private boolean cambioDeMapa;
    private Puerta puerta;
    private Shape areaColision;
    private boolean arriba, abajo, izquierda, derecha, defecto = true;
    private int delta;
    
    private SpriteSheet prota;
<<<<<<< HEAD

    public Heroe(GameContainer container) throws SlickException {
        super(container);
        this.prota = new SpriteSheet("testdata/protagonista.png",64,64);
        up = new Animation(prota,0,0,2,0,true,150,false);
        left = new Animation(prota,0,1,2,1,true,150, false);
        down = new Animation(prota,0,2,2,2,true,150, false);
        right= new Animation(prota,0,3,2,3,true,150,false);
        jugador = down;
        vida = 100;
        daño = 20;
        jugadorX = 400;
        jugadorY = 400;
        /*for (int i = 0; i < 9; i++) { 
            down.addFrame(prota.getSprite(i, 10), 100);
        }

=======

    public Heroe(GameContainer container, float jugadorX, float jugadorY, float vida, float daño) throws SlickException {
        super(container, jugadorX, jugadorY, vida, daño);
        this.prota = new SpriteSheet("testdata/animaciones/protagonista.png", 64, 64);
        down = new Animation(/*prota,0,0,2,0,true,150,false*/);
        left = new Animation(/*prota,0,1,2,1,true,150, false*/);
        right = new Animation(/*prota,0,2,2,2,true,150, false*/);
        up = new Animation(/*prota,0,3,2,3,true,150,false*/);
        for (int i = 0; i < 9; i++) { 
            down.addFrame(prota.getSprite(i, 10), 100);
        }

>>>>>>> origin/master
        for (int i = 0; i < 9; i++) {
            left.addFrame(prota.getSprite(i, 9), 100);
        }

        for (int i = 0; i < 9; i++) {
            right.addFrame(prota.getSprite(i, 11), 100);
        }

        for (int i = 0; i < 9; i++) {
            up.addFrame(prota.getSprite(i, 8), 100);
<<<<<<< HEAD
        }*/
=======
        }
>>>>>>> origin/master
    }

    public boolean getCambioDeMapa(){
        return cambioDeMapa;
    }
    //Esta función iría en el update 
    public void movement(int delta) {
        float jugadorAnteriorX = jugadorX; float jugadorAnteriorY = jugadorY;

        Input input = container.getInput();
        if (input.isKeyDown(Input.KEY_UP)) {
            arriba = true;
                 jugador = up;
                 jugador.update(delta);
                 jugadorY -= delta * 0.1f;
            }
        else if (input.isKeyDown(Input.KEY_DOWN)){
            abajo = true;
            jugador = down;
            jugador.update(delta);
            jugadorY += delta * 0.1f;
        }
        else if (input.isKeyDown(Input.KEY_LEFT)){
            izquierda = true;
            jugador = left;
            jugador.update(delta);
            jugadorX -= delta * 0.1f;
        }
        else if (input.isKeyDown(Input.KEY_RIGHT))
        {
            derecha = true;
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
    
    @Override
    public void render(int delta, Graphics g) throws SlickException{
<<<<<<< HEAD
        this.delta = delta;
        
    }
    
=======
        
        this.delta = delta;
        if(arriba) up.draw();
        else if(abajo) down.draw();
        else if(izquierda) left.draw();
        else if(derecha) right.draw();
        else if(defecto) up.draw();
        
    }
    
    public void dibujar(Graphics g) throws SlickException{
        this.render(delta, g);
    }
    
>>>>>>> origin/master
}
