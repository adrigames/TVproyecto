package mapa;

import objetos.Puerta;
import org.newdawn.slick.tiled.TiledMap;

public abstract class Mapa {
    protected TiledMap mapa;
    protected float tileWidth;
    protected float tileHeight;
    protected boolean[][] blocked;
    private Puerta puerta;

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
    
    public Puerta getPuerta(){
        return puerta;
    }
}
