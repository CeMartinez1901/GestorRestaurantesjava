    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.app.modelo.vo;

/**
 *
 * @author Administrador
 */
public class Restaurantes {
    private Integer Id;
    private String Nombre;
    private String Zona;

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
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Zona
     */
    public String getZona() {
        return Zona;
    }

    /**
     * @param Zona the Zona to set
     */
    public void setZona(String Zona) {
        this.Zona = Zona;
    }
    
    
}
