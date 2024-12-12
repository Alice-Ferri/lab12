package it.unibo.es3;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

public class GUI extends JFrame {
    
    private final Map<Pair<Integer, Integer>, JButton> cells = new HashMap<>();
    private final JButton bottonToGo = new JButton(">");
    private final Logics logics;
    
    public GUI(int width) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        this.logics = new LogicsImpl(width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));
        JPanel panelToGO = new JPanel(new BorderLayout());
        this.getContentPane().add(panel);
        panelToGO.add(bottonToGo);
        this.getContentPane().add(panelToGO, BorderLayout.SOUTH);
                
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
            	var pos = new Pair<>(j,i);
                final JButton jb = new JButton();
                this.cells.put(pos, jb);
                panel.add(jb);
            }
        }
        logics.randomCell(3).forEach((p) -> cells.get(p).setText("*"));

        bottonToGo.addActionListener( (e) -> {
            if(logics.toQuit()) {
                System.exit(0);
            } else{
                logics.nearCells().forEach((p) -> cells.get(p).setText("*"));
            }
        });

        this.setVisible(true);
    }
    
}