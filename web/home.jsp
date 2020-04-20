

<%@page import="MODEL.Disciplina"%>
<%@page import="DAO.DisciplinaDAO"%>
<%@page import="MODEL.Bimestre"%>
<%@page import="DAO.BimestreDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.AlunoDAO"%>
<%@page import="MODEL.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
        System.out.println(request.getSession(false).getAttribute("id"));
        if((request.getSession(false).getAttribute("id")== null)) {
            response.sendRedirect("index.jsp");
        }
        AlunoDAO ald = new AlunoDAO();
        ArrayList<Aluno> listaAluno = ald.ListarTodos();
        BimestreDAO bmd = new BimestreDAO();
        ArrayList<Bimestre> listaBimestre = bmd.ListarTodosBimestre();
        DisciplinaDAO dsd = new DisciplinaDAO();
        ArrayList<Disciplina> listaDisciplina = dsd.ListarTodasDisciplinas();
        
    %>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Início</title>
        <link rel="stylesheet" href="Style/estilo.css">
    </head>
    <body>
       
        <article id="content">
                <nav>
                    <ul>
                        <li id='liCadastro'>Cadastro Usuário</li>
                        <li id='liAluno'>Cadastro Aluno</li>
                        <li id='liCadastroDisciplina'>Cadastro Disciplina</li>
                        <li id='liNotas'>Lançamento de Notas</li>
                        <li id='liAlunos'>Alunos</li>
                    </ul>
                </nav>
            </article>
        <div id='cadastrarUsuario' style="display:none">
            <h1>Cadastrar Usuário</h1>
            <label>NOME</label>
            <input id="campoNome" type="text" name="nome"/>
            <label>LOGIN</label>
            <input id="campoLogin" type="text" name="login"/>
            <label>SENHA</label>
            <input id="campoSenha" type="text" name="senha"/>
            <button id="btnCadastrar" type="submit">Cadastrar</button>
        </div>
        <div id='cadastrarAluno' style="display:none">
            <h1>Cadastrar Aluno</h1>
            <label>NOME</label>
            <input id="campoNomeAluno" type="text" name="nomeAluno"/>
            <label>SÉRIE</label>
            <input id="campoSerieAluno" type="number" name="serieAluno"/>
            <label>TURMA</label>
            <input id="campoTurmaAluno" type="text" name="turmaAluno"/>
            <label>RG</label>
            <input id="campoRgAluno" type="text" name="rgAluno"/>
            <button id="btnCadastrarAluno" type="submit">Cadastrar</button>
        </div>
        
        <div id='cadastrarDisciplina' style="display:none">
            <h1>Cadastrar Disciplina</h1>
            <label>NOME</label>
            <input id="campoNomeDisciplina" type="text" name="nomeDisciplina"/>            
            <button id="btnCadastrarDisciplina" type="submit">Cadastrar</button>
        </div>
        
         <div id='cadastrarNota' style="display:none">
            <h1>Lançamento de Notas</h1>
            
            <label>NOME</label>
            <select id="listaAluno" >
                <%
                   for (int i = 0; i < listaAluno.size(); i++){
                       out.print("<option value='" + listaAluno.get(i).getId_aluno()+"'>"+ listaAluno.get(i).getNome_aluno()+"</option>");
                   }
                %>
            </select>
            
            <label>DISCIPLINA</label>
            <select id="listaDisciplina" >
                <%
                   for (int i = 0; i < listaDisciplina.size(); i++){
                       out.print("<option value='" + listaDisciplina.get(i).getId_disciplina()+"'>"+ listaDisciplina.get(i).getNome_disciplina()+"</option>");
                   }
                %>
            </select>
            
            <label>BIMESTRE</label>
            <select id="listaBimestre">
            <%
                for (int i = 0; i < listaBimestre.size(); i++){
                    out.print("<option value='" + listaBimestre.get(i).getId_bimestre()+"'>"+ listaBimestre.get(i).getNome_bimestre()+"</option>");
                }
            %>     
                       
            </select>
            
            <label>AVALIAÇÃO PARCIAL 1</label>
            <input id="campoAvaOf1" type="text" name="avalicao1"/>
            <label>AVALIAÇÃO PARCIAL 2</label>
            <input id="campoAvaOf2" type="text" name="avaliacao2"/>
            <label>TRABALHOS</label>
            <input id="campoTrabalhos" type="text" name="trabalho"/>
            <label>RECUPERAÇÃO</label>
            <input id="campoRecuperacao" type="text" name="recuperacao"/>
            <button id="btnCadastrarNota" type="submit">Cadastrar</button>
        </div>
            
        <div id='alunos' style="display:none"> 
            <h1>Alunos</h1><br>
<%
           
               for(int i = 0; i < listaAluno.size();i++){  
                out.print("<table border='1'>");
                out.print("<tr>");
                out.print("<th>ID</th>");
                out.print("<th>NOME</th>");
                out.print("<th>SÉRIE</th>");
                out.print("<th>TURMA</th>");
                out.print("<th>EDITAR</th>");
                out.print("<th>EXCLUIR</th>");
                out.print("</tr>");
                        out.print("<tr>");
                        out.print("<td>"+listaAluno.get(i).getId_aluno()+"</td>");
                        out.print("<td>"+listaAluno.get(i).getNome_aluno()+"</td>");
                        out.print("<td>"+listaAluno.get(i).getSerie_aluno()+"</td>");
                        out.print("<td>"+listaAluno.get(i).getTurma_aluno()+"</td>");
                        out.print("<td><li id='liEditarAluno'>Clique!</li></td>");
                        out.print("<td><li id='liExcluirAluno'>Clique!</li></td>");
                        out.print("</tr>");  
                }
                    out.print("</table>");        
%>     
        </div>
        <div id='editarAluno' style="display:none">
            <h1>Editar Aluno</h1>
            <label>ID</label>
            <input id="campoEditarIdAluno" type="text" name="idAluno"/>
            <label>NOME</label>
            <input id="campoEditarNomeAluno" type="text" name="nomeAluno"/>
            <label>SÉRIE</label>
            <input id="campoEditarSerieAluno" type="number" name="serieAluno"'/>
            <label>TURMA</label>
            <input id="campoEditarTurmaAluno" type="text" name="turmaAluno"/>
            <label>RG</label>
            <input id="campoEditarRgAluno" type="text" name="rgAluno"/>
            <button id="btnEditarAluno" type="submit">Alterar</button>
        </div>
        <div id='excluirAluno' style="display:none">
            <h1>Excluir Aluno</h1>
            <label>ID</label>
            <input id="campoExcluirIdAluno" type="text" name="idAluno"/>
            <label>NOME</label>
            <input id="campoExcluirNomeAluno" type="text" name="nomeAluno"/>
            <button id="btnExcluirAluno" type="submit">Excluir</button>
        </div>
        
        
        <script type="text/javascript" src="javascript/homejs.js"></script>
    </body>
    
</html>
