/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RestauranteUsuario",
        urlPatterns = {"/resusu/insertar", "/resusu/eliminar", "/resusu/consultar", "/resusu/actualizar"})
public class UsuarioRestauranteServletGeneric extends GenericServlet{

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
        
   
    }    
}
