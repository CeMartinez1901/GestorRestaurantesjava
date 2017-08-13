/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.vista;

import com.google.gson.Gson;
import com.prueba.app.Utils.ProjectException;
import com.prueba.app.controlador.UsuarioControl;
import com.prueba.app.modelo.dao.ConexionBD;
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

/**
 *
 * @author ASUS
 */
@WebServlet(name = "Usuarios",
        urlPatterns = {"/usu/insertar", "/usu/eliminar", "usu/consultar", "/usu/actualizar"})
public class UsuarioServlet extends GenericServlet {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException, NamingException, SQLException, ProjectException {
        boolean result = false;
        Connection cnn = null;
        String message = null;
        cnn = ConexionBD.getConexionBD();
        String data = request.getParameter("data");
        UsuarioControl usuariocontrol = new UsuarioControl(cnn);
        Usuarios usuario = new Gson().fromJson(data, Usuarios.class);

        switch (request.getMethod()) {
            case "/usu/insertar":
                result = usuariocontrol.Insert(usuario);
                if (!result) {
                    throw new ProjectException(100, "fallo insercion");
                }
                message = new Gson().toJson(result);
                break;
                
            case "/usu/eliminar":
                result = usuariocontrol.Delete(usuario);
                message = new Gson().toJson(result);
                break;
                
            case "usu/consultar":
                List<Usuarios> listusuarios = usuariocontrol.Consultar();
                message = new Gson().toJson(listusuarios);
                break;
                
            case "/usu/actualizar":
                result = usuariocontrol.Update(usuario);
                message = new Gson().toJson(result);
                break;
        }
        out.print(message);
    }
}
