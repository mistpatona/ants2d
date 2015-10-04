package ants2d.graphics.basic;

import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GraphicExample  extends JFrame {

	    public GraphicExample() {

	        initUI();
	    }

	    private void initUI() {

	        add(new Surface());

	        setTitle("Simple Java 2D example");
	        setSize(300, 200);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    public static void main(String[] args) {

	        EventQueue.invokeLater(new Runnable() {

	            @Override
	            public void run() {
	            	GraphicExample ex = new GraphicExample();
	                ex.setVisible(true);
	            }
	        });
	    }
	}
