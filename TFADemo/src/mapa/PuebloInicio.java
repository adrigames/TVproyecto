/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import objetos.Puerta;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import personajes.Heroe;

/**
 *
 * @author Sergio
 */
public class PuebloInicio extends Mapa {
    private Heroe heroe;
    private Puerta salidaPueblo;
    
    
    public PuebloInicio() throws SlickException {
        mapa = new TiledMap("testdata/puebloInicio.tmx");
        tileWidth = mapa.getWidth();
        tileHeight = mapa.getHeight();
    }
    
}
