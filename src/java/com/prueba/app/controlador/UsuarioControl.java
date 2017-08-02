/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.controlador;

import com.prueba.app.Utils.ProjectException;
import com.prueba.app.modelo.dao.UsuariosDAO;
import java.sql.Connection;
import java.util.List;
import com.prueba.app.modelo.vo.Usuarios;

/**
 *
 * @author Administrador
 */
public class UsuarioControl {

    Connection cnn;
    UsuariosDAO dao;

    public UsuarioControl(Connection cnn) {
        this.cnn = cnn;
    }

    public List<Usuarios> Consultar() throws ProjectException {
        dao = new UsuariosDAO(cnn);
        List<Usuarios> usuarios;
        try {
            usuarios = dao.Read();
            if (usuarios.isEmpty()) {
                throw new ProjectException(100, "lista vacia");
            }
        } catch (Exception e) {
            throw new ProjectException(100, "no hay usuarios");
        }
        return usuarios;
    }

    public boolean Delete(int id) throws ProjectException {
        dao = new UsuariosDAO(cnn);
        boolean result;
        try {
            result = dao.Delete(id);
        } catch (Exception e) {
            throw new ProjectException(100, "fallo eliminacion");
        }
        return result;
    }

    public boolean Insert(Usuarios usu) throws ProjectException {
        dao = new UsuariosDAO(cnn);
        boolean result;
        try {
            result = dao.Insert(usu);
        } catch (Exception e) {
            throw new ProjectException(100, "fallo insercion");
        }
        return result;
    }

    public boolean Update(Usuarios usu) throws ProjectException {
        dao = new UsuariosDAO(cnn);
        boolean result;
        try {
            result = dao.Update(usu);
        } catch (Exception e) {
            throw new ProjectException(100, "fallo la actualizacion");
        }
        return result;
    }
}
