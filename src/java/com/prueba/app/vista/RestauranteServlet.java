/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.vista;

import com.google.gson.Gson;
import com.prueba.app.Utils.ProjectException;
import com.prueba.app.controlador.RestaurantesControl;
import com.prueba.app.controlador.UsuarioControl;
import com.prueba.app.modelo.dao.ConexionBD;
import com.prueba.app.modelo.vo.Restaurantes;
import com.prueba.app.modelo.vo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Restaurante",
        urlPatterns = {"/res/insertar", "/res/eliminar", "/res/consultar", "/res/actualizar"})
public class RestauranteServlet extends GenericServlet {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException, ProjectException,NamingException,SQLException {
        boolean result = false;
        Connection cnn = null;
        String message = null;
        cnn = ConexionBD.getConexionBD();
        String data = request.getParameter("data");
        RestaurantesControl restaurantecontrol = new RestaurantesControl(cnn);
        Restaurantes restaurante = new Gson().fromJson(data, Restaurantes.class);

        switch (request.getMethod()) {
            case "/res/insertar":
                result = restaurantecontrol.Insert(restaurante);
                if (!result) {
                    throw new ProjectException(100, "fallo insercion");
                }
                message = new Gson().toJson(result);
                break;

            case "/res/eliminar":
                restaurantecontrol.Delete(restaurante);
                break;

            case "res/consultar":
                List<Restaurantes> listrestaurantes = restaurantecontrol.Consultar();
                message = new Gson().toJson(listrestaurantes);
                break;

            case "/res/actualizar":
                result = restaurantecontrol.Update(restaurante);
                message = new Gson().toJson(result);
                break;
        }
        out.print(message);
    }

}
