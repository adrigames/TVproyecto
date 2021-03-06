package estados;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Intro extends BasicGameState{
    
    private Image fondo, aux;

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        fondo = new Image("testdata/ImagenIntro.png");
        aux = fondo.getScaledCopy(800, 600);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        aux.draw();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input entrada = gc.getInput();
        if(entrada.isKeyPressed(Input.KEY_ENTER)){
            sbg.enterState(1);
        }
        else if(entrada.isKeyPressed(Input.KEY_ESCAPE)){
            System.exit(0);
        }
    }
    
}
