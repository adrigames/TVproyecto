package personajes;

import estados.Juego;
import java.util.ArrayList;
import logica.*;
import objetos.Puerta;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import mapa.*;
import org.newdawn.slick.state.StateBasedGame;

public class Heroe extends Personaje implements Collidable{
    private Animation ataque;
    private ArrayList inventario;
    private boolean cambioDeMapa;
    private Puerta puerta;
    private Mapa mapa = null;
    private SpriteSheet prota;
    private SpriteSheet protaAtacar;
    private SpriteSheet protaMuerte;
    private GestorColisiones gestor;
    private Sound sonidoAtacar;
    private Sound sonidoPaso;
    //private String mapaActual = "puebloInicio";
    
    public Heroe(GameContainer container,StateBasedGame game,Collidable colisiones, GestorColisiones gestor) throws SlickException {
        super(container);
        this.gestor = gestor;
        gestor.recordItem(this);
        this.prota = new SpriteSheet("testdata/spritesPj/protagonistaMov.png",64,64);
        this.protaAtacar = new SpriteSheet("testdata/spritesPj/protagonistaAtacando.png",64,64);
        this.protaMuerte = new SpriteSheet("testdata/spritesPj/protagonistaMuerte.png",64,64);
        up = new Animation(prota,0,0,7,0,true,150,false);
        left = new Animation(prota,0,1,7,1,true,150, false);
        down = new Animation(prota,0,2,7,2,true,150, false);
        right= new Animation(prota,0,3,7,3,true,150,false);
        atacarUp = new Animation(protaAtacar,0,0,5,0,true,150,false);
        atacarLeft = new Animation(protaAtacar,0,1,5,1,true,150,false);
        atacarDown = new Animation(protaAtacar,0,2,5,2,true,150,false);
        atacarRight = new Animation(protaAtacar,0,3,5,3,true,150,false);
        muerte = new Animation(protaMuerte,0,0,5,0,true,150,false);
        jugador = down;
        vida = 100;
        daño = 20;
        jugadorX = 400;
        jugadorY = 400;
        //nuevo
        anchoSprite = 32;
        altoSprite = 32;
        anchoDibujado = anchoSprite * 2f;
        altoDibujado = altoSprite * 2f;
        areaColision = new Rectangle(jugadorX, jugadorY, anchoDibujado, altoDibujado);
        mapa = new PuebloInicio(container,game);
        sonidoAtacar = new Sound("testdata/sonidoAtaque.wav.WAV");
        sonidoPaso = new Sound("testdata/sonidoPaso.wav.WAV");
        
        /*for (int i = 0; i < 9; i++) { 
            down.addFrame(prota.getSprite(i, 10), 100);
        }

        for (int i = 0; i < 9; i++) {
            left.addFrame(prota.getSprite(i, 9), 100);
        }

        for (int i = 0; i < 9; i++) {
            right.addFrame(prota.getSprite(i, 11), 100);
        }

        for (int i = 0; i < 9; i++) {
            up.addFrame(prota.getSprite(i, 8), 100);
        }*/
    }

    public boolean getCambioDeMapa(){
        return cambioDeMapa;
    }
    //Esta función iría en el update 
    public void movement(int delta) {
        float jugadorAnteriorX = jugadorX; 
        float jugadorAnteriorY = jugadorY;

        Input input = container.getInput();
        if(vida>0){
            if (input.isKeyDown(Input.KEY_UP)) {     
                if (input.isKeyDown(Input.KEY_UP) && input.isKeyDown(Input.KEY_Q)){
                    jugador = atacarUp;
                    sonidoAtacar.play(1f, 0.75f);}
                else{
                    jugador = up;
                    sonidoPaso.play(1f, 0.75f);
                }
                jugador.update(delta*2);
                jugadorY -= delta * 0.1f;

                }
            else if (input.isKeyDown(Input.KEY_DOWN)){
                if (input.isKeyDown(Input.KEY_DOWN) && input.isKeyDown(Input.KEY_Q)){
                    jugador = atacarDown;
                    sonidoAtacar.play(1f, 0.75f);}
                else{
                    jugador = down;
                    sonidoPaso.play(1f, 0.75f);
                }
                jugador.update(delta*2);
                jugadorY += delta * 0.1f;
            }
            else if (input.isKeyDown(Input.KEY_LEFT)){
                if (input.isKeyDown(Input.KEY_LEFT) && input.isKeyDown(Input.KEY_Q)){
                    jugador = atacarLeft;
                    sonidoAtacar.play(1f, 0.75f);}
                else{
                    jugador = left;
                    sonidoPaso.play(1f, 0.75f);
                }
                jugador.update(delta*2);
                jugadorX -= delta * 0.1f;
            }
            else if (input.isKeyDown(Input.KEY_RIGHT)){
                if (input.isKeyDown(Input.KEY_RIGHT) && input.isKeyDown(Input.KEY_Q)){
                    jugador = atacarRight;
                    sonidoAtacar.play(1f, 0.75f);}
                else{
                    jugador = right;
                    sonidoPaso.play(1f, 0.75f);
                }
                jugador.update(delta*2);
                jugadorX += delta * 0.1f;
            }

            else if (input.isKeyDown(Input.KEY_Q)){ 
                if(jugador == up){
                    jugador = atacarUp;
                    sonidoAtacar.play(1f, 0.75f);
                }
                else if(jugador == down){
                    jugador = atacarDown;
                    sonidoAtacar.play(1f, 0.75f);
                }
                else if(jugador == left){
                    jugador = atacarLeft;
                    sonidoAtacar.play(1f, 0.75f);
                }
                else if(jugador == right){
                    jugador = atacarRight;
                    sonidoAtacar.play(1f, 0.75f);
                }
                jugador.update(delta*2);
            }
            else if(input.isKeyDown(Input.KEY_D)){
                jugador = muerte;
                jugador.update(delta*2);
            }
        }
        
        /*else{
            if jugador
        }*/
        
        int a = (int)((jugadorX+8+jugador.getWidth())/mapa.getMapa().getTileWidth());
        int b = (int)((jugadorY+jugador.getHeight())/ mapa.getMapa().getTileHeight());
        int c = (int)((jugadorX-8+jugador.getWidth())/mapa.getMapa().getTileWidth());
        int d = (int)((jugadorY+jugador.getHeight())/mapa.getMapa().getTileHeight());
        if (mapa.getBlocked()[a][b] || mapa.getBlocked()[c][d]) {
                jugadorX = jugadorAnteriorX;
                jugadorY = jugadorAnteriorY;
        }
        sincronizarArea();
        //gestor.checkCollision();
    }

    @Override
    public void action() {
        Input input = container.getInput();
        if (input.isKeyDown(Input.KEY_J)) {
             jugador = ataque;
             //jugador.update(delta);
        }
        
    }

    @Override
    public Shape getAreaColision() {
        return areaColision;    
    }

    //Las interacciones de los objetos con el personaje van aquí.
    @Override
    public void alColisionar(Collidable colision) {
        if(colision.getClass().getSimpleName().equals("objetos.Puerta")){
            this.puerta = (Puerta)colision;
            cambioDeMapa = true;
            Input input = container.getInput();
            if(input.isKeyPressed(Input.KEY_F)){
                System.out.println("BIEEEEEEEEEEEEEEEEN");
            }
            
        }
    }

    @Override
    public void sincronizarArea() {
        areaColision.setX(jugadorX);
        areaColision.setY(jugadorY);    
    }
    
    @Override
    public void render(int delta, Graphics g) throws SlickException{
        this.delta = delta;
        
    }
    
    public void cambiarMapa(String mapaNuevo) throws SlickException{
        gestor.negateItem(puerta);
        switch(mapaNuevo){
            case "camino":
                mapa = new Camino();
                break;
            case "castilloPrincipe1":
                mapa = new CastilloPrincipe1();
                break;
            case "ciudad":
                mapa = new Ciudad();
                break;
            case "castilloPrincipe2":
                mapa = new CastilloPrincipe2();
                break;
            case "habitacionPrincipe":
                mapa = new HabitacionPrincipe();
                break;
            case "caminoS1":
                mapa = new Camino();
                break;
            case "caminoS2":
                mapa = new Camino();
                break;
            case "castilloReal1":
                mapa = new CastilloReal1();
                break;
            case "castilloReal2":
                mapa = new CastilloReal2();
                break;
            case "pasillo":
                mapa = new PasilloFinal();
                break;
            case "habitacionRey":
                mapa = new HabitacionRey();
                break;
        }
    }
    
}
