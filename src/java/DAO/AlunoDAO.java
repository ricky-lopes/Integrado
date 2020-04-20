package DAO;

import MODEL.Aluno;
import java.sql.*;
import java.util.*;

public class AlunoDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private Statement st;
    private ArrayList<Aluno> lista = new ArrayList<>();

    public AlunoDAO() {
        conn = new Conexao().getConexao();
    }

    public boolean result = false;
    public String nome = "";

    public boolean inserir(String nome, int serie, String turma, int rg) {

        try {
            stmt = conn.prepareStatement("SELECT rg_aluno FROM tb_alunos WHERE rg_aluno = ?");
            stmt.setInt(1, rg);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                stmt = conn.prepareStatement("INSERT INTO tb_alunos (nome_aluno,serie_aluno,turma_aluno, rg_aluno) VALUES (?,?,?,?)");
                stmt.setString(1, nome);
                stmt.setInt(2, serie);
                stmt.setString(3, turma);
                stmt.setInt(4, rg);
                stmt.executeUpdate();
                return true;
            }
        } catch (SQLException erro) {
            throw new RuntimeException("ERRO UsuarioDAO - Metodo Inserir Aluno " + erro);
        }
    }

    public String atualizar(String nome, int serie, String turma, int rg, int id) {
        String sql = "UPDATE tb_alunos SET(nome_aluno=?,serie_aluno=?,turma_aluno=?,rg_aluno=? WHERE id_aluno=?)";
        try {
            stmt.setString(1, nome);
            stmt.setInt(2, serie);
            stmt.setString(3, turma);
            stmt.setInt(4, rg);
            stmt.setInt(5, id);
            stmt.execute();
            stmt.close();
        } catch (Exception erro) {
            throw new RuntimeException("ERROR nº3" + erro);
        }
        return "true";
    }

    public void excluir(int valor) {
        String sql = "DELETE FROM tb_alunos WHERE id_aluno = " + valor;
        try {
            st = conn.createStatement();
            st.execute(sql);
            st.close();
        } catch (Exception erro) {
            throw new RuntimeException("Erro 8:" + erro);
        }
    }

    public ArrayList<Aluno> ListarTodos() {
        String sql = "SELECT * FROM tb_alunos";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId_aluno(rs.getInt("id_aluno"));
                aluno.setNome_aluno(rs.getString("nome_aluno"));
                aluno.setSerie_aluno(rs.getInt("serie_aluno"));
                aluno.setTurma_aluno(rs.getString("turma_aluno"));
                aluno.setRg_aluno(rs.getInt("rg_aluno"));
                lista.add(aluno);
            }

        } catch (Exception erro) {
            throw new RuntimeException("Erro 4: " + erro);
        }
        return lista;
    }

    public ArrayList<Aluno> ListarTodosNome(String valor) {
        String sql = "SELECT * FROM tb_alunos WHERE nome_aluno LIKE '%" + valor + "%'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId_aluno(rs.getInt("id_aluno"));
                aluno.setNome_aluno(rs.getString("nome_aluno"));
                aluno.setSerie_aluno(rs.getInt("serie_aluno"));
                aluno.setTurma_aluno(rs.getString("turma_aluno"));
                lista.add(aluno);
            }

        } catch (Exception erro) {
            throw new RuntimeException("Erro 5: " + erro);
        }
        return lista;
    }

    public boolean inserirNota(int idbimestre, int iddisciplina, int idaluno, double avaof1, double avaof2, double trabalhos, double recuperacao) {
        try {
            stmt = conn.prepareStatement("SELECT id_aluno, id_bimestre, id_disciplina FROM tb_nota WHERE id_aluno=? AND id_bimestre = ? AND id_disciplina = ?");
            stmt.setInt(1, idaluno);
            stmt.setInt(2, idbimestre);
            stmt.setInt(3, iddisciplina);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                stmt = conn.prepareStatement("INSERT INTO tb_nota( id_aluno, id_bimestre, id_disciplina, avaof1, avaof2, trab, recuperacao) VALUES (?,?,?,?,?,?,?)");
                stmt.setInt(1, idaluno);
                stmt.setInt(2, idbimestre);
                stmt.setInt(3, iddisciplina);
                stmt.setDouble(4, avaof1);
                stmt.setDouble(5, avaof2);
                stmt.setDouble(6, trabalhos);
                stmt.setDouble(7, recuperacao);
                stmt.executeUpdate();
                return true;
            }

        } catch (SQLException errado) {
            throw new RuntimeException("Erro inserir Nota: " + errado);
        }

    }

}
