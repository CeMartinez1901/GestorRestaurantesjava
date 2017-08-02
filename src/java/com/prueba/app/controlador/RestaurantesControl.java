/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.controlador;

import com.prueba.app.Utils.ProjectException;
import com.prueba.app.modelo.dao.RestaurantesDAO;
import java.net.ConnectException;
import com.prueba.app.modelo.vo.Restaurantes;
import java.sql.Connection;
import java.util.List;
/**
 *
 * @author Administrador
 */
public class RestaurantesControl {
    
    Connection cnn;
    RestaurantesDAO dao;

    public RestaurantesControl(Connection cnn) {
        this.cnn = cnn;
    }

    public List<Restaurantes> Consultar() throws ProjectException {
        dao = new RestaurantesDAO(cnn);
        List<Restaurantes> restaurantes;
        try {
            restaurantes = dao.Read();
            if (restaurantes.isEmpty()) {
                throw new ProjectException(100, "lista vacia");
            }
        } catch (Exception e) {
            throw new ProjectException(100, "no hay usuarios");
        }
        return restaurantes;
    }

    public boolean Delete(int id) throws ProjectException {
        dao = new RestaurantesDAO(cnn);
        boolean result;
        try {
            result = dao.Delete(id);
        } catch (Exception e) {
            throw new ProjectException(100, "fallo eliminacion");
        }
        return result;
    }

    public boolean Insert(Restaurantes res) throws ProjectException {
        dao = new RestaurantesDAO(cnn);
        boolean result;
        try {
            result = dao.Insert(res);
        } catch (Exception e) {
            throw new ProjectException(100, "fallo insercion");
        }
        return result;
    }

    public boolean Update(Restaurantes res) throws ProjectException {
        dao = new RestaurantesDAO(cnn);
        boolean result;
        try {
            result = dao.Update(res);
        } catch (Exception e) {
            throw new ProjectException(100, "fallo la actualizacion");
        }
        return result;
    }  
}
