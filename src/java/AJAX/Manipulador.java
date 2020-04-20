
package AJAX;

import DAO.AlunoDAO;
import DAO.DisciplinaDAO;
import DAO.UsuarioDAO;
import MODEL.Aluno;
import java.io.IOException;
import java.util.ArrayList;
import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Manipulador extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       switch(request.getServletPath()){
            case "/ListarAluno":
                try{
                    
                    
                }catch(Exception erro) {
                    throw new RuntimeException("Erro Manipulador Listar Aluno" + erro);
                }
            break;
        } 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        System.out.println(request.getServletPath());
        switch(request.getServletPath()){
           case "/Cadastrar":
                try {
                   UsuarioDAO usd = new UsuarioDAO();
                   response.getWriter().write(Boolean.toString(usd.inserir(request.getParameter("nome"), request.getParameter("login"), request.getParameter("senha"))));
               } catch (Exception e) {
                    throw new RuntimeException("ERRO Manipulador Cadastrar" + e );
               }
            break;
            case "/CadastrarAluno":
                try {
                   AlunoDAO ald = new AlunoDAO();
                   //responde.getWriter().write => devolve para JavaScript
                   response.getWriter().write(Boolean.toString(ald.inserir(request.getParameter("nome"),Integer.parseInt(request.getParameter("serie")), request.getParameter("turma"), Integer.parseInt(request.getParameter("rg")))));
               } catch (Exception e) {
                    throw new RuntimeException("ERRO Manipulador Cadastrar Aluno" + e );
               }
            break;
            case "/CadastrarDisciplina":
                try {
                   DisciplinaDAO dsd = new DisciplinaDAO();
                   //responde.getWriter().write => devolve para JavaScript
                   response.getWriter().write(Boolean.toString(dsd.inserir(request.getParameter("nome"))));
               } catch (Exception e) {
                    throw new RuntimeException("ERRO Manipulador Cadastrar Disciplina" + e );
               }
            break;
            case "/CadastrarNota":
                try {
                   AlunoDAO ald = new AlunoDAO();
                    //ald.inserirNota(Integer.parseInt(request.getParameter("idbimestre")), Integer.parseInt(request.getParameter("disciplina")), Integer.parseInt(request.getParameter("idaluno")),Double.parseDouble(request.getParameter("avaliacao1")),Double.parseDouble(request.getParameter("avaliacao2")),Double.parseDouble(request.getParameter("trabalho")),Double.parseDouble(request.getParameter("recuperacao"))));
                   //responde.getWriter().write => devolve para JavaScript
                   response.getWriter().write(Boolean.toString(ald.inserirNota(Integer.parseInt(request.getParameter("idbimestre")), Integer.parseInt(request.getParameter("disciplina")), Integer.parseInt(request.getParameter("idaluno")),Double.parseDouble(request.getParameter("avaliacao1")),Double.parseDouble(request.getParameter("avaliacao2")),Double.parseDouble(request.getParameter("trabalho")),Double.parseDouble(request.getParameter("recuperacao")))));
               } catch (Exception e) {
                    throw new RuntimeException("ERRO Manipulador Cadastrar Nota => " + e );
               }
            break;
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
