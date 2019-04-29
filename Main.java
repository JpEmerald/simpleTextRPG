import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import sun.audio.*;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class Main {
static File file;
static Clip clip;
	public static void main (String[] args)
	{

		Character player = new Character("Warrior", "Jonny"); 
		Unit Dovar = new Unit("Goblin");
		Dovar.setStats(10,10,2);
		JSwingInitialize mainz = new JSwingInitialize();
		mainz.createAndShowGUI();
		mainz.setTitle("Combat Against: " + Dovar.getName());
		mainz.editText(player.displayCharactersheet());

//		System.out.println(player.displayCharactersheet());
//		System.out.println(player.equipWeapon("Dagger"));
//		System.out.println(player.displayCharactersheet());
//		System.out.println(Dovar.attackCharacter(player));
//		System.out.println(player.displayStatus());
//		System.out.println(player.attackCharacter(Dovar));
//		System.out.println(player.attackCharacter(Dovar));
//		System.out.println(player.attackCharacter(Dovar));
		
	}
	public static void play(String name)
	{

	 try {
		   file = new File(name);
		   clip = AudioSystem.getClip();
		   clip.open(AudioSystem.getAudioInputStream(file));
		   clip.start();
		   Thread.sleep(clip.getMicrosecondLength());
		  } catch (Exception e) {
		   System.err.println(e.getMessage());
		  }
		 }
	public static void stop()
	{
		clip.stop();
	}

}
