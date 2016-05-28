package estados;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class ControlesPrincipal extends BasicGameState{
    
    private Image fondo;

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        fondo = new Image("testdata/ImagenControles.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        fondo.draw();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input entrada = gc.getInput();
        if(entrada.isKeyPressed(Input.KEY_ESCAPE)){
            sbg.enterState(1);  //Al menú principal
        }
    }
    
    
    
}
