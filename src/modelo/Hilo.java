/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.FRM_Ventana;

/**
 *
 * @author tecnologiamultimedia
 */
public class Hilo extends Thread{

    FRM_Ventana ventana;
    public Hilo(FRM_Ventana ventana)
    {
        this.ventana=ventana;
    }
    public void run()
    {
        while(true)
        {
            try
            {
                sleep(500);
                ventana.moverFondo();
                ventana.moverObstaculo();
                ventana.comprobarColision();
                ventana.cambiarIcono();
                comprobarPersonaje();
            }
            catch(Exception e)
            {
                System.out.println("Hubo un error en el hilo de ejecución: "+e);
            }
        
        }
    }
    public void comprobarPersonaje()
    {
        if(ventana.estado.equals("Subiendo"))
        {
            ventana.subirPersonaje();
        }
        if(ventana.estado.equals("Bajando"))
        {
            ventana.bajarPersonaje();
        }
        if(ventana.jl_Personaje.getY()<170)
        {
            ventana.estado="Bajando";
        }
        if(ventana.jl_Personaje.getY()==260)
        {
            ventana.estado="EnElSuelo";
        }
        
    }
    
    
    
    
    
    
 
}
