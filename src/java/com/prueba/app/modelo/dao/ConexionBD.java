/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.modelo.dao;

/**
 *
 * @author Administrador
 */
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionBD {
    
    public static Connection getConexionBD()throws NamingException, SQLException{
        InitialContext contexto = new InitialContext();
        DataSource origenDeDatos = (DataSource)contexto.lookup("gestor_restaurantes_sena");
        Connection cnn = origenDeDatos.getConnection();
        cnn.setAutoCommit(false);        
        return cnn;
    }
    
    public static void desconectarBD(Connection cnn) throws SQLException{
        cnn.commit();
        cnn.close();
    }
    
    public static void reservarBD(Connection cnn) throws SQLException{
        cnn.rollback();
        cnn.close();
    }
    
}
