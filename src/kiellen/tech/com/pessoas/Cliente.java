package kiellen.tech.com.pessoas;

import kiellen.tech.com.composicao.Profissao;

import java.util.Scanner;

public class Cliente extends Pessoa{
    private String codigo;
    private Profissao profissao;
    private String tipoProfissaoOutros;
    private Scanner leitor = new Scanner(System.in);

    public String getGodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public void cadastrar(){
        super.cadastrar();
        System.out.println("Informe o código do cliente: ");
        this.codigo = leitor.nextLine();
        System.out.println("Informe a profissão do cliente: ");
        Profissao profissao = Profissao.valueOf(leitor.nextLine());
        if(profissao == Profissao.OUTROS){
            this.tipoProfissaoOutros = leitor.nextLine();
        }

    }

    public String toString(){
        return "Cliente{" +
                "codigo=" + codigo + '\'' +
                ", profissao=" + profissao +
                ", tipoProfissaoOutros=" + tipoProfissaoOutros + '\'' +
                "}";
    }



}
