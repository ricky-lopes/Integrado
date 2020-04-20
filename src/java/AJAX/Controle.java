
package AJAX;

import DAO.UsuarioDAO;
import MODEL.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Controle extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       switch(request.getServletPath()){
           case "/Logar":
                UsuarioDAO usd = new UsuarioDAO();
                Usuario usu = usd.verificarUsuario(request.getParameter("login"), request.getParameter("senha"));
                if (usu != null){
                    HttpSession session = request.getSession();  
                    session.setAttribute("id", usu.getId_usuario());
                    request.getRequestDispatcher("home.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            break;
        }
    
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
