/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.test;

/**
 *
 * @author ASUS
 */
public class Constantes {

    //Usuario
    public static final String InsertUser = "INSERT INTO USUARIO (nombre,contrasena,usuario) VALUES (?,?,?);";
    public static final String UpdateUser = "UPDATE USUARIO SET nombre = ?, usuario ? WHERE id = ?";
    public static final String SelectUsers = "SELECT * FROM USUARIO";
    public static final String DeleteUser = "DELETE FROM USUARIO WHERE id = ?";

    //Restaurante
    public static final String InsertRestaurant = "INSERT INTO RESTAURANTE (nombre,zona) VALUES (?,?);";
    public static final String UpdateRestaurant = "UPDATE RESTAURANTE SET nombre = ?, zona ? WHERE id = ?";
    public static final String SelectRestaurant = "SELECT * FROM RESTAURANTE";
    public static final String DeleteRestaurant = "DELETE FROM RESTAURANTE WHERE id = ?";

    //Usuario_Restaurante
    public static final String InsertUserRestaurant = "INSERT INTO usuario_restaurante (id_restaurante,id_usuarios) VALUES (?,?);";
    public static final String DeleteUserRestaurant = "DELETE FROM usuario_restaurante WHERE id = ?;";
    public static final String ListRestaurantUser = "SELECT res.id, res.nombre, res.zona FROM RESTAURANTE res INNER JOIN USUARIO_RESTAURANTE usures ON res.id = usures.id_restaurante INNER JOIN USUARIO usu on usu.id = usures.id_usuario WHERE usu.id = ?;";
    public static final String ListUserRestaurant = "SELECT usu.id, usu.nombre, usu.usuario FROM restaurante res INNER JOIN usuario_restaurante usures ON res.id = usures.id_restaurante INNER JOIN usuario usu ON usu.id = usures.id_usuario WHERE res.id = ?;";

}
