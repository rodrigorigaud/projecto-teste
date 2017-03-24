package com.rodrigo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.rodrigo.Model.Usuario;
import com.rodrigo.Util.DbUtil;

public class UsuarioDao {

    private Connection conn;

    public UsuarioDao() {
        conn = DbUtil.getConnection();
    }

    public void addUsuario(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("insert into users(primeironome,ultimonome,data,email) values (?, ?, ?, ? )");
            
            preparedStatement.setString(1, usuario.getPrimeiroNome());
            preparedStatement.setString(2, usuario.getUltimoNome());
            preparedStatement.setDate(3, new java.sql.Date(usuario.getData().getTime()));
            preparedStatement.setString(4, usuario.getEmail());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarUsuario(int idUsuario) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("delete from users where idusuario=?");
            preparedStatement.setInt(1, idUsuario);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = conn
                    .prepareStatement("update users set primeironome=?, ultimonome=?, data=?, email=?" +
                            "where idusuario=?");
            // Parameters start with 1
            preparedStatement.setString(1, usuario.getPrimeiroNome());
            preparedStatement.setString(2, usuario.getUltimoNome());
            preparedStatement.setDate(3, new java.sql.Date(usuario.getData().getTime()));
            preparedStatement.setString(4, usuario.getEmail());
            preparedStatement.setInt(5, usuario.getIdUsuario());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> getAllUsers() {
        List<Usuario> usuarioList = new ArrayList<Usuario>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setPrimeiroNome(rs.getString("primeironome"));
                usuario.setUltimoNome(rs.getString("ultimonome"));
                usuario.setData(rs.getDate("data"));
                usuario.setEmail(rs.getString("email"));
                usuarioList.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarioList;
    }

    public Usuario getUserById(int idUsuario) {
        Usuario usuario = new Usuario();
        try {
            PreparedStatement preparedStatement = conn.
                    prepareStatement("select * from users where idusuario=?");
            preparedStatement.setInt(1, idUsuario);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idusuario"));
                usuario.setPrimeiroNome(rs.getString("primeironome"));
                usuario.setUltimoNome(rs.getString("ultimonome"));
                usuario.setData(rs.getDate("data"));
                usuario.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
}