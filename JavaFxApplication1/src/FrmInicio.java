/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import views.FrmEscolherTime;

/**
 *
 * @author diego.freitas
 */
public class FrmInicio extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        FrmEscolherTime form = new FrmEscolherTime();
        form.pack();
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
