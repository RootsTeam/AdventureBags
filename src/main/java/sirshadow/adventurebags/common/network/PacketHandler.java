package sirshadow.adventurebags.common.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import sirshadow.adventurebags.lib.ModLibrary;

/**
 * Created by sirshadow on 6/26/17.
 */
public class PacketHandler {

    public static SimpleNetworkWrapper INSTANCE  = NetworkRegistry.INSTANCE.newSimpleChannel(ModLibrary.ModInfo.MOD_ID);


    public static void register(){
        INSTANCE.registerMessage(PacketUpdatePBS.class,PacketUpdatePBS.class,0, Side.SERVER);
    }
}
