/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.controlador;

import com.prueba.app.Utils.ProjectException;
import com.prueba.app.modelo.dao.Usuario_RestauranteDAO;
import com.prueba.app.modelo.vo.Restaurantes;
import com.prueba.app.modelo.vo.Usuario_Restaurante;
import com.prueba.app.modelo.vo.Usuarios;
import com.prueba.test.Constantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class UsuarioRestauranteControl {

    Connection cnn;
    Usuario_RestauranteDAO dao;

    public UsuarioRestauranteControl(Connection cnn) {
        this.cnn = cnn;
    }

    public boolean Delete(int id) throws ProjectException {
        dao = new Usuario_RestauranteDAO(cnn);
        boolean result;
        try {
            result = dao.Delete(id);
        } catch (Exception e) {
            throw new ProjectException(100, "fallo eliminacion");
        }
        return result;
    }

    public boolean Insert(Usuario_Restaurante res) throws ProjectException {
        dao = new Usuario_RestauranteDAO(cnn);
        boolean result;
        try {
            result = dao.Insert(res);
        } catch (Exception e) {
            throw new ProjectException(100, "fallo insercion");
        }

        return result;
    }

    public List<Restaurantes> RestaurantsByUser(int id) throws ProjectException {
        List<Restaurantes> listrestaurant;
        dao = new Usuario_RestauranteDAO(cnn);
        try {
            listrestaurant = dao.RestaurantsByUser(id);
        } catch (Exception e) {
            throw new ProjectException(100, "no hay restaurantes por usuario");
        }
        return listrestaurant;
    }

    public List<Usuarios> UsersByRestaurant(int id) throws ProjectException {

        dao = new Usuario_RestauranteDAO(cnn);
        List<Usuarios> listuser;
        try {
            listuser = dao.UsersByRestaurant(id);
        } catch (Exception e) {
            throw new ProjectException(100, "no hay usuarios por restaurante");
        }
        return listuser;
    }
}
