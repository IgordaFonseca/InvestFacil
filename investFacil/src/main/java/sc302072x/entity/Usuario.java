package sc302072x.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.LinkedList;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private LinkedList<Carteira> carteiras;

    public Usuario() {
    }

    public Usuario(String cpf, String nome, String email, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        carteiras = new LinkedList<>();

    }

    public void alterarUsuario(Usuario usuario){
        this.cpf = usuario.getCpf();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }

    public void login(){

    }

    public void adicionarCarteira(Carteira carteira){
        carteiras.add(carteira);
    }

    public void removerCarteira(Carteira carteira){
        carteiras.remove(carteira);
    }

    public void removerCarteira(int id){
        for(Carteira c: carteiras){
            if(c.getId() == id){
                carteiras.remove(c);
            }
        }
    }

    public void listarCarteiras(){
        for(Carteira c: carteiras){
            c.toString();
        }

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LinkedList<Carteira> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(LinkedList<Carteira> carteiras) {
        this.carteiras = carteiras;
    }
}
