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
import mapa.Mapa;
import mapa.PuebloInicio;

public class Heroe extends Personaje {
    private Animation ataque;
    private ArrayList inventario;
    private boolean cambioDeMapa;
    private Puerta puerta;
    private Shape areaColision;
    private Mapa mapa = new PuebloInicio();
    private SpriteSheet prota;

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

        for (int i = 0; i < 9; i++) {
            left.addFrame(prota.getSprite(i, 9), 100);
        }

        for (int i = 0; i < 9; i++) {
            right.addFrame(prota.getSprite(i, 11), 100);
        }

        for (int i = 0; i < 9; i++) {
            up.addFrame(prota.getSprite(i, 8), 100);
        }*/
    }

    public boolean getCambioDeMapa(){
        return cambioDeMapa;
    }
    //Esta función iría en el update 
    public void movement(int delta) {
        float jugadorAnteriorX = jugadorX; 
        float jugadorAnteriorY = jugadorY;

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
        
        int a = (int)((jugadorX+8+jugador.getWidth())/mapa.getMapa().getTileWidth());
        int b = (int)((jugadorY+jugador.getHeight())/ mapa.getMapa().getTileHeight());
        int c = (int)((jugadorX-8+jugador.getWidth())/mapa.getMapa().getTileWidth());
        int d = (int)((jugadorY+jugador.getHeight())/mapa.getMapa().getTileHeight());
        if (mapa.getBlocked()[a][b] || mapa.getBlocked()[c][d]) {
                jugadorX = jugadorAnteriorX;
                jugadorY = jugadorAnteriorY;
        }
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
        areaColision.setX(getJugadorX());
        areaColision.setY(getJugadorY());    
    }
    
    @Override
    public void render(int delta, Graphics g) throws SlickException{
        this.delta = delta;
        
    }
    
}
