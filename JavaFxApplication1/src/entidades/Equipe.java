/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author diego.freitas
 */
public class Equipe {
    private String nome;
    private float entrosamento;
    private boolean pressao, incisivo;
    private float ataque, defesa, passe;
    private List<Jogador> jogadores;
    private Jogador armador;
    
    public Equipe(String nome, List<Jogador> jogadores, float entrosamento, Jogador armador){
        this.nome = nome;
        this.jogadores = jogadores;
        this.armador = armador;
        this.entrosamento = entrosamento;
        
        float att = 0, def = 0, pass = 0;
        for(Jogador jogador : jogadores){
            att += jogador.getAtaque();
            def += jogador.getDefesa();
            pass += jogador.getPasse();
        }
        
        /*os atributos da equipe são definidos pela soma dos atributos dos jogadores
        vezes o entrosamento da equipe*/
        float entr = (entrosamento / 10);
        this.ataque = (att / 3.0f) * entr;
        this.defesa = (def / 3.0f) * entr;
        this.passe = (def / 3.0f) * entr;
        
        
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public float getEntrosamento() {
        return entrosamento;
    }

    public void setEntrosamento(float entrosamento) {
        this.entrosamento = entrosamento;
    }

    public float getAtaque() {
        return ataque;
    }

    public void setAtaque(float ataque) {
        this.ataque = ataque;
    }

    public float getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public Jogador getArmador() {
        return armador;
    }

    public void setArmador(Jogador armador) {
        this.armador = armador;
    }

    public boolean isPressao() {
        return pressao;
    }

    public void setPressao(boolean pressao) {
        this.pressao = pressao;
    }

    public boolean isIncisivo() {
        return incisivo;
    }

    public void setIncisivo(boolean incisivo) {
        this.incisivo = incisivo;
    }

    public float getPasse() {
        return passe;
    }

    public void setPasse(float passe) {
        this.passe = passe;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipe other = (Equipe) obj;
        if (Float.floatToIntBits(this.entrosamento) != Float.floatToIntBits(other.entrosamento)) {
            return false;
        }
        if (Float.floatToIntBits(this.ataque) != Float.floatToIntBits(other.ataque)) {
            return false;
        }
        if (Float.floatToIntBits(this.defesa) != Float.floatToIntBits(other.defesa)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.jogadores, other.jogadores)) {
            return false;
        }
        if (!Objects.equals(this.armador, other.armador)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
