/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.ImageIcon;



/**
 *
 * @author Jeffrey Leiva
 */
public class Card {
    private int number;
    public boolean canBeSelected;
    private ImageIcon image;
    
    public Card(){
        this.canBeSelected = true;
    }
    
    public boolean areCardsEqual(Card card){
        return this.number == card.number;
    }
    
    public void setNumber(int number){
        this.number = number;
    }
    
    public void setImageIcon(ImageIcon img){
        this.image = img;
    }
    
    public ImageIcon getImg(){
        return this.image;
    }
    
    public void changeStateCanBeSelected(){
        this.canBeSelected = !this.canBeSelected;
    }
}
