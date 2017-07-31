/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.test;

import com.prueba.app.modelo.dao.ConexionBD;
import com.prueba.app.modelo.dao.UsuariosDAO;
import com.prueba.app.modelo.vo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Administrador
 */
@WebServlet(name = "PruebaAPPServlet", urlPatterns = {"/PruebaAPPServlet"})
public class PruebaAPPServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PruebaAPPServlet</title>");
            out.println("</head>");
            out.println("<body>");
            try {
                Connection cnn;
                cnn = ConexionBD.getConexionBD();
                out.println("<h1>ok</h1>");
                Usuarios usu = new Usuarios();
//                usu.setNombre("fsdfds");
//                usu.setContraseña("fsdfds");
//                usu.setUsuario("fsdfds");
                UsuariosDAO usudao = new UsuariosDAO(cnn);
//                usudao.Insert(usu);
                ArrayList<Usuarios> list;
                list = usudao.Read();
//                list.forEach((_item) -> {
//                    out.print(String.format("nombre :_%s%n contraseña : %s%n usuario : %s%n", _item.getNombre(), _item.getContraseña(), _item.getUsuario()));
//                });
                //list.forEach((x)-> { );
//                for (Usuarios _item : list) {
//                    out.print(String.format("nombre :_%s%n contraseña : %s%n usuario : %s%n", _item.getNombre(), _item.getContraseña(), _item.getUsuario()));
//                }
                ConexionBD.desconectarBD(cnn);
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<h1>" + e.getMessage() + "</h1>");
            }
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
