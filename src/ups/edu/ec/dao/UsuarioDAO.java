/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.dao;

import java.io.IOException;
import java.io.RandomAccessFile;

import java.util.List;

import ups.edu.ec.idao.IUsuarioDAO;
import ups.edu.ec.modelo.Usuario;

/**
 *
 * @author user
 */
public class UsuarioDAO implements IUsuarioDAO {

    /**
     * private String cedula; 10 private String nombre; 25 private String
     * apellido; 25 private String correo; 50 private String contraseña; 8 118
     * bytes+10
     *
     *
     *
     */
    private RandomAccessFile archivo;

    public UsuarioDAO() {

        try {
            archivo = new RandomAccessFile("datos/usuario.dat", "rw");
        } catch (IOException ex) {
            System.out.println("error de lectura y escritura");
            ex.printStackTrace();
        }
    }

    @Override
    public void create(Usuario usuario) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(usuario.getCedula());
            archivo.writeUTF(usuario.getNombre());
            archivo.writeUTF(usuario.getApellido());
            archivo.writeUTF(usuario.getCorreo());
            archivo.writeUTF(usuario.getContraseña());
        } catch (IOException ex) {
            System.out.println("error en el create UsuarioDAO");
        }
    }

    @Override
    public Usuario read(String cedula) {
        int salto = 0;
        int registro = 128;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF().trim();
                if (cedula.trim().equals(cedulaArchivo)) {
                    Usuario u = new Usuario(cedula, archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim());
                    return u;
                }
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(readUsuario)");
        }
        return null;
    }

    @Override
    public void update(Usuario usuario) {
        int salto = 0;
        int registro = 128;
        String cedula = usuario.getCedula();
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF().trim();
                if (cedula.trim().equals(cedulaArchivo)) {

                    archivo.writeUTF(usuario.getNombre());
                    archivo.writeUTF(usuario.getApellido());
                    archivo.writeUTF(usuario.getCorreo());
                    archivo.writeUTF(usuario.getContraseña());
                    break;
                }
                salto += registro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(upDateUsuario)");
        }
    }

    @Override
    public void delete(Usuario usuario) {
        int registro = 128;
        try {
            String cedula = usuario.getCedula();
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF();
                if (cedula.trim().equals(cedulaArchivo.trim())) {
                    archivo.writeUTF(llenarEspacios(10));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(50));
                    archivo.writeUTF(llenarEspacios(8));
                    break;
                }
                salto += registro;
            }

        } catch (IOException ex) {
            System.out.println("Error delete usuario");
        }
    }

    public String llenarEspacios(int espacios) {
        String aux = "";
        return String.format("%-" + espacios + "s", aux);
    }

    @Override
    public boolean login(String correo, String contraseña) {
        try {
            int salto = 66;
            int registro = 128;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String correoArchivo = archivo.readUTF();
                String contraseñaArchivo = archivo.readUTF();
                if (correo.equals(correoArchivo.trim()) && contraseña.equals(contraseñaArchivo.trim())) {
                    return true;
                }
                salto += registro;
            }

        } catch (IOException ex) {
            System.out.println("error login");
        }
        return false;

    }
}
