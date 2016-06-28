package logica;

import java.util.ArrayList;

public class GestorColisiones {

    private ArrayList<Collidable> list;

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
}
    
