/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.tiled.TiledMap;
import personajes.Personaje;

/**
 *
 * @author Sergio
 */
public class Camara {
    private float x;
    private float y;
    private float distanciaBordeX;
    private float distanciaBordeY;
    private float camX;
    private float camY;
    private float zoom;
    private float anchoMapa;
    private float altoMapa;
    private TiledMap map;
    private float anchoVentana;
    private float altoVentana;
    private float anchoTile;
  
    private Personaje personaje;
    
    
    
    public Camara(GameContainer container , TiledMap map, Personaje personaje){
        this.personaje = personaje;
        this.map = map;
        distanciaBordeX = 400;
        distanciaBordeY = 300;     
        anchoMapa= map.getWidth()*map.getTileWidth()*zoom;
        altoMapa = map.getHeight()*map.getTileHeight()*zoom;
        anchoVentana = container.getWidth();
        altoVentana= container.getHeight();
        anchoTile = map.getTileHeight()*zoom; 
    }

    public float getCamX() {
        return camX;
    }

    public float getCamY() {
        return camY;
    }
    
    public float getZoom() {
        return zoom;
    }
    
    public void moverCamara(){
        
        x = personaje.getJugadorX();
        y = personaje.getJugadorY();
   
        if (x >(anchoMapa - anchoVentana + distanciaBordeX)  && y > altoMapa-altoVentana+distanciaBordeY){
            camX = -(anchoMapa - anchoVentana);
            camY =  altoVentana-altoMapa;
        }
        else if ( x >(anchoMapa - anchoVentana + distanciaBordeX) && y <= altoMapa-altoVentana+distanciaBordeY){
            camX = -(anchoMapa - anchoVentana);
            camY = -y + distanciaBordeY;
        }
        else if(x > distanciaBordeX && y >  altoMapa-altoVentana+distanciaBordeY){
            camX = -x + distanciaBordeX;
            camY =  altoVentana-altoMapa;
        } 
        else if(x > distanciaBordeX && y > distanciaBordeY){   
            camX = -x + distanciaBordeX;
            camY = -y + distanciaBordeY;
        }
        else if(x > distanciaBordeX && y <= distanciaBordeY){
            camX =  -x + distanciaBordeX;
        }
        
        else if (x <= distanciaBordeX && y > altoMapa-altoVentana+distanciaBordeY){
            camX = 0;
            camY = altoVentana-altoMapa;
        }
        
        else if (x <= distanciaBordeX && y > distanciaBordeY){
            camX = 0;
            camY = -y + distanciaBordeY;
        }
        else if (x <= distanciaBordeX && y <= distanciaBordeY){
         
        }
    
    }
}
