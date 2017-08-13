/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.Interfases;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDao<T extends IGenericVo> {

    public T Consultar(T t) throws SQLException;

    public List<T> Leer() throws SQLException;

    public boolean Actualizar(T t) throws SQLException;

    public void Eliminar(T t) throws SQLException;

    public boolean Insertar(T t) throws SQLException;

}
