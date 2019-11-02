/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.*;

/**
 *
 * @author vinic
 */
public class ModuloConnection {
// responsavel por estabelecer conexao com o banco

    public static Connection conector() {
        java.sql.Connection conexao = null;
        // linha abaixo "chama" o drive
        String driver = "com.mysql.jdbc.Driver";
        // armazenando informaçoes referente ao banco
        String url = "jdbc:mysql://localhost:3306/financas";
        String user = "root";
        String password = "";
        //estabelecendo conexão com o banco
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            //System.out.println(e);
            return null;
        }
    }
}