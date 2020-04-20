package DAO;

import MODEL.Bimestre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BimestreDAO {
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Statement st;
    private final ArrayList<Bimestre>listaBimestre = new ArrayList<>();
    
  public BimestreDAO() {
      conn = new Conexao().getConexao();
  }
    
    public ArrayList<Bimestre> ListarTodosBimestre(){
        String sql = "SELECT * FROM bimestre";
        try{
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Bimestre bimestre  = new Bimestre();
                bimestre.setId_bimestre(rs.getInt("id_bimestre"));
                bimestre.setNome_bimestre(rs.getString("nome_bimestre"));
                System.out.println(bimestre.getId_bimestre());
                listaBimestre.add(bimestre);
            }
                 
        }catch(SQLException erro){
            throw new RuntimeException("Erro BimestreDAO Listar Todos Bimestre: "+erro);
        }
        return listaBimestre;
    } 
    
}
