
package estados;

/**
 *
 * @author Adrian de Juan
 */
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;


public abstract class Estado implements GameState{
    protected GameContainer container;
    protected int id;
    
    public Estado (int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    @Override
    abstract public void init(GameContainer container, StateBasedGame sbg) throws SlickException;

    @Override
    abstract public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException;
    
    @Override
    abstract public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException;
}
