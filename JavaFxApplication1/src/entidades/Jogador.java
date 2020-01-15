/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author diego.freitas
 */
public class Jogador {
    private String nome;
    private int ataque, passe, defesa, overall;

    public Jogador(String nome, int ataque, int defesa, int passe) {
        this.nome = nome;
        this.ataque = ataque;
        this.defesa = defesa;
        this.passe = passe;
        
        this.overall = (ataque + defesa + passe) / 3;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getPasse() {
        return passe;
    }

    public void setPasse(int passe) {
        this.passe = passe;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }
    
    
    
}
