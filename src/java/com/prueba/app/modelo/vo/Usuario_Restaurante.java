/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.modelo.vo;

import java.util.List;

/**
 *
 * @author Administrador
 */
public class Usuario_Restaurante {
    private List<Usuarios> ListaUsuarios;
    private List<Restaurantes> ListaRestaurantes;
    private Integer Id;
    private Integer Id_Usuario;
    private Integer Id_Restaurante;

    /**
     * @return the ListaUsuarios
     */
    public List<Usuarios> getListaUsuarios() {
        return ListaUsuarios;
    }

    /**
     * @param ListaUsuarios the ListaUsuarios to set
     */
    public void setListaUsuarios(List<Usuarios> ListaUsuarios) {
        this.ListaUsuarios = ListaUsuarios;
    }

    /**
     * @return the ListaRestaurantes
     */
    public List<Restaurantes> getListaRestaurantes() {
        return ListaRestaurantes;
    }

    /**
     * @param ListaRestaurantes the ListaRestaurantes to set
     */
    public void setListaRestaurantes(List<Restaurantes> ListaRestaurantes) {
        this.ListaRestaurantes = ListaRestaurantes;
    }

    /**
     * @return the Id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Integer Id) {
        this.Id = Id;
    }

    /**
     * @return the Id_Usuario
     */
    public Integer getId_Usuario() {
        return Id_Usuario;
    }

    /**
     * @param Id_Usuario the Id_Usuario to set
     */
    public void setId_Usuario(Integer Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    /**
     * @return the Id_Restaurante
     */
    public Integer getId_Restaurante() {
        return Id_Restaurante;
    }

    /**
     * @param Id_Restaurante the Id_Restaurante to set
     */
    public void setId_Restaurante(Integer Id_Restaurante) {
        this.Id_Restaurante = Id_Restaurante;
    }
}
