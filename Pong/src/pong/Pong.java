package pong;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Pong implements ActionListener, KeyListener{
	
	public static Pong pong;
	
	public int width = 700, height = 700;
	
	public Renderer renderer;
	
	public Paddle player1;

	public Paddle player2;
	
	public Ball ball;
	
	public boolean bot = false;
	
	public boolean w,s,up,down;
	
	public int gameStatus = 0; 
	
	public Random random;

	public Pong() {
		Timer timer = new Timer(20,this);
		random = new Random();
		JFrame jframe = new JFrame("Pong");
		
		renderer = new Renderer();
		
		jframe.setSize(width,height);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(renderer);
		jframe.addKeyListener(this);
		
		
		timer.start();
		
	}
	
	public void start() {
		gameStatus=2;
		player1 = new Paddle(this,1);
		player2 = new Paddle(this,2);
		ball= new Ball(this);
		
	}
	
	public static void main(String[] args) {
		
		pong = new Pong();
		
	}

	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(gameStatus==0) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial",1,50));
			g.drawString("PONG", width/2 -80, 50);
			
			g.setFont(new Font("Arial",1,20));
			g.drawString("Press Space", width/2 - 70, 150);
			g.drawString("Press Shift to Play with Bot", width/2 -150, 190);
		}
		
		if(gameStatus==2 || gameStatus == 1) {
			g.setColor(Color.WHITE);
			g.setStroke(new BasicStroke(5f));
			g.drawLine(width/2, 0, width/2, height);
			
			g.drawOval(width/2 -50, height /2 -50, 100, 100);
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial",1,50));
			g.drawString(String.valueOf(player1.score), width/2 -80, 50);
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial",1,50));
			g.drawString(String.valueOf(player2.score), width/2 +45, 50);
			
			player1.render(g);
			player2.render(g);
			ball.render(g);
		}
		
		if(gameStatus==1) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial",1,50));
			g.drawString("PAUSED", width/2 -115, 150);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(gameStatus == 2) {
			update();
		}
		
		renderer.repaint();
	}

	private void update() {
		if (w)
		{
			player1.move(true);
		}
		if (s)
		{
			player1.move(false);
		}
		if(!bot) {
			if (up)
			{
				player2.move(true);
			}
			if (down)
			{
				player2.move(false);
			}
		}else {
			int speed = 5;
			if(player2.y + player2.height /2 < ball.y) {
				player2.y+=speed;
			}
			if(player2.y + player2.height /2 > ball.y) {
				player2.y -= speed;
			}
		}

		
		ball.update(player1, player2);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int id = e.getKeyCode();
		
		if (id == KeyEvent.VK_W)
		{
			w = true;
		}
		if (id == KeyEvent.VK_S)
		{
			s = true;
		}
		if (id == KeyEvent.VK_UP)
		{
			up = true;
		}
		if (id == KeyEvent.VK_DOWN)
		{
			down = true;
		}
		if (id == KeyEvent.VK_ESCAPE && gameStatus == 2) {
			gameStatus = 0;
		}
		if(id==KeyEvent.VK_SPACE) {
			if(gameStatus == 0) {
				start();
				bot = false;
			}
			else if(gameStatus == 1) {
				gameStatus = 2;
			}
			else if(gameStatus == 2) {
				gameStatus = 1;
			}
		}
		if(id==KeyEvent.VK_SHIFT && gameStatus ==0) {
			bot = true;
			gameStatus = 2;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int id = e.getKeyCode();
		
		if (id == KeyEvent.VK_W)
		{
			w = false;
		}
		if (id == KeyEvent.VK_S)
		{
			s = false;
		}
		if (id == KeyEvent.VK_UP)
		{
			up = false;
		}
		if (id == KeyEvent.VK_DOWN)
		{
			down = false;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
