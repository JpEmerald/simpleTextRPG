import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Character extends Unit {
int health;
int currentHealth;
int mana;
int currentMana;

int stamina;
int agility;
int strength;
int intellect;

int energy;
int currentEnergy;

int damage = 2;
int level;
String name;
String charClass;
Map<String,Integer> equipment = new HashMap<String,Integer>();
Equipment weaponsList = new Equipment();
String currentWeapon;
int currentDamageBonus;
int effectiveDamage;
int spellPower;
int bonusSpellPower;
int effectiveSpellPower;
double currentHitRate;
ArrayList<String> equipped = new ArrayList<String>();
boolean combatStatus = true;
double lowrate = 0.8;
double highrate = 1.2;

public Character(String charClass, String name)
{
	this.name=name;
	this.charClass = charClass;
	health = 10;
	currentHealth = 10;
	mana = 100;
	currentMana = 10;
	stamina = 10;
	agility=0;
	strength=0;
	stamina=0;
	intellect=0;
	energy = 10;
	currentEnergy=10;
	level =1;
	effectiveDamage = currentDamageBonus + damage;
	spellPower = 0;
	bonusSpellPower=0;
	effectiveSpellPower = spellPower + bonusSpellPower;
	currentWeapon = "Fists";
	currentHitRate = .85;
	currentCritRate = .02;
}

public String equipWeapon(String Weapon)
{
	int dmg = weaponsList.getWeaponDamage(Weapon);

	currentWeapon = Weapon;
	currentDamageBonus = dmg;
	updateEffective();
	return (this.getCurrentWeapon() + " has been equipped. +" + this.getCurrentDamageBonus() + " damage\n");
}
public void recover()
{
	currentHealth = health;
	currentMana=mana;
}


public void updateEffective()
{
	effectiveSpellPower = spellPower + bonusSpellPower;
	effectiveDamage = currentDamageBonus + damage;
}

public int getHealth()
{
	return health;
}

public int getMana() {
	return mana;
}

public void setMana(int mana) {
	this.mana = mana;
}

public int getStamina() {
	return stamina;
}

public void setStamina(int stamina) {
	this.stamina = stamina;
}

public int getAgility() {
	return agility;
}

public void setAgility(int agility) {
	this.agility = agility;
}

public int getStrength() {
	return strength;
}

public void setStrength(int strength) {
	this.strength = strength;
}

public int getEnergy() {
	return energy;
}

public void setEnergy(int energy) {
	this.energy = energy;
}

public int getIntellect() {
	return intellect;
}

public void setIntellect(int intellect) {
	this.intellect = intellect;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCharClass() {
	return charClass;
}

public void setCharClass(String charClass) {
	this.charClass = charClass;
}

public void setHealth(int health) {
	this.health = health;
}

public void chooseWeapon(String weapon)
{
	currentDamageBonus = weaponsList.getWeaponDamage(weapon);
}

public int getCurrentHealth() {
	return currentHealth;
}

public void setCurrentHealth(int currentHealth) {
	this.currentHealth = currentHealth;
}

public int getCurrentMana() {
	return currentMana;
}

public void setCurrentMana(int currentMana) {
	this.currentMana = currentMana;
}

public int getCurrentEnergy() {
	return currentEnergy;
}

public void setCurrentEnergy(int currentEnergy) {
	this.currentEnergy = currentEnergy;
}

public String getCurrentWeapon() {
	return currentWeapon;
}

public void setCurrentWeapon(String currentWeapon) {
	this.currentWeapon = currentWeapon;
}

public int getCurrentDamageBonus() {
	return currentDamageBonus;
}

public void setCurrentDamageBonus(int currentDamageBonus) {
	this.currentDamageBonus = currentDamageBonus;
}

public void takeDamage(int damageTaken)
{
	currentHealth= currentHealth -  damageTaken;
}

public void loseMana(int manaCost)
{
	currentMana-= manaCost;
}

public void loseEnergy(int energyCost)
{
	currentEnergy -= energyCost;
}

public String displayCharactersheet()
{
	String CS = "";
	
	CS =    "Name: " + name + "\n"
			+ "Class: " + charClass + "\n"
			+ "Current Level: " + level + "\n"
			+ "Health: " + currentHealth + "/"+ health + "\n"
			+ "Mana: " + currentMana + "/" + mana + "\n"
			+ "Stats: " + "\n"
			+ "  Strength: " + strength + "\n"
			+ "  Intellect: " + intellect + "\n"
			+ "  Agility: " + agility + "\n"
			+ "  Stamina: " + stamina + "\n \n"
			+ "Current Equipment:\n"
			+ currentWeapon + ": +" + effectiveDamage  + " to damage \n";
	
	return CS;
}

public String displayStatus()
{
	String dS =  super.displayStatus();
	return dS;
}

public int getLevel() {
	return level;
}

public void setLevel(int level) {
	this.level = level;
}

public int getDamage() {
	return damage;
}

public void setDamage(int damage) {
	this.damage = damage;
}

public int getEffectiveDamage() {
	return effectiveDamage;
}

public void setEffectiveDamage(int effectiveDamage) {
	this.effectiveDamage = effectiveDamage;
}

public int getSpellPower() {
	return spellPower;
}

public void setSpellPower(int spellPower) {
	this.spellPower = spellPower;
}

public int getBonusSpellpower() {
	return bonusSpellPower;
}

public void setBonusSpellpower(int bonusSpellpower) {
	this.bonusSpellPower = bonusSpellpower;
}

public int getEffectiveSpellPower() {
	return effectiveSpellPower;
}

public void setEffectiveSpellPower(int effectiveSpellPower) {
	this.effectiveSpellPower = effectiveSpellPower;
}

public Double getCurrentHitRate()
{
	return currentHitRate;
}

public int getBonusSpellPower() {
	return bonusSpellPower;
}

public void setBonusSpellPower(int bonusSpellPower) {
	this.bonusSpellPower = bonusSpellPower;
}

public void setCurrentHitRate(double currentHitRate) {
	this.currentHitRate = currentHitRate;
}

public void addListener()
{
	
}

public void escapeCombat()
{
	if (isCombatStatus() == true)
	{
		if (Math.random() > .80)
		{
		setCombatStatus(false);
		}
	
	}
}

public boolean isCombatStatus() {
	return combatStatus;
}

public void setCombatStatus(boolean combatStatus) {
	this.combatStatus = combatStatus;
}

public void updateStats()
{
	this.setHealth(10 + (2*this.getStamina()));
	this.setMana(10 + (2*this.getIntellect()));
	this.setHighrate(1.2 + (getStrength() * .15)+ (getAgility() * 0.5));
	this.setLowrate(0.8 + getLowrate() * 0.5);
	this.setEnergy(10 + (getAgility() * 2));
	updateEffective();
	recover();
	
}
public int damage ()
{
	int damage = (int) (this.getEffectiveDamage() * (Math.random()*(highrate-lowrate) + lowrate ));
	
	return damage;
}

public String attackCharacter(Unit enemy)
{
	if (enemy.getCurrentHealth() <= 0 )
	{
	String ret = "Unable to attack a dead Character \n";
	return ret;
	}
	
	else if (Math.random()<this.getCurrentHitRate()) {

		if (Math.random()<this.getCurrentCritRate())
		{	
			String ret ="CRITICAL HIT: " + this.getName() + " dealt " + damage()*2 + " damage to " + enemy.getName() + "\n" ; 
			enemy.setCurrentHealth(enemy.getCurrentHealth() - damage()*2);
			ret += enemy.displayStatus();
			
			return ret;
		}
	
	String ret = this.getName() + " dealt " + damage() + " damage to " + enemy.getName() + "\n" ; 
	enemy.setCurrentHealth(enemy.getCurrentHealth() - damage());
	ret += enemy.displayStatus();
	
	return ret;
}
	String ret = this.getName() + "'s attack missed\n";
	return ret;
}

public double getHighrate() {
	return highrate;
}

public void setHighrate(double highrate) {
	this.highrate = highrate;
}

public double getLowrate() {
	return lowrate;
}

public void setLowrate(double lowrate) {
	this.lowrate = lowrate;
}

public void levelUP()
{
	setLevel(this.getLevel() + 1);
	setAgility(1);
	setStrength(1);
	setStamina(1);
	setIntellect(1);
	updateStats();
}
}
