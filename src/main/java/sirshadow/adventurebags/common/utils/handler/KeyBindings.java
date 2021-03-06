package sirshadow.adventurebags.common.utils.handler;

import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by TeamRoots on 13.8.2016.
 */
public enum KeyBindings
{

    PBS("key.store.name", Keyboard.KEY_P);

    public final KeyBinding keyBinding;

    KeyBindings(String keyName, int defaultKeyCode)
    {
        keyBinding = new KeyBinding(keyName, defaultKeyCode, "key.category.adventure_bags");
    }

    public KeyBinding getKeyBid()
    {
        return keyBinding;
    }

    public boolean isPressed()
    {
        return keyBinding.isPressed();
    }
}
