package engine;

public class Character  //Tom
{	
	private final int DEFAULT_JUMP_HEIGHT=200; //200 pixels
	private final int DEFAULT_MOVE_SPEED=500;  //500 pixels per second
	
	private boolean isDefending=false;
	private boolean isAirborne=false;
	private String screenName="";               //displayed in UI
	private int healthPoints=1000;     //default health set to 1000
	private double moveSpeed;         //1 for default (100%)
	private double jumpHeight;        //alters peak height
	private double recoverMultiplier;           //alters the time between being hit and being able to retaliate
	//TODO default recovery time independent for each move (Attack.java)
	private double damageMultiplier;			//alters damage taken
	private double defendMultiplier;            //this does NOT stack with @damageMultiplier
	//public int numOfLives;                    //maybe this should be in a GameMode Class
	
	private Attack highPunch;
	private Attack lowPunch;
	private Attack highKick;
	private Attack lowKick;
	private Attack airAttack;

	public Character(String screenName)
	{
		this.screenName=screenName;
	}
	public Character(String screenName, double moveSpeedMultiplier, double jumpHeightMultiplier,
			double recoverMultiplier, double damageMultiplier, double defendMultiplier)
	{
		this.screenName=screenName;
		setStats(moveSpeedMultiplier, jumpHeightMultiplier, recoverMultiplier, damageMultiplier, defendMultiplier);
	}
	
	public void setStats(double moveSpeedMultiplier, double jumpHeightMultiplier, double recoverMultiplier,
			double damageMultiplier, double defendMultiplier)
	{
		moveSpeed=DEFAULT_MOVE_SPEED*moveSpeedMultiplier;
		jumpHeight=DEFAULT_JUMP_HEIGHT*jumpHeightMultiplier;
		this.recoverMultiplier=recoverMultiplier;
		this.damageMultiplier=damageMultiplier;
		this.defendMultiplier=defendMultiplier;
	}
	
	public void setAttacks(Attack highPunch, Attack lowPunch, Attack highKick, Attack lowKick, Attack airAttack)
	{
		this.highPunch=highPunch;
		this.lowPunch=lowPunch;
		this.highKick=highKick;
		this.lowKick=lowKick;
		this.airAttack=airAttack;
	}

	public int getHealthPoints()
	{
		return healthPoints;
	}
	
	public void setScreenName(String theName)
	{
		screenName = theName;
	}//end method setScreenName
	
	public String getScreenName()
	{
		return screenName;
	}//end method getScreenName
	//TODO implement cycling of sprites and update sprite every 0.25 seconds
	/**public BufferedImage getCurrentSprite()  WHAT FORMAT DO WE WANT TO USE FOR SPRITES?
	{
		return currentSprite;
	}*/
	
	//Joystick directional controls
	public void up()
	{
		//TODO change air time based on jump height
		
	}
	public void down()
	{
		if (!isAirborne)
		{
			isDefending=true;
		}
		else
		{
			airAttack.perform();
		}
	}
	public double left()
	{
		//HOW OFTEN DO WE WANT TO UPDATE THE GRAPHICS? (For this code I used a 0.05-second delay)
		double moveDistance=moveSpeed*0.05;
		return moveDistance;
	}
	public double right()
	{
		double moveDistance=moveSpeed*0.05;
		return moveDistance;
	}
	public void neutral()
	{
		isDefending=false;
		//TODO end walking cycle
	}
	
	//Four-Button Controls
	public void highPunch()
	{
		highPunch.perform();
	}
	public void lowPunch()
	{
		lowPunch.perform();
	}
	public void highKick()
	{
		highKick.perform();
	}
	public void lowKick()
	{
		lowKick.perform();
	}
	
	public void takeDamage(Attack attackHit)
	{
		int damageTaken;
		if (!isDefending)
		{
			damageTaken=(int) (attackHit.getDamage()*damageMultiplier);
		}
		else
		{
			damageTaken=(int) (attackHit.getDamage()*defendMultiplier);
		}
		healthPoints=healthPoints-damageTaken;
	}
}
