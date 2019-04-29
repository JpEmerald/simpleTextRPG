import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Equipment {
String dagger = "Dagger";
String sword = "Sword";
String staff = "Staff";
Map<String,Integer> EquipDamage = new HashMap<String,Integer>();

public Equipment()
{
	EquipDamage.put(dagger, 3);
	EquipDamage.put(sword, 4);
	EquipDamage.put(staff, 3);
	
}

public int getWeaponDamage(String Weapon)
{
	int dmg = 0;
	Set<String> search = EquipDamage.keySet();
	Iterator<String> iter = search.iterator();
	
	while (iter.hasNext())
	{
	String temp = iter.next();
		if (temp.contentEquals(Weapon))
		{
		dmg = EquipDamage.get(temp);
		}

	}
	return dmg;
}


}
