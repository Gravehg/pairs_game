/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Card;
import View.GameView;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Jeffrey Leiva
 */
public class GameController {
    
    private GameView view;
    ArrayList<Card> selectionedCards;
    ArrayList<JButton>selectionedButtons;
    int score = 0;
    private static final int NUM_ROWS = 13;
    private static final int NUM_COLS = 4;
    private static final int THRESHOLD_SCORE = 52;
    public Card [][] cards = new Card[NUM_ROWS][NUM_COLS];
    private Map<Integer, ImageIcon> imageMap;

    
    public GameController(GameView view) throws Exception{
        this.view = view;
        this.selectionedCards = new ArrayList();
        this.selectionedButtons = new ArrayList();
        this.imageMap = createImageMap();
        this.view.updateScore(score);
        addButtonsActionListener();
        initCards();
    }
    
    
    private Map<Integer,ImageIcon> createImageMap() throws Exception{
        Map<Integer, ImageIcon> map = new HashMap<>();
        String path = "imgs";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles == null) throw new Exception("No files found");
        for(int i =0 ; i < listOfFiles.length;i++){
            map.put(i, new ImageIcon(path+"//"+listOfFiles[i].getName()));
        }
        return map;
    }
    
    
    public int getScore(){
        return this.score;
    }
    
    private void initCards(){
        
        int[] numbers = new int[26 * 2];
        for (int i = 0; i < 26; i++) {
            numbers[i * 2] = i;
            numbers[i * 2 + 1] = i;
        }
        
        shuffleArray(numbers);
        
        int index = 0;
         for(int i = 0; i < NUM_ROWS; i++){
            for(int j = 0;  j < NUM_COLS; j++){
                int value = numbers[index];
                ImageIcon img = this.imageMap.get(value);
                cards[i][j] = new Card();
                cards[i][j].setNumber(value);
                cards[i][j].setImageIcon(img);
                index++;
            }
        }
    }
    
    
   private static void shuffleArray(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    
    private void addButtonsActionListener(){
          for (int i = 0; i < view.getButtons().length; i++){
            for (int j = 0; j < view.getButtons()[0].length; j++){
                view.getButtons()[i][j].addActionListener(e -> onCardClicked(e));
            }
          }
    }
    public void onCardClicked(ActionEvent e){
        
        if(selectionedCards.size() < 2){
             for (int i = 0; i < view.getButtons().length; i++){
               for (int j = 0; j < view.getButtons()[0].length; j++){
                   if(e.getSource()==view.getButtons()[i][j]){
                       if(cards[i][j].canBeSelected){
                           selectionedCards.add(cards[i][j]);
                           selectionedButtons.add(view.getButtons()[i][j]);
                           view.getButtons()[i][j].setIcon(cards[i][j].getImg());
                           break;
                       }
                   }
               }
             }
        }
        
        if(selectionedCards.size() == 2){
            compareCards();
        }
    }
    
    public void compareCards(){
        
        if(!selectionedCards.get(0).areCardsEqual(selectionedCards.get(1))){
            view.showMessageDidNotMatch();
            selectionedButtons.get(0).setIcon(null);
            selectionedButtons.get(1).setIcon(null);
        }else{
            selectionedCards.get(0).changeStateCanBeSelected();
            selectionedCards.get(1).changeStateCanBeSelected();
            score += 2;
            view.updateScore(score);
            checkEndGame();
        }
        selectionedCards.clear();
        selectionedButtons.clear();
    }
    
    private void checkEndGame(){
        if(score == THRESHOLD_SCORE){
            view.showMessageWin();
        }
    }
}
