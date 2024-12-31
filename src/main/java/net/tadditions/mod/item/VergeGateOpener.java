package net.tadditions.mod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.TickTask;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.povstalec.sgjourney.common.block_entities.stargate.AbstractStargateEntity;
import net.povstalec.sgjourney.common.blocks.stargate.AbstractStargateBaseBlock;
import net.povstalec.sgjourney.common.blocks.stargate.AbstractStargateBlock;
import net.povstalec.sgjourney.common.data.BlockEntityList;
import net.povstalec.sgjourney.common.data.StargateNetwork;
import net.povstalec.sgjourney.common.stargate.Address;
import net.povstalec.sgjourney.common.stargate.Stargate;
import net.povstalec.sgjourney.common.stargate.StargateConnection;
import net.tadditions.mod.TemporalAdditionsMod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class VergeGateOpener extends Item
{

    public VergeGateOpener(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getLevel().isClientSide())
            return InteractionResult.PASS;

        Random random = new Random();
        MinecraftServer server = context.getLevel().getServer();
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
        if(blockState.getBlock() instanceof AbstractStargateBlock stargateBlock && context.getLevel().dimension().location().equals(new ResourceLocation(TemporalAdditionsMod.MOD_ID, "the_verge_of_reality")))
        {
            AbstractStargateEntity stargateEntity = stargateBlock.getStargate(context.getLevel(), context.getClickedPos(), blockState);
            List<Map.Entry<Address.Immutable, Stargate>> entryList = new ArrayList<>(BlockEntityList.get(server).getStargates().entrySet().stream().toList());
            entryList.removeIf(predicate -> predicate.getKey().equals(stargateEntity.getAddress().immutable()));
            Map.Entry<Address.Immutable, Stargate> entry = entryList.get(random.nextInt(0, BlockEntityList.get(server).getStargates().size()));
            Stargate stargate = entry.getValue();
            if(stargate.isConnected(server))
            {
                StargateNetwork.get(server).removeConnection(stargate.getStargateEntity(server).get().getConnectionID(), Stargate.Feedback.ALREADY_CONNECTED);
                StargateConnection connection = StargateConnection.create(StargateConnection.Type.SYSTEM_WIDE, stargateEntity, stargate.getStargateEntity(server).get(), true);
                StargateNetwork.get(server).addConnection(connection);
            }
            else
            {
                StargateConnection connection = StargateConnection.create(StargateConnection.Type.SYSTEM_WIDE, stargateEntity, stargate.getStargateEntity(server).get(), true);
                StargateNetwork.get(server).addConnection(connection);
            }

            context.getPlayer().setItemInHand(context.getHand(), ItemStack.EMPTY);
        }

        return super.useOn(context);
    }
}
