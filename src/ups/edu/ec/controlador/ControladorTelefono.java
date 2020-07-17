/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;

import java.util.List;
import ups.edu.ec.idao.ITelefonoDAO;

import ups.edu.ec.modelo.Telefono;
import ups.edu.ec.modelo.Usuario;

/**
 *
 * @author user
 */
public class ControladorTelefono {
    //Objetos vista

    //Objeto Telefono
    private Telefono telefono;
    private Usuario usuario;
    //Objetos DAO

    private ITelefonoDAO telefonosDAO;

    //Constructor vacio
    public ControladorTelefono() {

    }

    //Constructor 
    public ControladorTelefono(ITelefonoDAO telefonosDAO) {

        this.telefonosDAO = telefonosDAO;
    }

    public void registrarTelefono(Telefono telefono) {
        this.telefono = telefono;
        telefonosDAO.create(telefono);
    }
    public int obtenerSiguienteCodigo(){
        int codigo=telefonosDAO.obtenerUltimoCodigo();
        return ++codigo;
    }
    public List<Telefono> verTelefonos() {
        List<Telefono> telefonos;
        telefonos = telefonosDAO.findAll();
        return telefonos;
       
    }
   

}
