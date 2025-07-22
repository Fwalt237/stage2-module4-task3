package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {
    protected List<AbstractTextComponent> componentList = new ArrayList<>();
    private int size = 0;

    public TextComponent(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        StringBuilder builder = new StringBuilder();
        for (AbstractTextComponent component : componentList) {
            builder.append(component.operation());
            if (component.getComponentType() == TextComponentType.WORD) {
                builder.append(" ");
            }
        }
        return builder.toString().trim();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        componentList.add(textComponent);
        size += textComponent.getSize();
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        if (componentList.remove(textComponent)) {
            size -= textComponent.getSize();
        }
    }

    @Override
    public int getSize() {
        return size;
    }
// Write your code here!
}
