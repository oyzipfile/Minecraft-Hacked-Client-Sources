package me.Corbis.Execution.module.implementations.targets;

import me.Corbis.Execution.module.Category;
import me.Corbis.Execution.module.Module;
import org.lwjgl.input.Keyboard;

public class Invisibles extends Module {
    public Invisibles(){
        super("Invisibles", Keyboard.KEY_NONE, Category.TARGETS);
    }
}
