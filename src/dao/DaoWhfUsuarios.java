/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.WhfUsuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import testes.JdbcCrud;

/**
 *
 * @author u10716099128
 */
public class DaoWhfUsuarios extends DaoAbstract {
    
    @Override
    public void insert(Object object) {
        WhfUsuarios erpUsuarios = (WhfUsuarios) object;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_walmir_silva";
            user = "walmir_silva";
            password = "walmir_silva";
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            String sql = "insert into erp_usuarios values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cnt.prepareStatement( sql );
            pst.setInt(1, erpUsuarios.getwhfIdUsuarios());
            pst.setString(2, whfUsuarios.getwhf_nome());
            pst.setString(3, whfUsuarios.getwhf_email());
            pst.setString(4, whfUsuarios.getwhf_cpf());
            pst.setDate(5, null);
            pst.setInt(6, whfUsuarios.getwhf_nivel());
            pst.setString(7, whfUsuarios.getwhf_senha());
            pst.setString(8, whfUsuarios.getwhf_ativo());
            pst.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
    }

    @Override
    public void delete(Object object) {
        WhfUsuarios erpUsuarios = (WhfUsuarios) object;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, password;
            url = "jdbc:mysql://10.7.0.51:33062/db_walmir_silva";
            user = "walmir_silva";
            password = "walmir_silva";
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = cnt.prepareStatement(
                    "delete from  erp_usuarios where id_erpusuarios=?");
            pst.setInt(1, whfUsuarios.getwhfIdUsuarios());
            pst.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JdbcCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {

        return null;

    }

    @Override
    public Object listAll() {

        return null;

    }
    
 
}