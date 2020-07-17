/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.dao;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ups.edu.ec.idao.IUsuarioDAO;
import ups.edu.ec.modelo.Usuario;

/**
 *
 * @author user
 */
public class UsuarioDAO implements IUsuarioDAO {
//    private String cedula;      | 10 bytes +2
//    private String nombre;      | 25 bytes +2
//    private String apellido;    | 25 bytes +2
//    private String correo;      | 50 bytes +2
//    private String contraseña;  |  8 bytes +2
//                                = 118 +10=128bytes            

    private List<Usuario> listaUsuario;

    public UsuarioDAO() {
        listaUsuario = new ArrayList<>();
    }

    @Override
    public void create(Usuario usuario) {
        listaUsuario.add(usuario);
    }

    @Override
    public Usuario read(String cedula) {
        for (Usuario usuario : listaUsuario) {
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }

        }
        return null;
    }

    @Override
    public void update(Usuario usuario) {
        for (int i = 0; i < listaUsuario.size(); i++) {
            Usuario u = listaUsuario.get(i);
            if (u.getCedula().equals(usuario.getCedula())) {
                listaUsuario.set(i, usuario);
                break;
            }
        }
    }

    @Override
    public void delete(Usuario usuario) {
        Iterator<Usuario> it = listaUsuario.iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            if (u.getCedula().equals(usuario.getCedula())) {
                it.remove();
                break;
            }
        }

    }

    @Override
    public List<Usuario> findAll() {
        return listaUsuario;
    }

    @Override
    public Usuario login(String correo, String contraseña) {
        for (Usuario usuario : findAll()) {
            if (usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contraseña)) {

                return usuario;
            }
        }
        return null;
    }

}
