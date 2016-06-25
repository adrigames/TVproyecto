package mapa;

import logica.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class PasilloFinal extends Mapa{
    
    private GestorColisiones gestor;
    
    public PasilloFinal() throws SlickException{
        mapa = new TiledMap("testdata/mapasJuego/Pasillo final.tmx");
        gestor = new GestorColisiones();
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
        setBlocked(mapa);
    }
}
