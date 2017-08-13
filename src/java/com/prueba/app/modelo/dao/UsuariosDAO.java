/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.modelo.dao;

import com.prueba.app.Interfases.IGenericDao;
import com.prueba.app.modelo.vo.Usuarios;
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
public class UsuariosDAO implements IGenericDao<Usuarios> {

    Connection cnn;

    public UsuariosDAO(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public Usuarios Consultar(Usuarios T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuarios> Leer() throws SQLException {
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

    @Override
    public boolean Actualizar(Usuarios T) throws SQLException {
        boolean result = true;

        PreparedStatement sentences = cnn.prepareStatement(Constantes.UpdateUser);
        sentences.setString(1, T.getNombre());
        sentences.setString(2, T.getUsuario());
        sentences.setInt(3, T.getId());
        sentences.execute();
        return result;
    }

    @Override
    public void Eliminar(Usuarios T) throws SQLException {

        PreparedStatement sentences = cnn.prepareStatement(Constantes.DeleteUser);
        sentences.setInt(1, T.getId());
        sentences.execute();
    }

    @Override
    public boolean Insertar(Usuarios t) throws SQLException {
        boolean result = true;
        PreparedStatement sentences = cnn.prepareStatement(Constantes.InsertUser);
        sentences.setString(1, t.getNombre());
        sentences.setString(2, t.getContraseña());
        sentences.setString(3, t.getUsuario());
        sentences.execute();
        return result;
    }

}
