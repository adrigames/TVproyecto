
package estados;

/**
 *
 * @author Adrian de Juan
 */
import org.newdawn.slick.state.*;

public abstract class Estado implements GameState{
    
    private int id;
    
    public Estado (int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
  
}
