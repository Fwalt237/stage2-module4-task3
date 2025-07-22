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
        StringBuilder sb = new StringBuilder();
        for (AbstractTextComponent component : componentList) {
            String delimiter = component.getComponentType().getDelimiter();
            sb.append(component).append(delimiter);
        }
        return sb.toString();
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
