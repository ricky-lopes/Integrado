$("#btnCadastrar").click(function(){
    $.ajax({
        type : 'POST',
        data: {
            nome: $("#campoNome").val(),
            login: $("#campoLogin").val(),
            senha: $("#campoSenha").val()
        },
        url : 'Cadastrar',
        success: function (response){
            if ( response == 'true'){
                alert("Usuário Cadastrado com Sucesso!");
            }else{
                alert("Falha ao Cadastrar Usuário!");
            }  
        }
    });
});
$("#btnCadastrarAluno").click(function(){
    $.ajax({
        type : 'POST',
        data: {
            nome: $("#campoNomeAluno").val(),
            serie: $("#campoSerieAluno").val(),
            turma: $("#campoTurmaAluno").val(),
            rg: $("#campoRgAluno").val()
        },
        url : 'CadastrarAluno',
        success: function (response){
            if ( response == 'true'){
                alert("Aluno Cadastrado Com Sucesso!");
            }else{
                alert("Falha Ao Cadastrar Aluno!");
            }  
        }
    });
});
$("#btnCadastrarNota").click(function(){
    $.ajax({
       type : 'POST',
       data: {
            disciplina: $("#listaDisciplina option:selected ").attr("value"),
            idaluno: $("#listaAluno option:selected").attr("value"),
            idbimestre: $("#listaBimestre option:selected").attr("value"),
            avaliacao1: $("#campoAvaOf1").val(),
            avaliacao2: $("#campoAvaOf2").val(),
            trabalho: $("#campoTrabalhos").val(),
            recuperacao: $("#campoRecuperacao").val()
        },
        url : 'CadastrarNota',
        success: function (response){
               if ( response == 'true'){
                alert("Nota Cadastrada Com Sucesso Por Favor Karaleo");
            }else{
                alert(response);  
            }    
        }
    });
});

$("#btnCadastrarDisciplina").click(function(){
    $.ajax({
        type : 'POST',
        data: {
            nome: $("#campoNomeDisciplina").val()
        },
        url : 'CadastrarDisciplina',
        success: function (response){
            if ( response == 'true'){
                alert("Disciplina Cadastrado Com Sucesso!");
            }else{
                alert("Falha Ao Cadastrar Disciplina!");
            }  
        }
    });
});

$("#btnEditarAluno").click(function(){
    $.ajax({
        type : 'POST',
        data: {
            nome: $("#campoNomeAluno").val(),
            serie: $("#campoSerieAluno").val(),
            turma: $("#campoTurmaAluno").val(),
            rg: $("#campoRgAluno").val()
        },
        url : 'AlterarAluno',
        success: function (response){
            if ( response == 'true'){
                alert("Aluno Alterado Com Sucesso!");
            }else{
                alert("Falha Ao Alterar Aluno!");
            }  
        }
    });
});

$("#liCadastro").click(function(){
    $("#cadastrarUsuario").show();
    $("#cadastrarAluno").hide();
    $("#cadastrarNota").hide();
    $("#alunos").hide();
    $("#cadastrarDisciplina").hide();
    $("#editarAluno").hide();
    $("#excluirAluno").hide();
});

$("#liAluno").click(function(){
    $("#cadastrarAluno").show();
    $("#cadastrarUsuario").hide();
    $("#cadastrarNota").hide();
    $("#alunos").hide();
     $("#cadastrarDisciplina").hide();
     $("#editarAluno").hide();
     $("#excluirAluno").hide();
});

$("#liNotas").click(function(){
    $("#cadastrarNota").show();
    $("#cadastrarUsuario").hide();
    $("#cadastrarAluno").hide();
    $("#alunos").hide();
     $("#cadastrarDisciplina").hide();
     $("#editarAluno").hide();
     $("#excluirAluno").hide();
});

$("#liAlunos").click(function(){
    $("#alunos").show();
    $("#cadastrarNota").hide();
    $("#cadastrarUsuario").hide();
    $("#cadastrarAluno").hide();
    $("#cadastrarDisciplina").hide();
    $("#editarAluno").hide();
    $("#excluirAluno").hide();
});

$("#liCadastroDisciplina").click(function(){
    $("#cadastrarDisciplina").show();
    $("#cadastrarUsuario").hide();
    $("#cadastrarAluno").hide();
    $("#cadastrarNota").hide();
    $("#alunos").hide();
    $("#editarAluno").hide();
    $("#excluirAluno").hide();
});

$("#liEditarAluno").click(function(){
    $("#editarAluno").show();
    $("#alunos").hide();
    $("#cadastrarNota").hide();
    $("#cadastrarUsuario").hide();
    $("#cadastrarAluno").hide();
    $("#cadastrarDisciplina").hide();
    $("#excluirAluno").hide();
});

$("#liExcluirAluno").click(function(){
    $("#excluirAluno").show();
    $("#editarAluno").hide();
    $("#alunos").hide();
    $("#cadastrarNota").hide();
    $("#cadastrarUsuario").hide();
    $("#cadastrarAluno").hide();
    $("#cadastrarDisciplina").hide();
});
