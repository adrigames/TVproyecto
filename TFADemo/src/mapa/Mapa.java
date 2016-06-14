/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Sergio
 */
public abstract class Mapa {
    protected TiledMap mapa;
    protected float tileWidth;
    protected float tileHeight;

    public Mapa() {
        
    }

    public TiledMap getMapa() {
        return mapa;
    }

    public void setMapa(TiledMap mapa) {
        this.mapa = mapa;
    }
    
}
