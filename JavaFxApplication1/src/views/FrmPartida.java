package views;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entidades.Equipe;
import entidades.Jogador;
import entidades.Jogo;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diego.freitas
 */
public class FrmPartida extends javax.swing.JFrame {

    /**
     * Creates new form FrmPartida
     */
    private Equipe mandante, visitante;
    private Jogo jogo;
    private String pressao, ritmo;
    DefaultTableModel model;
    
    public FrmPartida() {
        initComponents();
        
        
    }
    
    public FrmPartida(Equipe mandante, Equipe visitante, String pressao, String ritmo) {
        initComponents();
        this.mandante = mandante;
        this.visitante = visitante;
        this.pressao = pressao;
        this.ritmo = ritmo;
        
        if(pressao.equals("Baixa"))
            cmbPressao.setSelectedIndex(1);
        else
            cmbPressao.setSelectedIndex(0);
        
        if(ritmo.equals("Cadenciado"))
            cmbRitmo.setSelectedIndex(0);
        else
            cmbRitmo.setSelectedIndex(1);
        
        btnPausar.setEnabled(false);
        cmbPressao.setEnabled(false);
        cmbRitmo.setEnabled(false);
        btnVoltarInicio.setEnabled(false);
        
        model = (DefaultTableModel) tbPartida.getModel();
        model.setColumnIdentifiers(new Object[] {mandante.getNome() + " 0 x 0 " + visitante.getNome()});
        
        
               
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        btnIniciarPartida = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPartida = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnPausar = new javax.swing.JButton();
        cmbPressao = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbRitmo = new javax.swing.JComboBox<>();
        btnVoltarInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIniciarPartida.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnIniciarPartida.setText("começar");
        btnIniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPartidaActionPerformed(evt);
            }
        });

        tbPartida.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        tbPartida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 4"
            }
        ));
        tbPartida.setToolTipText("");
        tbPartida.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbPartida.setFocusTraversalPolicyProvider(true);
        tbPartida.setName(""); // NOI18N
        tbPartida.setRowHeight(20);
        tbPartida.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbPartida);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel1.setText("Pressão:");

        btnPausar.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnPausar.setText("Pausar");
        btnPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarActionPerformed(evt);
            }
        });

        cmbPressao.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        cmbPressao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alta", "Baixa" }));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        jLabel2.setText("Ritmo: ");

        cmbRitmo.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        cmbRitmo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cadenciado", "Objetivo" }));

        btnVoltarInicio.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        btnVoltarInicio.setText("Voltar ao Início");
        btnVoltarInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(btnIniciarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPausar)
                .addGap(148, 148, 148))
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPressao, 0, 135, Short.MAX_VALUE)
                            .addComponent(cmbRitmo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnVoltarInicio)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnIniciarPartida)
                    .addComponent(btnPausar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cmbPressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbRitmo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltarInicio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPartidaActionPerformed
        // TODO add your handling code here:

        if(!btnIniciarPartida.getText().equals("Começar")){
            model.setRowCount(0);
            btnVoltarInicio.setEnabled(false);
        }
            

        btnIniciarPartida.setEnabled(false);
        btnPausar.setEnabled(true);
        cmbPressao.setEnabled(true);
        cmbRitmo.setEnabled(true);
        
        try {
            
            if(pressao.equals("Baixa"))
                mandante.setPressao(false);
            else
                mandante.setPressao(true);
            
            if(ritmo.equals("Cadenciado"))
                mandante.setIncisivo(false);
            else
                mandante.setIncisivo(true);
            
            jogo = new Jogo(mandante, visitante, this);
            jogo.jogar(tbPartida);
        } catch (InterruptedException ex) {
            Logger.getLogger(FrmPartida.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
      
    }//GEN-LAST:event_btnIniciarPartidaActionPerformed

    private void btnPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarActionPerformed
        // TODO add your handling code here:
        if(btnPausar.getText().equals("Pausar")){
            jogo.pausar();   
            btnPausar.setText("Voltar");
            btnVoltarInicio.setEnabled(true);
        }else{
            
            btnPausar.setText("Pausar");
            if(cmbPressao.getSelectedItem().toString().equals("Baixa"))
                jogo.getMandante().setPressao(false);
            else
                jogo.getMandante().setPressao(true);
            
            if(cmbRitmo.getSelectedItem().toString().equals("Cadenciado"))
                jogo.getMandante().setIncisivo(false);
            else
                jogo.getMandante().setIncisivo(true);
            
            btnVoltarInicio.setEnabled(false);
            jogo.voltar();
        }
    }//GEN-LAST:event_btnPausarActionPerformed

    private void btnVoltarInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarInicioActionPerformed
        // TODO add your handling code here:
        int op = JOptionPane.showConfirmDialog(this, "Deseja realmente voltar a tela inicial?");
        if (op == JOptionPane.YES_OPTION){
            this.setVisible(false);
            FrmEscolherTime frm = new FrmEscolherTime();
            frm.setVisible(true);
        }else{
            return;
        }
    }//GEN-LAST:event_btnVoltarInicioActionPerformed
    
    public void finalizarPartida(){
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIniciarPartida.setEnabled(true);
                btnIniciarPartida.setText("Jogar novamente");
                btnVoltarInicio.setEnabled(true);
                
            }
        };
        
        Timer timerFinal = new Timer(4000, action);
        
        timerFinal.setRepeats(false);
        timerFinal.start();
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarPartida;
    private javax.swing.JButton btnPausar;
    private javax.swing.JButton btnVoltarInicio;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.JComboBox<String> cmbPressao;
    private javax.swing.JComboBox<String> cmbRitmo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbPartida;
    // End of variables declaration//GEN-END:variables
}
