
package com.lapelucanina.peluqueriacanina.logica;

import com.lapelucanina.peluqueriacanina.persistencia.ControladorPersistencia;
import java.util.List;

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

    public List<Mascota> traerMascotas() {
        return persiControlador.traerListaMascotas();
    }

    public void borrarMascota(int num_cliente) {
        persiControlador.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
       return persiControlador.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color,
            String alergico, String atencEspecial, String observaciones, String nombreDuenio, String celDuenio) {
       //con el objeto viejo comienzo a setear los valores
       masco.setNombre_masco(nombreMasco);
       masco.setRaza(raza);
       masco.setColor(color);
       masco.setAlergico(alergico);
       masco.setAtencion_especial(atencEspecial);
       masco.setObservaciones(observaciones);
       
       persiControlador.modificarMascota(masco);
       
       //para modificar los datos del duenio primero tengo que identificar al duenio
       //Duenio duenio = persiControlador.buscarDuenio();
       //pero puedo optimizar el codigo creando un metodo dentro de esta controladora de la busqueda
       Duenio duenio = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
       duenio.setNombre_duenio(nombreDuenio);
       duenio.setCel_duenio(celDuenio);
       
       //y ahora si llamanos al metodo modificarDuenio
       this.modificarDuenio(duenio);
    }
    //implementamos el metodo para buscar al dueño
    private Duenio buscarDuenio(int id_duenio) {
        return persiControlador.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
       persiControlador.modificarDuenio(duenio); 
    }
}
   
