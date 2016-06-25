package mapa;

import logica.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class CastilloReal1 extends Mapa{
    
    private GestorColisiones gestor;
    
    public CastilloReal1() throws SlickException{
        mapa = new TiledMap("testdata/mapasJuego/Castillo real piso 1.tmx");
        gestor = new GestorColisiones();
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
        setBlocked(mapa);
    }
    
}
