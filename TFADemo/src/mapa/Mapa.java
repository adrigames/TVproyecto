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
    protected boolean[][] blocked;

    public Mapa() {
        
    }

    public TiledMap getMapa() {
        return mapa;
    }

    public void setMapa(TiledMap mapa) {
        this.mapa = mapa;
    }

    public boolean[][] getBlocked() {
        return blocked;
    }

    public void setBlocked(TiledMap mapa) {
        blocked = new boolean[mapa.getWidth()][mapa.getHeight()];
        for (int x = 0; x<mapa.getWidth(); x++){
            for (int y = 0; y<mapa.getHeight(); y++){
                blocked[x][y] = (mapa.getTileId(x, y, 0)!=0);
                
                }
        }
    }
}
