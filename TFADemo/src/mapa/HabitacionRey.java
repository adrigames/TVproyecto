package mapa;

import logica.*;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class HabitacionRey extends Mapa{
    
    private GestorColisiones gestor;
    
    public HabitacionRey() throws SlickException{
        mapa = new TiledMap("testdata/mapasJuego/Habitacion rey.tmx");
        gestor = new GestorColisiones();
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
        setBlocked(mapa);
    }
    
}
