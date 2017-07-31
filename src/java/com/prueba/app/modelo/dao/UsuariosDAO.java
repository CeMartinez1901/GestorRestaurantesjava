/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.modelo.dao;

import com.prueba.app.modelo.vo.Usuarios;
import com.prueba.test.Constantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class UsuariosDAO {

    Connection cnn;

    public UsuariosDAO(Connection cnn) {
        this.cnn = cnn;
    }

    public boolean Insert(Usuarios usu) throws SQLException {

        boolean result;

        PreparedStatement sentences = cnn.prepareStatement(Constantes.InsertUser);
        sentences.setString(1, usu.getNombre());
        sentences.setString(2, usu.getContraseña());
        sentences.setString(3, usu.getUsuario());
        result = sentences.execute();
        return result;

    }

    public boolean Update(Usuarios usu) throws SQLException {

        boolean result;

        PreparedStatement sentences = cnn.prepareStatement(Constantes.UpdateUser);
        sentences.setString(1, usu.getNombre());
        sentences.setString(2, usu.getUsuario());
        sentences.setInt(3, usu.getId());
        result = sentences.execute();
        return result;
    }

    public ArrayList<Usuarios> Read() throws SQLException {

        ResultSet result;
        ArrayList<Usuarios> users = new ArrayList<>();

        PreparedStatement sentences = cnn.prepareStatement(Constantes.SelectUsers);
        result = sentences.executeQuery();
        while (result.next()) {
            Usuarios user = new Usuarios();
            user.setId(result.getInt("id"));
            user.setNombre(result.getString("nombre"));
            user.setUsuario(result.getString("usuario"));
            user.setContraseña(result.getString("contrasena"));
            users.add(user);
        }
        return users;
    }

    public boolean Delete(int id) throws SQLException {

        boolean result;

        PreparedStatement sentences = cnn.prepareStatement(Constantes.DeleteUser);
        sentences.setInt(1, id);
        result = sentences.execute();
        return result;
    }

}
