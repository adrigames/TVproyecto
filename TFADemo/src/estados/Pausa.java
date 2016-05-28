package estados;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Pausa extends BasicGameState{
    private Image fondo;
    private Font font;
    private final String[] opciones = new String[]{"Continuar", "Menú Principal", "Controles", "Salir"};
    private int indicador;

    @Override
    public int getID() {
        return 4;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        fondo = new Image("testdata/ImagenMenu.png");
        font = new AngelCodeFont("testdata/demo2.fnt", "testdata/demo2_00.tga");
        indicador = 0;
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        fondo.draw();
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
        if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            System.exit(0);
        }
        if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
        
            switch(indicador){
                
                case 0:
                    sbg.enterState(2);  //Al Juego principal
                    break;
                case 1:
                    sbg.enterState(1);  //Al menú principal
                    break;
                case 2:
                    sbg.enterState(5);  //A los controles
                    break;
                case 3:
                    System.exit(0);     //Salida
                    break;
            }
            
        }
    }    
}
