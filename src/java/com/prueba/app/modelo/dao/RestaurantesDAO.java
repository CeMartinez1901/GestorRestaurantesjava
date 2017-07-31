/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.modelo.dao;

import com.prueba.app.modelo.vo.Restaurantes;
import com.prueba.test.Constantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class RestaurantesDAO {

    Connection cnn;

    public RestaurantesDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public boolean Insert(Restaurantes res) throws SQLException {

        boolean result;

        PreparedStatement sentences = cnn.prepareStatement(Constantes.InsertRestaurant);
        sentences.setString(1, res.getNombre());
        sentences.setString(2, res.getZona());
        result = sentences.execute();
        return result;
    }

    public boolean Update(Restaurantes res) throws SQLException {

        boolean result;

        PreparedStatement sentences = cnn.prepareStatement(Constantes.UpdateRestaurant);
        sentences.setString(1, res.getNombre());
        sentences.setString(2, res.getZona());
        result = sentences.execute();
        return result;
    }

    public boolean Delete(int id) throws SQLException {

        boolean result;

        PreparedStatement sentences = cnn.prepareStatement(Constantes.DeleteRestaurant);
        sentences.setInt(1, id);
        result = sentences.execute();
        return result;
    }

    public List<Restaurantes> Read() throws SQLException {

        ArrayList<Restaurantes> list_restaurant = new ArrayList<>();
        ResultSet result;

        PreparedStatement sentences = cnn.prepareStatement(Constantes.SelectRestaurant);
        result = sentences.executeQuery();

        while (result.next()) {
            Restaurantes restaurant = new Restaurantes();
            restaurant.setId(result.getInt("id"));
            restaurant.setNombre(result.getString("nombre"));
            restaurant.setZona(result.getString("zona"));
            list_restaurant.add(restaurant);
        }
        return list_restaurant;
    }
}
