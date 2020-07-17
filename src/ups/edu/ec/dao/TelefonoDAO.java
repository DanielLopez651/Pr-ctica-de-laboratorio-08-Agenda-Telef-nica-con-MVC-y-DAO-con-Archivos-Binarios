/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ups.edu.ec.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ups.edu.ec.idao.ITelefonoDAO;
import ups.edu.ec.modelo.Telefono;
import ups.edu.ec.modelo.Usuario;

/**
 *
 * @author user
 */
public class TelefonoDAO implements ITelefonoDAO {
    private int codigo;
    private List<Telefono> listaTelefono;
    private Telefono telefono;
    public TelefonoDAO() {
        listaTelefono = new ArrayList<>();
        codigo=0;
    }

    public List<Telefono> getListaTelefono() {
        return listaTelefono;
    }

    @Override
    public void create(Telefono telefono) {
        telefono.setCodigo(++codigo);
        listaTelefono.add(telefono);
    }

    @Override
    public Telefono read(int codigo) {
        for (Telefono telefono : listaTelefono) {
            if (telefono.getCodigo() == codigo) {
                return telefono;
            }

        }
        return null;
    }

    @Override
    public void update(Telefono telefono) {
        for (int i = 0; i < listaTelefono.size(); i++) {
            Telefono t = listaTelefono.get(i);
            if (t.getCodigo() == telefono.getCodigo()) {
                listaTelefono.set(i, telefono);
                break;
            }
        }
    }

    @Override
    public void delete(Telefono telefono) {
        Iterator<Telefono> it = listaTelefono.iterator();
        while (it.hasNext()) {
            Telefono t = it.next();
            if (t.getCodigo() == telefono.getCodigo()) {
                it.remove();
                break;
            }
        }

    }

    @Override
    public List<Telefono> findAll() {
        return listaTelefono;
    }

    @Override
    public int obtenerUltimoCodigo() {
        return codigo;
        
    }
    
   
   
}
