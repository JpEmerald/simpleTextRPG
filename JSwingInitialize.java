import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
public class JSwingInitialize implements MouseListener{
JFrame frame;
JFrame mainmenu;
JPanel regularActionPanel;
JPanel combatPanel;
JTextArea text;
JButton fight;
JButton run;
JButton spells;
JButton block;
JPanel introscreen;
JLabel picLabel;
Thread t;

public JSwingInitialize() {
	frame = new JFrame("MisAdventurous");
	mainmenu = new JFrame("MisAdventurous");
	regularActionPanel = new JPanel();
	text = new JTextArea("default");
	combatPanel = new JPanel();
	fight = new JButton("Fight");
	run = new JButton("Run");
	spells = new JButton("Spells");
	block = new JButton("Block");
	introscreen = new JPanel();

}

public void focusListenerIntroPerformed()
{
	mainmenu.setVisible(false);
	frame.setVisible(true);
}

public void createAndShowGUI() 
{
	t = new Thread(new Runnable() {
	    public void run() {
	    	Main.play("mainMenu.wav");
	    }
	});
	t.start();
	
	getMainmenu().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	SpringLayout mainmenulayout = new SpringLayout();
	this.regularActionPanel.setLayout(mainmenulayout);
//	mainmenu.add(regularActionPanel);
	
	BufferedImage myPicture;
	try {
		myPicture = ImageIO.read(new File("introPic.jpg"));
		picLabel = new JLabel(new ImageIcon(myPicture));
		introscreen.add(picLabel);
	} catch (IOException e) {
		e.printStackTrace();
	}
	introscreen.setSize(450, 500);
	SpringLayout introLayout = new SpringLayout();
	introscreen.setLayout(introLayout);
	mainmenu.addMouseListener(this);
	
	introLayout.putConstraint(SpringLayout.WEST, picLabel, -1, SpringLayout.WEST, introscreen);
	introLayout.putConstraint(SpringLayout.EAST, picLabel, 1, SpringLayout.EAST, introscreen);
	introLayout.putConstraint(SpringLayout.NORTH, picLabel, -5, SpringLayout.NORTH, introscreen);
	introLayout.putConstraint(SpringLayout.SOUTH, picLabel, 5, SpringLayout.SOUTH, introscreen);
	mainmenu.add(introscreen);

	mainmenu.setSize(450, 500);
	
	
//	getFrame().setDefaultLookAndFeelDecorated(true);
	getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	SpringLayout layout = new SpringLayout();
	Dimension button = new Dimension(200,30);
    getFight().setPreferredSize(button);
    getBlock().setPreferredSize(button);
    getSpells().setPreferredSize(button);
    getRun().setPreferredSize(button);
    
    getFight().setBackground(Color.black);
    getBlock().setBackground(Color.black);
    getRun().setBackground(Color.black);
    getSpells().setBackground(Color.black);
    
    getFight().setForeground(Color.white);
    getBlock().setForeground(Color.WHITE);
    getRun().setForeground(Color.WHITE);
    getSpells().setForeground(Color.WHITE);
    
    getText().setBackground(Color.black);
    getText().setForeground(Color.green.brighter().brighter());
    
    this.combatPanel.setLayout(layout);
    this.combatPanel.add(getText());
    combatPanel.isDisplayable();
    this.combatPanel.add(getFight());
    this.combatPanel.add(getRun());
    this.combatPanel.add(getSpells());
    this.combatPanel.add(getBlock());
    
    getText().setEditable(false);
    combatPanel.setBackground(Color.BLACK);
    
//    this.combatPanel.isDisplayable();
    
    // these sets of contrainst keep the text centered near the top of the panel
    layout.putConstraint(SpringLayout.WEST, getText(), 10, SpringLayout.WEST, getCombatPanel());
    layout.putConstraint(SpringLayout.EAST, getCombatPanel(), 10, SpringLayout.EAST, getText());
    layout.putConstraint(SpringLayout.NORTH, getText(), 10, SpringLayout.NORTH, getCombatPanel());
   

//    layout.putConstraint(SpringLayout.SOUTH, getCombatPanel(), 5, SpringLayout.SOUTH, getText());
//    
    //these sets of constraints will keep the buttons in a grid with regards to the panel west east edges and the text south edge 
    layout.putConstraint(SpringLayout.WEST, getBlock(), 10 , SpringLayout.EAST, getFight()); 
    layout.putConstraint(SpringLayout.WEST, getFight(), 10, SpringLayout.WEST, getCombatPanel());
    layout.putConstraint(SpringLayout.EAST, getBlock(), -10, SpringLayout.EAST, getCombatPanel());
    
    
//
//    layout.putConstraint(SpringLayout.EAST, getCombatPanel(), 5, SpringLayout.EAST, getBlock());

//
//    layout.putConstraint(SpringLayout.EAST, getFight(), 5, SpringLayout.WEST, getBlock());

    
    layout.putConstraint(SpringLayout.SOUTH, getText(), -10, SpringLayout.NORTH, getFight());
    layout.putConstraint(SpringLayout.SOUTH, getText(), -10, SpringLayout.NORTH, getBlock());
//    layout.putConstraint(SpringLayout.SOUTH, getCombatPanel(), 5, SpringLayout.SOUTH, getText());
//    layout.putConstraint(SpringLayout.SOUTH, getCombatPanel(), 5, SpringLayout.SOUTH, getFight());

    
    layout.putConstraint(SpringLayout.SOUTH, getFight(), -10, SpringLayout.NORTH, getSpells());
    layout.putConstraint(SpringLayout.SOUTH, getBlock(), -10, SpringLayout.NORTH, getRun());
    
//  layout.putConstraint(SpringLayout.NORTH, getSpells(), 5, SpringLayout.SOUTH, getFight());
//  layout.putConstraint(SpringLayout.NORTH, getRun(), 5, SpringLayout.SOUTH, getBlock());
    
    layout.putConstraint(SpringLayout.WEST, getSpells(), 10, SpringLayout.WEST, getCombatPanel());
//    layout.putConstraint(SpringLayout.EAST, getSpells(), 5, SpringLayout.WEST, getRun());
    layout.putConstraint(SpringLayout.WEST, getRun(), 10, SpringLayout.EAST, getSpells());
    layout.putConstraint(SpringLayout.EAST, getRun(), -10, SpringLayout.EAST, getCombatPanel());
////    
    layout.putConstraint(SpringLayout.SOUTH, getSpells(), -10, SpringLayout.SOUTH, getCombatPanel());
    layout.putConstraint(SpringLayout.SOUTH, getRun(), -10, SpringLayout.SOUTH, getCombatPanel());
//    
//    layout.putConstraint(SpringLayout.SOUTH, getCombatPanel(), 50, SpringLayout.SOUTH, getSpells());
//    layout.putConstraint(SpringLayout.SOUTH, getCombatPanel(), 50, SpringLayout.SOUTH, getRun());
//    
    frame.setSize(450,500);
    frame.add(getCombatPanel());
//    frame.pack();
    frame.setLocation(0, 0);
//    frame.setVisible(true);
    mainmenu.setVisible(true);
    

    frame.setBackground(Color.BLACK);
	
}

public void editText(String newText)
{
	getText().setText(newText);
}
public void setTitle(String title) 
{
	frame.setTitle(title);
}
public JFrame getFrame() {
	return frame;
}

public void setFrame(JFrame frame) {
	this.frame = frame;
}

public JPanel getRegularActionPanel() {
	return regularActionPanel;
}

public void setRegularActionPanel(JPanel regularActionPanel) {
	this.regularActionPanel = regularActionPanel;
}

public JPanel getCombatPanel() {
	return combatPanel;
}

public void setCombatPanel(JPanel combatPanel) {
	this.combatPanel = combatPanel;
}

public JTextArea getText() {
	return text;
}

public void setText(JTextArea text) {
	this.text = text;
}

public JButton getFight() {
	return fight;
}

public void setFight(JButton fight) {
	this.fight = fight;
}

public JButton getRun() {
	return run;
}

public void setRun(JButton run) {
	this.run = run;
}

public JButton getSpells() {
	return spells;
}

public void setSpells(JButton spells) {
	this.spells = spells;
}

public JButton getBlock() {
	return block;
}

public void setBlock(JButton block) {
	this.block = block;
}

public JFrame getMainmenu() {
	return mainmenu;
}

public void setMainmenu(JFrame mainmenu) {
	this.mainmenu = mainmenu;
}


public void mouseClicked(MouseEvent arg0) {
	mainmenu.setVisible(false);
	frame.setVisible(true);
	Main.stop();
	t.stop();
	t = new Thread(new Runnable() {
	    public void run() {
	    	Main.play("battleMusic.wav");
	    }
	});
	t.start();

	
	
}

@Override
public void mouseEntered(MouseEvent arg0) {

}

@Override
public void mouseExited(MouseEvent arg0) {

	
}

@Override
public void mousePressed(MouseEvent arg0) {

}

@Override
public void mouseReleased(MouseEvent arg0) {
	
}







}
