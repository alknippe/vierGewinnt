package viergewinnt;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class VierGUIwinnt extends JFrame implements MouseListener {

	// GUI Window size
	private int Ysize = 750;
	private int Xsize = 720;
	private Graphics ge;
	//TODO 
	//Feld nutzen
	private int[] Feld = new int[7];

	public VierGUIwinnt() {
		this.setTitle("Vier Gewinnt");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(Xsize, Ysize));

		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(200, 20));

		JMenu menu1 = new JMenu("Datei");
		JMenuItem menuItem1 = new JMenuItem("Platzhalter");
		JMenuItem menuItem2 = new JMenuItem("Optionen");
		JMenuItem menuItem3 = new JMenuItem("Beenden");

		DrawPanel dpnl = new DrawPanel();
		add(dpnl);

		menuBar.add(menu1);
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		menuBar.add(menu1);
		addMouseListener(this);
		this.setJMenuBar(menuBar);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

	// action for mosueclickZ
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		// x = (x / 100) + 1; TESTZWECKE
		//System.out.printf("x = %d, y = %d%n", x, y);
		if (y < 140) {
		} else {
			if (x > 10 && x < 110) {
				System.out.println("Spalte 1 gewählt");
				//draw feld[0]
			} else if (x > 110 && x < 210) {
				System.out.println("Spalte 2 gewählt");
				//draw feld[1] usw.
			} else if (x > 210 && x < 310) {
				System.out.println("Spalte 3 gewählt");
			} else if (x > 310 && x < 410) {
				System.out.println("Spalte 4 gewählt");
			} else if (x > 410 && x < 510) {
				System.out.println("Spalte 5 gewählt");
			} else if (x > 510 && x < 610) {
				System.out.println("Spalte 6 gewählt");
			} else if (x > 610 && x < 710) {
				System.out.println("Spalte 7 gewählt");
			}
		}
	}
	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public static void starter() {
		JFrame Spiel = new VierGUIwinnt();
	}
}

class DrawPanel extends JPanel {

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawLine(10, 0, 710, 0);
		g2d.drawLine(10, 100, 710, 100);
		g2d.drawLine(10, 200, 710, 200);
		g2d.drawLine(10, 300, 710, 300);
		g2d.drawLine(10, 400, 710, 400);
		g2d.drawLine(10, 500, 710, 500);
		g2d.drawLine(10, 600, 710, 600);
		g2d.drawLine(10, 700, 710, 700);

		g2d.drawLine(10, 700, 10, 100);
		g2d.drawLine(110, 700, 110, 100);
		g2d.drawLine(210, 700, 210, 100);
		g2d.drawLine(310, 700, 310, 100);
		g2d.drawLine(410, 700, 410, 100);
		g2d.drawLine(510, 700, 510, 100);
		g2d.drawLine(610, 700, 610, 100);
		g2d.drawLine(710, 700, 710, 100);
		
		//TODO 
		g.setColor(Color.pink);
		g.fillOval(100, 100, 32, 32);
	    g.setColor(Color.pink);
		
		//TODO
		// http://zetcode.com/tutorials/javaswingtutorial/painting/
		//filled circle
		//http://stackoverflow.com/questions/2509561/how-to-draw-a-filled-circle-in-java

	}
}