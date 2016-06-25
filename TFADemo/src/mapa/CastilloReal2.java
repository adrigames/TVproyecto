package mapa;

import logica.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class CastilloReal2 extends Mapa{
    
    private GestorColisiones gestor;
    
    public CastilloReal2() throws SlickException{
        mapa = new TiledMap("testdata/mapasJuego/Castillo real piso 2.tmx");
        gestor = new GestorColisiones();
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
        setBlocked(mapa);
    }
    
}
