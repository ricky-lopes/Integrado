package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import MODEL.Usuario;
import java.sql.SQLException;



public class UsuarioDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Statement st;
    
    
    public UsuarioDAO(){
        conn = new Conexao().getConexao();     
    }
    
    public Usuario verificarUsuario(String login, String senha){
        String sql = "select id_usuario, nome_usuario, login_usuario from tb_usuarios " + "where login_usuario = ? and senha_usuario = ?";
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            if(rs.next()){
                Usuario usu = new Usuario();
                usu.setId_usuario(rs.getInt("id_usuario"));
                usu.setLogin_usuario(rs.getString("login_usuario"));
                usu.setNome_usuario(rs.getString("nome_usuario"));
                System.out.println(usu.getId_usuario());
                System.out.println(usu.getLogin_usuario());
                System.out.println(usu.getNome_usuario());
                return usu; 
            }
        }catch(Exception erro){
            throw new RuntimeException("Erro 2 - Verificar: "+erro);    
        }
        return null;
    }
    public boolean inserir(String nome, String login, String senha ){
            System.out.println(nome);
        try {
            stmt = conn.prepareStatement("SELECT login_usuario FROM tb_usuarios WHERE login_usuario = ?");
            stmt.setString(1, login);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return false;
            }else {
                stmt = conn.prepareStatement("INSERT INTO tb_usuarios(nome_usuario, login_usuario, senha_usuario) VALUES(?,?,?)");
                stmt.setString(1, nome);
                stmt.setString(2, login);
                stmt.setString(3, senha);
                stmt.executeUpdate();
                return true;
            }
        } catch (SQLException erro) {
            throw new RuntimeException("ERRO UsuarioDAO - Metodo Inserir "+ erro);
        }
    }
}
