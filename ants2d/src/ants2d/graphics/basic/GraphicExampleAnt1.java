package ants2d.graphics.basic;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ants2d.ants.OrdinaryAnt;
import ants2d.ants.view.OrdinaryAntViewSimple;
import ants2d.geometry.Point;
import ants2d.mapabsrtactions.impl.SimpleUserMap;
import ants2d.mapabstractions.Clock;
import ants2d.mapabstractions.UserMapPart;

@SuppressWarnings("serial")
public class GraphicExampleAnt1  extends JFrame {


	    public GraphicExampleAnt1() {
	        initUI();
	    }

	    private void initUI() {
	        
	        add(new SurfaceN());
	        
	        setTitle("Java 2D Ants");
	        setSize(750, 650);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }

	    public static void main(String[] args) {

	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	GraphicExampleAnt1 ex = new GraphicExampleAnt1();
	                ex.setVisible(true);
	            }
	        });
	    }
	}
