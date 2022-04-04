package carpettisaddition.commands.info.entity;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

import java.util.Map;

/**
 * Logic ports from fabric-carpet 1.4.54
 */
public class EntityInfoUtil
{
	public static String makeTime(long ticks)
	{
		long secs = ticks/20;
		if (secs < 60)
		{
			return String.format("%d\"", secs);
		}
		if (secs < 60*60)
		{
			return String.format("%d'%d\"", secs/60, secs%60);
		}

		return String.format("%dh%d'%d\"", secs/60/60, (secs % (60*60))/60,(secs % (60*60))%60 );
	}

	public static String display_item(ItemStack item)
	{
		if (item == null)
		{
			return null;
		}
		if (item.isEmpty()) // func_190926_b()
		{
			return null;
		} // func_190916_E()
		String stackname = item.getCount()>1?String.format("%dx%s",item.getCount(), item.getName().getString()):item.getName().getString();
		if (item.isDamaged())
		{
			stackname += String.format(" %d/%d", item.getMaxUseTime()-item.getDamage(), item.getMaxUseTime());
		}
		if (item.hasEnchantments())
		{
			stackname += " ( ";
			Map<Enchantment, Integer> enchants = EnchantmentHelper.get(item);
			for (Enchantment e: enchants.keySet())
			{
				int level = enchants.get(e);
				String enstring = e.getName(level).getString();
				stackname += enstring+" ";
			}
			stackname += ")";
		}
		return stackname;
	}

	public static String entity_short_string(Entity e)
	{
		if (e == null)
		{
			return "None";
		}
		return String.format("%s at [%.1f, %.1f, %.1f]",e.getDisplayName().getString(), e.getX(), e.getY(), e.getZ());
	}

	public static double get_speed(double internal)
	{
		return 43.1*internal;
	}

	public static double get_horse_speed_percent(double internal)
	{
		double min = 0.45*0.25;
		double max = (0.45+0.9)*0.25;
		return 100*(internal-min)/(max-min);
	}

	public static double get_horse_jump(double x)
	{
		return -0.1817584952 * x*x*x + 3.689713992 * x*x + 2.128599134 * x - 0.343930367;
	}

	public static double get_horse_jump_percent(double internal)
	{
		double min = 0.4;
		double max = 1.0;
		return 100*(internal-min)/(max-min);
	}
}