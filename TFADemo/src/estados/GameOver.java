package estados;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class GameOver extends BasicGameState {
    
    private Image fondo, aux;
    private Font font;
    private final String[] opciones = new String[]{"Menú Principal", "Salir"};
    private int indicador;

    @Override
    public int getID() {
        return 6;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        fondo = new Image("testdata/GameOver.png");
        aux = fondo.getScaledCopy(800, 600);
        font = new AngelCodeFont("testdata/demo2.fnt", "testdata/demo2_00.tga");
        indicador = 0;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        aux.draw();
        g.setFont(font);
        g.setColor(Color.yellow);
        
        for (int i = 0; i < opciones.length; i++) {
            g.drawString(opciones[i], 400 - (font.getWidth(opciones[i]) / 2), 200 + (i * 50));
            if (indicador == i) {
                g.drawRect(200, 190 + (i * 50), 400, 50);
            }
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        
        Input entrada = gc.getInput();
        if(entrada.isKeyPressed(Input.KEY_UP)){
            indicador--;
            if(indicador < 0) indicador = opciones.length - 1;
        }
        if(entrada.isKeyPressed(Input.KEY_DOWN)){
            indicador++;
            if(indicador >= opciones.length) indicador  = 0;
        }
        if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
        
            switch(indicador){
                
                case 0:
                    sbg.enterState(1);  //Al menú principal
                    break;
                case 1:
                    System.exit(0);     //Salida
                    break;
            }
            
        }
    }
    
}
