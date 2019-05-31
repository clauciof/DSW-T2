/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author clauc
 */
@Entity
public class Teatro implements Serializable{
    
    
    
    @Column(nullable = false, unique=true)
    private String email;
    
    @Column(nullable = false, unique=false)
    private String senha;
    
    @Column(nullable = false, unique=false)
    private String cidade;
    
    @Column(nullable = false, unique=false)
    private String nome;
    
    @Column(nullable = false, unique=false)
    private String cnpj;
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
   @OneToMany(mappedBy = "teatro", fetch = FetchType.LAZY)
    private List<Promocao> promocoes;
   
    
    public String getEmail() {return this.email;}
    public String getSenha() {return this.senha;}
    public String getCidade() {return this.cidade;}
    public String getNome() {return this.nome;}
    public String getCnpj() {return this.cnpj;}
    public Integer getId() {return this.id;}
    public List<Promocao> getPromocoes() {return promocoes;}

    public void setSenha(String senha) {this.senha = senha;}
    public void setEmail(String email) {this.email = email;}
    public void setCidade(String cidade) {this.cidade = cidade;}
    public void setNome(String nome) {this.nome = nome;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}
    public void setId(Integer id) {this.id = id;}
    public void setPromocoes(List<Promocao> promocoes) {this.promocoes = promocoes;}
    
    
    
}
