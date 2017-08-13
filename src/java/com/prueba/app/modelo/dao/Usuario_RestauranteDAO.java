/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.modelo.dao;

import com.prueba.app.Interfases.IGenericDao;
import com.prueba.app.modelo.vo.Restaurantes;
import com.prueba.app.modelo.vo.Usuario_Restaurante;
import com.prueba.app.modelo.vo.Usuarios;
import com.prueba.app.Utils.Constantes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class Usuario_RestauranteDAO implements IGenericDao<Usuario_Restaurante> {

    Connection cnn;

    public Usuario_RestauranteDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public boolean Insert(Usuario_Restaurante res) throws SQLException {

        boolean result;

        PreparedStatement sentencia = cnn.prepareStatement(Constantes.InsertUserRestaurant);
        sentencia.setInt(1, res.getId_Restaurante());
        sentencia.setInt(2, res.getId_Usuario());
        result = sentencia.execute();
        return result;
    }

    public boolean Delete(int id) throws SQLException {

        boolean result;

        PreparedStatement sentencia = cnn.prepareStatement(Constantes.DeleteUserRestaurant);
        sentencia.setInt(1, id);
        result = sentencia.execute();
        return result;
    }

    public List<Restaurantes> RestaurantsByUser(int id) throws SQLException {

        ArrayList<Restaurantes> listrestaurant = new ArrayList<>();
        ResultSet result;

        PreparedStatement sentencia = cnn.prepareStatement(Constantes.ListRestaurantUser);
        sentencia.setInt(1, id);
        result = sentencia.executeQuery();

        while (result.next()) {
            Restaurantes restaurant = new Restaurantes();
            restaurant.setId(result.getInt(1));
            restaurant.setNombre(result.getString(2));
            restaurant.setZona(result.getString(3));
            listrestaurant.add(restaurant);
        }

        return listrestaurant;
    }

    public List<Usuarios> UsersByRestaurant(int id) throws SQLException {

        ArrayList<Usuarios> listuser = new ArrayList<>();
        ResultSet result;

        PreparedStatement sentencia = cnn.prepareStatement(Constantes.ListUserRestaurant);
        sentencia.setInt(1, id);
        result = sentencia.executeQuery();

        while (result.next()) {
            Usuarios user = new Usuarios();
            user.setId(result.getInt(1));
            user.setNombre(result.getString(2));
            user.setUsuario(result.getString(3));
            listuser.add(user);
        }

        return listuser;
    }

    @Override
    public Usuario_Restaurante Consultar(Usuario_Restaurante T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario_Restaurante> Leer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Actualizar(Usuario_Restaurante T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(Usuario_Restaurante T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insertar(Usuario_Restaurante t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }
