/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.controlador;


import java.util.List;

import ups.edu.ec.dao.TelefonoDAO;
import ups.edu.ec.dao.UsuarioDAO;
import ups.edu.ec.idao.ITelefonoDAO;
import ups.edu.ec.idao.IUsuarioDAO;
import ups.edu.ec.modelo.Telefono;
import ups.edu.ec.modelo.Usuario;

/**
 *
 * @author user
 */
public class ControladorUsuario {

    private Usuario usuario;
    private Telefono telefono;

    //Objetos DAO
    private IUsuarioDAO usuarioDAO;
    private ITelefonoDAO telefonoDAO;

    //Constructor sin parametros
    public ControladorUsuario() {

    }

    //Constructor con parametros
    public ControladorUsuario(UsuarioDAO usuarioDAO, TelefonoDAO telefonoDAO) {

        this.usuarioDAO = usuarioDAO;
        this.telefonoDAO = telefonoDAO;
    }

    public void registrar(String cedula,String nombre,String apellido,String correo, String contraseña) {
        usuario= new Usuario(cedula, nombre, apellido, correo, contraseña);
        usuarioDAO.create(usuario);
    }
     public Usuario devolverUsuario() {
        return usuario;
    }

    public void verUsuario(String cedula) {

    }

    public void actualizar(String cedula) {

    }

    //Genera un Usuario con la clave ingresada atraves de la vista y lo elimina atraves del DAO
    public void eliminar(String cedula) {

    }
    public void actualizarUsuario(String nombre, String apellido, String cedula, String correo,
            String password) {
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setCorreo(correo);
        usuario.setContraseña(password);
        usuario.setCedula(cedula);

        usuarioDAO.update(usuario);

    }

 
    public Usuario buscarUsuariosPorCedula(String cedula) {
        usuario=usuarioDAO.read(cedula);
        
        return usuario;
    }

    public void agregarTelefono(int codigo, String numero, String tipo, String operadora){
        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefonoDAO.create(telefono);
        usuario.agregarTelefono(telefono);
        usuarioDAO.update(usuario);
    }

    public void eliminarTelefono(int codigo) {
        telefono = telefonoDAO.read(codigo);
        if(telefono != null){
            telefonoDAO.delete(telefono);
            usuario.eliminarTelefono(telefono);
            usuarioDAO.update(usuario);
            telefono= null;
        }
    }

    public void actualizarTelefono(int codigo, String numero, String tipo, String operadora) {
          telefono = new Telefono(codigo, numero, tipo, operadora);
        telefonoDAO.update(telefono);
        usuario.actualizarTelefono(telefono);
        usuarioDAO.update(usuario);

    }

   

    public List<Telefono> listarTelefonos() {
        return usuario.getTelefonos();
    }
    
   
    public boolean validarUsuario(String correo,String contraseña){
       usuario=usuarioDAO.login(correo,contraseña) ;
       if(usuario!=null){
           return true;
       }else{
           return false;
       }
    }
     
     
}
