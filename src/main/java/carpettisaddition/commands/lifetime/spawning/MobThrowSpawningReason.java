package carpettisaddition.commands.lifetime.spawning;

import net.minecraft.entity.EntityType;
import net.minecraft.text.BaseText;

public class MobThrowSpawningReason extends MobRelatedSpawningReason
{
	public MobThrowSpawningReason(EntityType<?> entityType)
	{
		super(entityType);
	}

	@Override
	public BaseText toText()
	{
		return tr("mob_throw", this.entityType.getName());
	}
}
