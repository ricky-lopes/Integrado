package DAO;
import MODEL.Disciplina;
import java.sql.*;
import java.util.*;

public class DisciplinaDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Statement st;
    private ArrayList<Disciplina>listaDisciplina = new ArrayList<>();
    
public DisciplinaDAO(){
conn = new Conexao().getConexao();
}    

public boolean result = false;
public String nome = "";

public boolean inserir (String nome){
    
    try {
        stmt = conn.prepareStatement("SELECT nome_disciplina FROM tb_disciplinas WHERE nome_disciplina = ?");
        stmt.setString(1, nome);
        rs = stmt.executeQuery();
        if (rs.next()) {
            return false;
        }else {
            stmt = conn.prepareStatement("INSERT INTO tb_disciplinas (nome_disciplina) VALUES (?)");
            stmt.setString(1, nome);
            stmt.executeUpdate();
            return true;
        }
    } catch (SQLException erro) {
        throw new RuntimeException("ERRO DisciplinaDAO - Metodo Inserir Disciplina "+ erro);
    }
}

public ArrayList<Disciplina> ListarTodasDisciplinas(){
        String sql = "SELECT * FROM tb_disciplinas";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Disciplina disciplina  = new Disciplina();
                disciplina.setId_disciplina(rs.getInt("id_disciplina"));
                disciplina.setNome_disciplina(rs.getString("nome_disciplina"));
                listaDisciplina.add(disciplina);
            }
                 
        }catch(Exception erro){
            throw new RuntimeException("Erro 4: "+erro);
        }
        return listaDisciplina;
    } 

public ArrayList<Disciplina> ListarTodosNomeDisciplina(String valor){
        String sql = "SELECT * FROM tb_disciplina WHERE nome_disciplina LIKE '%"+valor+"%'";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Disciplina disciplina  = new Disciplina();
                disciplina.setId_disciplina(rs.getInt("id_disciplina"));
                disciplina.setNome_disciplina(rs.getString("nome_disciplina"));
                listaDisciplina.add(disciplina);
            }
            
        }catch(Exception erro){
            throw new RuntimeException("Erro 5: "+erro);
        }
        return listaDisciplina;

}}

