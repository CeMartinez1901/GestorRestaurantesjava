/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.vista;

import com.google.gson.Gson;
import com.prueba.app.Utils.ProjectException;
import com.prueba.app.controlador.RestaurantesControl;
import com.prueba.app.modelo.dao.ConexionBD;
import com.prueba.app.modelo.vo.Restaurantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "RestauranteServlet", urlPatterns = {"/restaurante"})
public class RestauranteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ProjectException , NamingException , SQLException{
        response.setContentType(MediaType.APPLICATION_JSON);
        Connection cnn = null;
        try (PrintWriter out = response.getWriter()) {
            boolean result = false;
            String message = null;
            cnn = ConexionBD.getConexionBD();
            String action = request.getParameter("action");
            action = (action == null) ? "default" : action;
            String data = request.getParameter("data");
            RestaurantesControl restaurantecontrol = new RestaurantesControl(cnn);
            Restaurantes restaurante = new Gson().fromJson(data, Restaurantes.class);
            switch (action) {
                case "insert":
                    result = restaurantecontrol.Insert(restaurante);
                    message = new Gson().toJson(result);
                    break;
                case "update":
                    result = restaurantecontrol.Update(restaurante);
                    message = new Gson().toJson(result);
                    break;
                case "delete":
                    result = restaurantecontrol.Delete(restaurante.getId());
                    message = new Gson().toJson(result);
                    break;
                default:
                    List<Restaurantes> listarestaurantes = restaurantecontrol.Consultar();
                    message = new Gson().toJson(listarestaurantes);
                    break;
            }
            out.print(message);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ProjectException ex) {
            Logger.getLogger(RestauranteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(RestauranteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RestauranteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(RestauranteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
