package SirShadow.AdventureBags.proxys;

import SirShadow.AdventureBags.AdventureBags;
import SirShadow.AdventureBags.client.GuiHandler;
import SirShadow.AdventureBags.registry.RegistyManeger;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by SirShadow on 21. 07. 2016.
 */
public abstract class CommonProxy implements IProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent e)
    {
        RegistyManeger.regiser();
    }

    @Override
    public void init(FMLInitializationEvent e)
    {
        newtworkRegistry();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }

    private static void newtworkRegistry()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(AdventureBags.instance,new GuiHandler());
    }
}