/* Enemy.java
 * CSC Game Practice
 * Al H.
 */
package engine;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.*;
import java.io.*;
import java.util.Random;

import javax.imageio.*;


public class Enemy extends Applet implements Runnable, KeyListener
{
	//static variables for the game board
	public static final int WIDTH =  900;
	public static final int HEIGHT = 600;
	
	//instance variables for the x and y coordinates and frames
	private int x = 0;
	private int y = 400;
	private int frames = 0;
	private boolean achillesIsDefending = false;
	private int xMove;
	private int distance = 750;
	//create character object
	Character ozzy = new Character("Ozzy");
	//var for health of character
	int health = ozzy.getHealthPoints();
	String h;
	String name = ozzy.getScreenName();
	int delay = (1000/60);
	//create a random object for the enemy movement and attack
	Random attack = new Random();
	Random move = new Random();
	
	boolean right, left;
	
	
	//create objects for graphics
	BufferedImage screen = new BufferedImage(WIDTH, HEIGHT, 4);
	Graphics s = screen.getGraphics();
	
	//objects for enemy sprites
	BufferedImage enemy = new BufferedImage(100,150,4);
	BufferedImage player = new BufferedImage(60,120,4);
	BufferedImage sprite = new BufferedImage(100,150,4);
	BufferedImage sprite1 = new BufferedImage(100,150,4);
	BufferedImage sprite2 = new BufferedImage(100,150,4);
	

	protected int moveIt = getXMove();
	protected int moveAch = getXMove();
	protected int dist = getDistance();
	
	public int getX()
	{
		return x;
	}//end method getX
	
	public int getY()
	{
		return y;
	}//end method getY
	
	public int getXMove()
	{
		return xMove;
	}//end method getXMove
	
	public int getDistance()
	{
		return distance;
	}//end method getXMove
	
	public int getFrames()
	{
		return frames;
	}//end method getFrames
	
	public boolean getIsDefending()
	{
		return achillesIsDefending;
	}
	
	public void init()
	{
		setSize(WIDTH, HEIGHT);
		addKeyListener(this);
		Thread the = new Thread(this);
		the.start();
	}//end method init
	
	public void paint(Graphics g)
	{

		g.drawImage(screen, 0, 0,this);
		s.setColor(Color.white);
		s.fillRect(0, 0, WIDTH, HEIGHT);
		//put enemy and players into sprites for anime
		enemy = sprite;
		player = sprite1;
		
		
	
		//try/catch the sprite loading
//		try 
//		{
////			sprite = ImageIO.read(new File("achilles.png"));
////			sprite = makeTransparent(sprite);
////			
////			sprite1 = ImageIO.read(new File("test2.png"));
////			sprite1 = makeTransparent(sprite1);
////			
////			sprite2 = ImageIO.read(new File("test2Dead.png"));
////			sprite2 = makeTransparent(sprite2);
//		}//end try
//		catch (IOException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.print("Error getting image!");
//		}//end catch


	}//end method paint

	/*
	public void update(Graphics g)
	{
		paint(g);
	}//end method update
	
	
	public void laggyMovement()
	{
		if(left == true)
		{
	
			moveIt -= 3;
			
		}
		if(right == true)
		{
		
			moveIt += 3;
			
		}
	}//end method movement

	*/

	public BufferedImage makeTransparent(BufferedImage image)
	{
		BufferedImage temp = new BufferedImage(image.getWidth(), 
				image.getHeight(),BufferedImage.TYPE_4BYTE_ABGR);
		
		for (int i = 0; i < image.getWidth(); i++)
		{
			for (int j = 0; j < image.getHeight();j++)
			{
				if(image.getRGB(i, j) != image.getRGB(0, 0))
				{
					temp.setRGB(i, j, image.getRGB(i, j));
				}//end if
				
			}//end inner for loop
		}//end outer for loop
		return temp;
	}//end method makeTransparent
	
	@Override
	public void run() 
	{	
		


		while(health > 0)
		{
			
			//random attack value
			int enemyMove = attack.nextInt(6);
			//random for attack or defend
			boolean defend = getIsDefending() ;
			defend = attack.nextBoolean();
			//random movement of achilles
			int achillesMove = move.nextInt(6);
	
			
		if(defend == true)
		{
			switch(enemyMove)
			{
			case 4:
				if(achillesMove == 4 && moveAch - dist + 70  >= (moveIt) )
				{
					moveAch += 2;
					health += 150;
					if(moveAch >= 700)
					{
						moveAch = 500;
					}//end nested if
					if(moveIt < moveAch)
					{
						moveIt = moveAch - dist + 100;
					}//end nested if
					
				}//end if
				else
				{
					moveAch -= 5;
					if(moveAch <= 10)
					{
						moveAch = 0;
					}//end nexted if

					
				}//end else
				
				if(health >= 1000)
				{
				health = 1000;
				}//end if

				h = Integer.toString(health);
				s.setFont(getFont());
				s.setColor(Color.black);
				//slightly less laggy movement
				if(left) moveIt -= 2;
				if(right) moveIt += 2;
				//s.drawString("Achilles Defended!", (moveAch), (getY() - 15));
				s.drawString(h + " HP "  , (moveIt + 755), getY());
				s.drawString(name, (moveIt + 765), getY() + 20);
				s.drawImage(player, (moveIt + 750), (getY() + 50), this);

				s.drawImage(enemy, (moveAch), (getY()), this);
				repaint();
			
				break;
			case 5:
				if(achillesMove == 5 &&  moveAch - dist + 70 >= (moveIt) )
				{
					moveAch += 2;
					health += 150;
					if(moveAch >= 700)
					{
						moveAch = 500;
					}//end nested if
					if(moveIt < moveAch)
					{
						moveIt = moveAch - dist + 100;
					}//end nested if

					
				}//end if
				else
				{
					moveAch -= 2;
					if(moveAch <= 10)
					{
						moveAch = 0;
					}//end nexted if

					
				}//end else
				
				if(health >= 1000)
				{
				health = 1000;
				}//end if

				h = Integer.toString(health);
				if(left) moveIt -= 2;
				if(right) moveIt += 2;
				s.setFont(getFont());
				s.setColor(Color.black);
				//s.drawString("Achilles Defended against an unarmed senior citizen!", (moveAch), (getY() - 15));
				s.drawString(h + " HP "  , (moveIt + 755), getY());
				s.drawString(name, (moveIt + 765), getY() + 20);
				s.drawImage(player, (moveIt + 750), (getY() + 50), this);
			
				s.drawImage(enemy, (moveAch), (getY()), this);
				repaint();
			
				break;
			
			}
		}//end if
		else if(defend == false)
		{
			switch(enemyMove)
			{
			case 0:
				if(achillesMove == 5 && moveAch - dist + 70 >= (moveIt) )
				{
					moveAch += 5;
					health -= 15;
					if(moveAch >= 700)
					{
						moveAch = 500;
					}//end nested if
					if(moveIt < moveAch)
					{
						moveIt = moveAch - dist + 100;
					}//end nested if
					
				}
				else
				{
					moveAch += 4;
					if(moveAch >= 700)
					{
						moveAch = 500;
					}//end nested if
					
				}//end else

				h = Integer.toString(health);
				s.setFont(getFont());
				s.setColor(Color.black);
				if(left) moveIt -= 2;
				if(right) moveIt += 2;
				//s.drawString("Light hit", (moveIt + 155), (getY() - 15));
				if(health <= 0)
				{
					player = sprite2;
					s.drawString("Achilles has slaughtered " + name, (moveIt + 755), (getY() + 10));
					health = 0;
					h = "0";
					s.drawString(h + " HP "  , (moveIt + 755), getY());
					s.drawString("Achilles has slain an unarmed inebriated senior citizen!", getX() + 400, (getY() - 15));
					
				}//end if
				s.drawString(h + " HP "  , (moveIt + 755), getY());
				s.drawString(name, (moveIt + 765), getY() + 20);
				s.drawImage(player, (moveIt + 750), (getY() + 50), this);

				s.drawImage(enemy, (moveAch), (getY()), this);
				repaint();
			
				break;
			case 1:
				if(achillesMove == 5 && moveAch - dist + 70  >= (moveIt) )
				{
					moveAch += 5;
					health -= 35;
					if(moveAch >= 700)
					{
						moveAch = 500;
					}//end nested if
					if(moveIt < moveAch)
					{
						moveIt = moveAch - dist + 120;
					}//end nested if
					
				}				
				else
				{
					moveAch += 5;
					if(moveAch >= 700)
					{
						moveAch = 500;
					}//end nested if
					
				}//end else
				
				h = Integer.toString(health);
				s.setFont(getFont());
				s.setColor(Color.black);
				if(left) moveIt -= 2;
				if(right) moveIt += 2;
			
				//s.drawString("Medium hit", (moveIt + 155), (getY() - 15));
				if(health <= 0)
				{
					player = sprite2;
					s.drawString("Achilles has slaughtered " + name, (moveIt + 755), (getY() + 10));
					health = 0;
					h = "0";
					s.drawString(h + " HP "  , (moveIt + 755), getY());
					s.drawString("Achilles has slain an unarmed inebriated senior citizen!", getX() + 400, (getY() - 15));
				}//end if
				s.drawString(h + " HP "  , (moveIt + 755), getY());
				s.drawString(name, (moveIt + 765), getY() + 20);
				s.drawImage(player, (moveIt + 750), (getY() + 50), this);

				s.drawImage(enemy, (moveAch), (getY()), this);
				repaint();
			
				break;
			case 2:
				if(achillesMove >= 4 && moveAch - dist + 70  >= (moveIt) )
				{
					moveAch += 5;
					health -= 50;
					if(moveAch >= 700)
					{
						moveAch = 500;
					}//end nested if
					if(moveIt < moveAch)
					{
						moveIt = moveAch - dist + 120;
					}//end nested if
					
				}//end if
				else
				{
					moveAch += 6;
					if(moveAch >= 700)
					{
						moveAch = 500;
					}//end nested if
					
				}//end else
	
				h = Integer.toString(health);
				s.setFont(getFont());
				s.setColor(Color.black);
				if(left) moveIt -= 2;
				if(right) moveIt += 2;
			//	s.drawString("Heavy hit", (moveIt + 155), (getY() - 15));
				if(health <= 0)
				{
					player = sprite2;
					s.drawString("Achilles has slaughtered " + name, (moveIt + 755), (getY() + 10));
					health = 0;
					h = "0";
					s.drawString(h + " HP "  , (moveIt + 755), getY());
					s.drawString("Achilles has slain an unarmed inebriated senior citizen!", getX() + 400, (getY() - 15));
				}//end if
				s.drawString(h + " HP "  , (moveIt + 755), getY());
				s.drawString(name, (moveIt + 765), getY() + 20);
				s.drawImage(player, (moveIt + 750), (getY() + 50), this);
	
				s.drawImage(enemy, (moveAch), (getY()), this);
				repaint();
				
				break;
			case 3:
				if(achillesMove >= 4 && moveAch - dist + 70 >= (moveIt) )
				{
					moveAch += 5;
					health -= 250;
					if(moveAch >= 700)
					{
						moveAch = 500;
					}//end nested if
					if(moveIt < moveAch)
					{
						moveIt = moveAch - dist + 120;
					}//end nested if
					
				}//end if
				else
				{
					moveAch += 7;
					if(moveAch >= 700)
					{
						moveAch = 500;
					}//end nested if
					
				}//end else

				h = Integer.toString(health);
				s.setFont(getFont());
				s.setColor(Color.black);
			
				if(left) moveIt -= 2;
				if(right) moveIt += 2;
				if(health <= 0)
				{
					s.drawString("Really hard hit!", (moveIt + 755), (getY() - 15));
					player = sprite2;
					s.drawString("Achilles just assassinated " + name + "!", (moveIt + 755), (getY() + 10));
					health = 0;
					h = "0";
					s.drawString("Achilles has slain an unarmed inebriated senior citizen!", getX() + 400, (getY() - 35));
					
				}//end if
				s.drawString(h + " HP "  , (moveIt + 755), getY());
				s.drawString(name, (moveIt + 765), getY() + 20);
				s.drawImage(player, (moveIt + 750), (getY() + 50), this);
				
				s.drawImage(enemy, (moveAch), (getY()), this);
				repaint();
				
				break;
			}//end switch
		}//end else
		if(left) moveIt -= 2;
		if(right) moveIt += 2;
		try
		{
			
			Thread.sleep(delay);
		}//end try
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
		
	}//end while
		
	}//end method run

	@Override
	public void keyPressed(KeyEvent e) 
	{
		switch (e.getKeyCode())
		{
		case 37:
			left = true;
			
			break;
		case 39:
			right = true;
			break;
		}//end switch
		
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		switch (e.getKeyCode())
		{
		case 37:
			left = false;
			break;
		case 39:
			right = false;
			break;
		}//end switch
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
}//end class Enemy
