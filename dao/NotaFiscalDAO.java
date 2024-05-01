package com.mycompany.exemplocrudjdbc.dao;

import com.mycompany.exemplocrudjdbc.models.NotaFiscal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author juan.adsantos
 */
public class NotaFiscalDAO {

    public static String URL = "jdbc:mysql://localhost:3306/basenotafiscal";
    public static String login = "root";
    public static String senha = "P@$$w0rd";

    public static boolean salvar(NotaFiscal a) {
        boolean retorno = false;
        Connection conexao = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO notafiscal(numeroNota, valorNota) VALUES(?,?)");

            comandoSQL.setInt(1, a.getNumeroNota());
            comandoSQL.setDouble(2, a.getValorNota());

            int linhasAfetadas = comandoSQL.executeUpdate();

            return linhasAfetadas > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
    
    public static boolean alterar(NotaFiscal a) {
        boolean retorno = false;
        Connection conexao = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE notafiscal SET numeroNota = ?, valorNota = ? WHERE idNota = ?");

            comandoSQL.setInt(1, a.getNumeroNota());
            comandoSQL.setDouble(2, a.getValorNota());
            comandoSQL.setInt(3, a.getIdNota());
            
            
            int linhasAfetadas = comandoSQL.executeUpdate();

            return linhasAfetadas > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }
      public static boolean excluir(int idExcluir) {
        boolean retorno = false;
        Connection conexao = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("DELETE notafiscal WHERE idNota = ?");

            comandoSQL.setInt(1, idExcluir);
            
            
            int linhasAfetadas = comandoSQL.executeUpdate();

            return linhasAfetadas > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    public static ArrayList<NotaFiscal> listar() {
        ArrayList<NotaFiscal> list = new ArrayList<>();

        Connection conexao = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM notafiscal");

//            comandoSQL.setInt(1, a.getNumeroNota());
//            comandoSQL.setDouble(2, a.getValorNota());
            ResultSet rs = comandoSQL.executeQuery();

            while(rs.next()){
//                int idNota = rs.getInt("idNota");
//                int numeroNota = rs.getInt("numeroNota");
//                double valorNota = rs.getDouble("valorNota");
                NotaFiscal item = new NotaFiscal(rs.getInt("idNota"), rs.getInt("numeroNota"), rs.getDouble("valorNota"));
                list.add(item);
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
     public static ArrayList<NotaFiscal> buscarPorNumero(int num) {
        ArrayList<NotaFiscal> list = new ArrayList<>();

        Connection conexao = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conexao = DriverManager.getConnection(URL, login, senha);

            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM notafiscal WHERE numeroNota = ?");

            comandoSQL.setInt(1, num);
//            comandoSQL.setDouble(2, a.getValorNota());
            ResultSet rs = comandoSQL.executeQuery();

            while(rs.next()){
//                int idNota = rs.getInt("idNota");
//                int numeroNota = rs.getInt("numeroNota");
//                double valorNota = rs.getDouble("valorNota");
                NotaFiscal item = new NotaFiscal(rs.getInt("idNota"), rs.getInt("numeroNota"), rs.getDouble("valorNota"));
                list.add(item);
            }
            
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NotaFiscalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

}
