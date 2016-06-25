package mapa;

import logica.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class Ciudad extends Mapa{
    
    private GestorColisiones gestor;
    
    public Ciudad() throws SlickException{
        mapa = new TiledMap("testdata/mapasJuego/Ciudad.tmx");
        gestor = new GestorColisiones();
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
        setBlocked(mapa);
    }
}
