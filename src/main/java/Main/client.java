/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Controller.GameController;
import View.GameView;

/**
 *
 * @author Jeffrey Leiva
 */
public class client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        GameView view = new GameView();
        GameController controller = new GameController(view);
        view.setController(controller);
        view.setVisible(true);
    }
    
}
