package mapa;

import logica.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class CastilloPrincipe2 extends Mapa{
    
    private GestorColisiones gestor;
    
    public CastilloPrincipe2() throws SlickException{
        mapa = new TiledMap("testdata/mapasJuego/Torre principe piso 2.tmx");
        gestor = new GestorColisiones();
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
        setBlocked(mapa);
    }
    
}
