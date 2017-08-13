/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.modelo.dao;

import com.prueba.app.Interfases.IGenericDao;
import com.prueba.app.modelo.vo.Restaurantes;
import com.prueba.app.Utils.Constantes;
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
public class RestaurantesDAO
        implements IGenericDao<Restaurantes> {

    Connection cnn;

    public RestaurantesDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public boolean Delete(int id) throws SQLException {

        boolean result;

        PreparedStatement sentences = cnn.prepareStatement(Constantes.DeleteRestaurant);
        sentences.setInt(1, id);
        result = sentences.execute();
        return result;
    }

    @Override
    public Restaurantes Consultar(Restaurantes T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Restaurantes> Leer() throws SQLException {
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

    @Override
    public boolean Actualizar(Restaurantes T) throws SQLException {
         boolean result;

        PreparedStatement sentences = cnn.prepareStatement(Constantes.UpdateRestaurant);
        sentences.setString(1, T.getNombre());
        sentences.setString(2, T.getZona());
        result = sentences.execute();
        return result;
    }

    @Override
    public void Eliminar(Restaurantes T) throws SQLException {
        PreparedStatement sentences = cnn.prepareStatement(Constantes.DeleteRestaurant);
        sentences.setInt(1, T.getId());
        sentences.execute();
    }

    @Override
    public boolean Insertar(Restaurantes T) throws SQLException {
        boolean result;

        PreparedStatement sentences = cnn.prepareStatement(Constantes.InsertRestaurant);
        sentences.setString(1, T.getNombre());
        sentences.setString(2, T.getZona());
        result = sentences.execute();
        return result;
    }
}
