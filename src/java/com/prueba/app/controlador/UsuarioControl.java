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
import java.sql.SQLException;

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

    public List<Usuarios> Consultar() throws ProjectException, SQLException {
        dao = new UsuariosDAO(cnn);
        List<Usuarios> usuarios;
        try {
            usuarios = dao.Leer();
            if (usuarios.isEmpty()) {
                throw new ProjectException(100, "lista vacia");
            }
        } catch (ProjectException e) {
            throw new ProjectException(100, "no hay usuarios");
        }
        return usuarios;
    }

    public boolean Delete(Usuarios usu) throws ProjectException {
        dao = new UsuariosDAO(cnn);
        
        
        try {
           dao.Eliminar(usu);
        } catch (Exception e) {
            throw new ProjectException(100, "fallo eliminacion");
        }
        return false;
    }

    public boolean Insert(Usuarios usu) throws ProjectException {
        dao = new UsuariosDAO(cnn);
        boolean result;
        try {
            result = dao.Insertar(usu);
        } catch (Exception e) {
            throw new ProjectException(100, "fallo insercion");
        }
        return false;
    }

    public boolean Update(Usuarios usu) throws ProjectException {
        dao = new UsuariosDAO(cnn);
        boolean result;
        try {
            result = dao.Actualizar(usu);
        } catch (SQLException e) {
            throw new ProjectException(100, "fallo la actualizacion");
        }
        return result;
    }
}
