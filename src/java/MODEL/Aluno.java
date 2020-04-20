package MODEL;

public class Aluno {
    
    private int id_aluno;
    private String nome_aluno;
    private int serie_aluno;
    private String turma_aluno;
    private int rg_aluno;

    public int getRg_aluno() {
        return rg_aluno;
    }

    public void setRg_aluno(int rg_aluno) {
        this.rg_aluno = rg_aluno;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public int getSerie_aluno() {
        return serie_aluno;
    }

    public void setSerie_aluno(int serie_aluno) {
        this.serie_aluno = serie_aluno;
    }

    public String getTurma_aluno() {
        return turma_aluno;
    }

    public void setTurma_aluno(String turma_aluno) {
        this.turma_aluno = turma_aluno;
    }

}