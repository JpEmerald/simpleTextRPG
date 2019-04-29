
public class Unit {
	int health;
	int currentHealth;
	int mana;
	int currentMana;
	int effectiveDamage;
	int stamina;
	String name;
	Double currentHitRate;
	Double currentCritRate;
	
	
	public Unit (String name)
	{
	this.name=name;
	}
	public Unit()
	{
		
	}
	
	public String displayStatus()
	{
		String dS =  "Health: " + this.getCurrentHealth() + "/"+ this.getHealth() + "\n"
				+ "Mana: " + this.getCurrentMana() + "/" + this.getMana() + "\n";
		if (this.getCurrentHealth() <= 0)
		{
			dS= dS + this.getName() + " has died.";
		}
				return dS;
	}
	public void setStats (int maxhealth, int maxmana, int damage)
	{
	health = maxhealth;
	mana = maxmana;
	this.effectiveDamage = damage;
	currentHealth = this.health;
	currentMana = this.mana;
	currentHitRate = .85;
	currentCritRate = .02;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}
	public void deadCharacter()
	{
	System.out.println( this.getName() +" has died\n");
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getCurrentMana() {
		return currentMana;
	}

	public void setCurrentMana(int currentMana) {
		this.currentMana = currentMana;
	}

	public int getEffectiveDamage() {
		return effectiveDamage;
	}

	public void setDamage(int damage) {
		this.effectiveDamage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

public String attackCharacter(Unit enemy)
{
	if (enemy.getCurrentHealth() <= 0 ) {
	String ret = "Unable to attack a dead Character \n";
	return ret;
	}
	
	else if (Math.random()<this.getCurrentHitRate()) {

		if (Math.random()<this.getCurrentCritRate())
		{	
			String ret ="CRITICAL HIT: " + this.getName() + " dealt " + (this.getEffectiveDamage()*2) + " damage to " + enemy.getName() + "\n" ; 
			enemy.setCurrentHealth(enemy.getCurrentHealth() - (this.getEffectiveDamage()*2));
			ret += enemy.displayStatus();
			
			return ret;
		}
	
	String ret = this.getName() + " dealt " + this.getEffectiveDamage() + " damage to " + enemy.getName() + "\n" ; 
	enemy.setCurrentHealth(enemy.getCurrentHealth() - this.getEffectiveDamage());
	ret += enemy.displayStatus();
	
	return ret;
}
	String ret = this.getName() + "'s attack missed\n";
	return ret;
}
public int getStamina() {
	return stamina;
}
public void setStamina(int stamina) {
	this.stamina = stamina;
}
public Double getCurrentHitRate() {
	return currentHitRate;
}
public void setCurrentHitRate(Double currentHitRate) {
	this.currentHitRate = currentHitRate;
}
public void setEffectiveDamage(int effectiveDamage) {
	this.effectiveDamage = effectiveDamage;
}
public Double getCurrentCritRate() {
	return currentCritRate;
}
public void setCurrentCritRate(Double currentCritRate) {
	this.currentCritRate = currentCritRate;
}



}

