/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import views.FrmPartida;


/**
 *
 * @author diego.freitas
 */
public class Jogo {
    private Equipe mandante, visitante;
    private Equipe vencedor, timeComBola, timeSemBola;
    private String resultado;
    private int golsM, golsV, minuto;
    private Timer timer = new Timer(5000, null);
    private FrmPartida tela;
    private JTable tabela;
    
    
    public Jogo(Equipe m, Equipe v, FrmPartida tela){
        this.mandante = m;
        this.visitante = v;    
        this.tela = tela;
    }
    
   
    
    public void jogar(JTable tabela) throws InterruptedException{
        timeComBola = mandante;
        timeSemBola = visitante;
        this.tabela = tabela;
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        /*vantFinalizacaoM = o quão o ataque do mandante é mais forte que a defesa do... 
        ... visitante, vantFinalizacaoV vice-versa*/
        float vantFinalizacaoM = (mandante.getAtaque() / 
                (mandante.getAtaque() + visitante.getDefesa())) * 10;
        
        float vantFinalizacaoV = (visitante.getAtaque() / 
                (visitante.getAtaque() + mandante.getDefesa())) * 10;
        
        float vantPasseM = (visitante.getPasse() / 
                (visitante.getAtaque() + mandante.getDefesa())) * 10;
        
        float vantPasseV = (visitante.getAtaque() / 
                (visitante.getAtaque() + mandante.getDefesa())) * 10;
        
        
        visitante.setIncisivo(true);
        visitante.setPressao(false);
        
        model.addRow(new Object[] {"começa o jogo"});
        lances(model, vantFinalizacaoM, vantFinalizacaoV, vantPasseM, vantPasseV);
            
       
    }
    
    public boolean finalizacao(List<Jogador> equipe, DefaultTableModel model) throws InterruptedException{
        Random r = new Random();
        Jogador finalizador = equipe.get(r.nextInt(equipe.size()));
        model.addRow(new Object[] {"Chance para " + finalizador.getNome()});
        //quanto maior o atributo de ataque do finalizador mais chance dele fazer o gol
        if(finalizador.getAtaque() > r.nextInt(11)) 
            return true;
       
        return false;
    }
    
    public boolean saidaDeBola(Equipe equipe, Equipe marcador, DefaultTableModel model){
        Random r = new Random();
        Jogador jogador;
        int parametro = 11, x;
        
        x = r.nextInt(7);
        if(x >= 2){// mais chance do jogador que vai sair com a bola ser o armador
            jogador = equipe.getArmador();
        }else{
            jogador = equipe.getJogadores().get(x);
        }
        
        model.addRow(new Object[] {"vem pra saída o " +  timeSemBola.getNome() + " com " + 
                jogador.getNome()});
        
        if(marcador.isPressao()){
            /*se a equipe marcando estiver pressionando o parametro para sorteio
            fica mais alto, logo mais chances da saída de bola sair errada
            */
            parametro = ((int) marcador.getDefesa()) + 5;
            model.addRow(new Object[] {"Pressão na saída"});
        }
        
        if(equipe.getArmador().getPasse() > r.nextInt(parametro))
            return true;
        else
            return false;
    }
    
    public void lances(DefaultTableModel model, float vantagemFM, float vantagemFV, float vantagemPM, float vantagemPV){
        minuto = 0;
        Random gerador = new Random();
        
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = gerador.nextInt(10);
                boolean pressaoAlta = mandante.isPressao();
                float vantagemF = vantagemFV;
                float vantagemP = vantagemPV;
                boolean segurandoPosse = false;
                
                
                
                model.addRow(new Object[] {Integer.toString(minuto)+"'-----------"});  //printa o minuto atual do jogo
                
                model.addRow(new Object[] {timeComBola.getNome() + " no ataque"});
                
                if(timeComBola.equals(mandante)){
                    vantagemF = vantagemFM;
                    vantagemP = vantagemPM;
                    pressaoAlta = visitante.isPressao();
                }
                
                //fase da posse de bola, aqui o time conseguiu sair com a bola
                if((x < vantagemF || pressaoAlta)){ //se o numero sorteado for menor que o volume de quem tem a posse, quem tem a posse tem a chance e finalizar
                    try {
                        if(minuto >= 15)
                            x = 1;
                        else
                            x = gerador.nextInt(3); /// trocar isso por alguma relação com a mentalidade do time futuramente
                        
                        if(timeComBola.isIncisivo() || x == 0){
                            if(finalizacao(timeComBola.getJogadores(), model)){ //caso o método de finalização retorne verdadeiro, o gol foi marcado
                                model.addRow(new Object[] {"gol do " + timeComBola.getNome()});
                                if(timeComBola.equals(mandante))
                                    golsM++;
                                else
                                    golsV++;
                                
                                atitudeDoAdversario(); //a partir do placar o advserário "reorganiza" sua atitude
                                model.setColumnIdentifiers(new Object[] {mandante.getNome() + " " + Integer.toString(golsM) + " x " +
                                        Integer.toString(golsV) + " " + visitante.getNome()});
                            }else{
                                model.addRow(new Object[] {"perdeu!"});
                            }
                        }else{ //aqui o time vai tentar segurar a bola
                            x = gerador.nextInt(10);
                            model.addRow(new Object[] {"não tem pressa o " + timeComBola.getNome()});
                            if(x < vantagemP){ //aqui o time conseguiu segurar a bola
                                segurandoPosse = true;
                                model.addRow(new Object[] {"toca a bola o " + timeComBola.getNome()});
                            }else{
                                model.addRow(new Object[] {"rouba a bola o " + timeSemBola.getNome()}); //aqui o time roubou a bola em seu campo de defesa, então precisa tentar sair com a bola
                            }
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }else{
                    model.addRow(new Object[] {"perde a bola o " +  timeComBola.getNome()});
                }

                if(!segurandoPosse){//se o time com a posse não conseguiu segurar a posse, o outro time tem a oportunidade de sair                     
                    if(saidaDeBola(timeSemBola, timeComBola, model)){//entra aqui se o outro time conseguiu sair com a bola
                        trocaDePosse(); //a posse muda
                    }else{
                        /*aqui a ideia é que o time perdeu a bola tentando sair, então o outro não precisa sair com bola
                        já que recuperou a bola numa fase já ofensiva, portanto não há loop nesse trecho*/
                        model.addRow(new Object[] {"erra a saída o " +  timeSemBola.getNome()});
                    }
                }
                
                
                
                if(minuto != 20){
                    minuto++;
                }else{
                    timer.stop();
                    model.addRow(new Object[] {"fim de jogo"});
                    tela.finalizarPartida();
                    placarFinal(model);
                }
                
                tabela.scrollRectToVisible(tabela.getCellRect(model.getRowCount()-1, 0, true));


                }
        };
        
        timer.addActionListener(action);
        timer.setRepeats(true);
        
        timer.start();
       
    }
    
    public void placarFinal(DefaultTableModel model){
        
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado = Integer.toString(golsM) + " x " + Integer.toString(golsV);
        
                if(golsM > golsV){
                    model.addRow(new Object[] {mandante.getNome() + " vence o jogo"});
                    vencedor = mandante;
                }else if(golsV > golsM){
                    model.addRow(new Object[] {visitante.getNome() + " vence o jogo"});
                    vencedor = visitante;
                }else{
                    model.addRow(new Object[] {"empate!"});
                }
        
                model.addRow(new Object[] {resultado});
                
                tabela.scrollRectToVisible(tabela.getCellRect(model.getRowCount()-1, 0, true));
        
            }
        };
        
        Timer timerFinal = new Timer(2000, action);
        timerFinal.setRepeats(false);
        timerFinal.start();
    }
    
    public void pausar(){
        timer.stop();
    }
    
    public void voltar(){
        timer.restart();
    }
    
    public void trocaDePosse(){
        Equipe auxiliar;
        auxiliar = timeComBola;
        timeComBola = timeSemBola;
        timeSemBola = auxiliar;    
    }
    /*
    public void roubadadeBola(Equipe ladrao, Equipe roubado, boolean roubadaNoAtaque){
        
    }
*/

    public void atitudeDoAdversario(){
        //se o time adversário estiver em desvantagem no placar, será mais incisivo e vai tentar pressionar a saída
        if(golsV!=golsM){
            visitante.setIncisivo(golsV<golsM);
            visitante.setPressao(golsV<golsM);
        }else{
            visitante.setIncisivo(true);
            visitante.setPressao(false);
        }
        
    }
    public Equipe getMandante() {
        return mandante;
    }

    public void setMandante(Equipe mandante) {
        this.mandante = mandante;
    }

    public Equipe getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipe visitante) {
        this.visitante = visitante;
    }

    public Equipe getVencedor() {
        return vencedor;
    }

    public void setVencedor(Equipe vencedor) {
        this.vencedor = vencedor;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getGolsM() {
        return golsM;
    }

    public void setGolsM(int golsM) {
        this.golsM = golsM;
    }

    public int getGolsV() {
        return golsV;
    }

    public void setGolsV(int golsV) {
        this.golsV = golsV;
    }
    
    
}
