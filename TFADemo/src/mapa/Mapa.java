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
    protected boolean[][] blocked;
    protected float tileWidth;
    protected float tileHeight;

    public Mapa(TiledMap mapa, boolean[][] blocked, float tileWidth, float tileHeight) {
        this.mapa = mapa;
        this.blocked = blocked;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
    }

    public void setBlocked(boolean[][] blocked) {
        blocked = new boolean[mapa.getWidth()][mapa.getHeight()];
        for (int x = 0; x<mapa.getWidth(); x++){
            for (int y = 0; y<mapa.getHeight(); y++){
                blocked[x][y] = (mapa.getTileId(x, y, 0)!=0);
            }
        }
        this.blocked = blocked;
    }

    public boolean[][] getBlocked() {
        return blocked;
    }

    public TiledMap getMapa() {
        return mapa;
    }

    public void setMapa(TiledMap mapa) {
        this.mapa = mapa;
    }
    
}
