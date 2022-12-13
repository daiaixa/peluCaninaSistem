
package com.lapelucanina.peluqueriacanina.logica;

import com.lapelucanina.peluqueriacanina.persistencia.ControladorPersistencia;

public class Controlador {
    
    ControladorPersistencia persiControlador = new ControladorPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String alergico, String atencEspecial, String observaciones, String nombreDuenio, String celDuenio) {
       //Creamos el dueño y setiamos los valores
       Duenio duenio = new Duenio();
       duenio.setNombre_duenio(nombreDuenio);
       duenio.setCel_duenio(celDuenio);
       
       Mascota masco = new Mascota();
       masco.setNombre_masco(nombreMasco);
       masco.setColor(color);
       masco.setRaza(raza);
       masco.setAlergico(alergico);
       masco.setAtencion_especial(atencEspecial);
       masco.setObservaciones(observaciones);
       masco.setUnDuenio(duenio);
       
       persiControlador.guardar(duenio, masco);
    }


    
    
    
}
