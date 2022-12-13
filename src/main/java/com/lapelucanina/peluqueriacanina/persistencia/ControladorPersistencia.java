
package com.lapelucanina.peluqueriacanina.persistencia;

import com.lapelucanina.peluqueriacanina.logica.Duenio;
import com.lapelucanina.peluqueriacanina.logica.Mascota;


public class ControladorPersistencia {
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
    duenioJpa.create(duenio);
    mascotaJpa.create(masco);
    }
    
    
}
