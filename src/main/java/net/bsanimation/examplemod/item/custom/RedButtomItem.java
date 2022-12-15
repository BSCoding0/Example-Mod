package net.bsanimation.examplemod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class RedButtomItem extends Item {
    public RedButtomItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && hand == Hand.MAIN_HAND) {
            //output random number
            outputRandomNumber(user);
            //add a cooldown
            user.getItemCooldownManager().set(this, 20);
        }

        return super.use(world, user, hand);
    }

    private void outputRandomNumber(PlayerEntity player) {
        int num = getRandomNumber();
        String message = "Error";
        if(num <= 15 || num >= 85){
            message = "SuS";
        } else if (num == 69) {
            message = "NICE";
        } else {
            message = "not SuS";
        }
        player.sendMessage(Text.literal(String.format("Your are %s (%d)", message, num)));
    }

    private int getRandomNumber() {
        return Random.createLocal().nextInt(100);
    }
}
