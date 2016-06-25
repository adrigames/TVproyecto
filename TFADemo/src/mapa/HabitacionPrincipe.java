package mapa;

import logica.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class HabitacionPrincipe extends Mapa{
    
    private GestorColisiones gestor;
    
    public HabitacionPrincipe() throws SlickException{
        mapa = new TiledMap("testdata/mapasJuego/Habitacion principe.tmx");
        gestor = new GestorColisiones();
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
        setBlocked(mapa);
    }
}
