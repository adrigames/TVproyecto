package mapa;

import logica.GestorColisiones;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class CastilloPrincipe1 extends Mapa{
    
    private GestorColisiones gestor;
    
    public CastilloPrincipe1() throws SlickException{
        mapa = new TiledMap("testdata/mapasJuego/Torre principe piso 1.tmx");
        gestor = new GestorColisiones();
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
        setBlocked(mapa);
    }
}
