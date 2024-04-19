/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 *
 * @author Jeffrey Leiva
 */
public class ScrollBarCustom extends JScrollBar {
    
    public ScrollBarCustom(){
        setUI(new ModernScrollbarUI());
        setPreferredSize(new Dimension(8,8));
        setForeground(new Color(87, 89, 94));
        setBackground(Color.WHITE);
    }
}
