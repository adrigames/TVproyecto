/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajes;

import logica.Collidable;
import logica.GestorColisiones;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;
import personajes.Personaje;

/**
 *
 * @author AlbertoCabreraPlata
 */
public class Principe extends Personaje implements Collidable{
    private float distancia;
    private int estado;
    private GestorColisiones gestor;
    private SpriteSheet enem;
    
    
    public Principe(GameContainer container, Collidable colisiones, GestorColisiones gestor) throws SlickException{
        super(container);
        this.enem = new SpriteSheet("testdata/spritesPJ/principe.png",64,64);
        up = new Animation(enem,0,8,8,8,true,150,false);
        left = new Animation(enem,0,9,8,9,true,150, false);
        down = new Animation(enem,0,10,8,10,true,150, false);
        right= new Animation(enem,0,11,8,11,true,150,false);
        atacarUp = new Animation(enem,0,12,5,12,true,150,false);
        atacarLeft = new Animation(enem,0,13,5,13,true,150,false);
        atacarDown = new Animation(enem,0,14,5,14,true,150,false);
        atacarRight = new Animation(enem,0,15,5,15,true,150,false);
        muerte = new Animation(enem,0,20,5,20,true,150,false);
        this.gestor=gestor;
        gestor.recordItem(this);
        vida = 100;
        daño = 20;
        jugadorX = 500;
        jugadorY = 400;
        anchoSprite = 32;
        altoSprite = 32;
        anchoDibujado = anchoSprite * 2f;
        altoDibujado = altoSprite * 2f;
        areaColision = new Rectangle(jugadorX, jugadorY, anchoDibujado, altoDibujado);
        
    }
    public void action(){
        if (vida>0){
            switch(estado){
                case 0://estado vigilando(caminar despacio de lado a lado)
                    break;
                case 1://en guardia
                    break;
                case 2://se acerca al protagonista
                    break;
                case 3://ataca al personaje
                    break;
                case 4://ataca de manera mas furiosa
                    break;
                case 5://huye ya que tiene muy poca vida
                    break;
            }
        }
    }
    public void actualizarEstado(){
        //calcular la distancia que no encuentro el modo de hacerlo
        if (vida>65 && distancia<=700 && distancia > 680) 
            estado = 1; //ESTADO EN GUARDIA = 1
        else if (vida>65 && distancia<=680 && distancia > 400) 
            estado = 2; //ESTADO ACERCANDOSE = 2
        else if (vida>65 && distancia<=680) 
            estado = 3; //ESTADO ATACANDO = 3
        else if (vida<=65 && vida>5 && distancia<=680) 
            estado = 4; //ESTADO FURIOSO = 4
        else if (vida<=5) 
            estado = 5; //ESTADO HUYENDO = 5 
        else
            estado = 0; //ESTADO VIGILANDO = 0
    }

    @Override
    void render(int delta, Graphics g) throws SlickException {
         this.delta = delta;
    }

    @Override
    public Shape getAreaColision() {
        return areaColision;    
    }

    @Override
    public void alColisionar(Collidable colision) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sincronizarArea() {
        areaColision.setX(jugadorX);
        areaColision.setY(jugadorY); 
    }
}
