package objetos;

import logica.Collidable;
import logica.GestorColisiones;
import org.newdawn.slick.geom.Shape;

public class Puerta extends Objeto implements Collidable{

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
