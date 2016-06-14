/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import mapa.Mapa;

/**
 *
 * @author Sergio
 */
public class GestorColisiones {

    private ArrayList<Collidable> list;
    private boolean[][] blocked;

    public GestorColisiones() {
        list = new ArrayList<>();

    }

    public void recordItem(Collidable item) {
        if (!list.contains(item)) {
            list.add(item);
            //System.out.println("Item recorded: " + item.getClass().getSimpleName());
        }
    }

    public void negateItem(Collidable cuerpo) {
        if (list.contains(cuerpo)) {
            list.remove(cuerpo);
        }
    }

    public void checkCollision() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    searchCollision(i, j);   
                }
            }
        }
    } 

    private void searchCollision(int i, int j) {
        if (list.get(i).getAreaColision().intersects(list.get(j).getAreaColision())) {
            list.get(i).alColisionar(list.get(j));
        }
    }
    
    public void blockMap(Mapa mapa) {
        blocked = new boolean[mapa.getMapa().getWidth()][mapa.getMapa().getHeight()];
        for (int x = 0; x<mapa.getMapa().getWidth(); x++){
            for (int y = 0; y<mapa.getMapa().getHeight(); y++){
                blocked[x][y] = (mapa.getMapa().getTileId(x, y, 0)!=0);
            }
        }
    }
}
    
