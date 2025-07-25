package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;

public class WordParser extends AbstractTextParser {
    public WordParser() {
    }

    public WordParser(AbstractTextParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        String[] chars = string.split("(?<=.)");

        for (String ch : chars) {
            if (!ch.isEmpty()) {
                abstractTextComponent.add(new SymbolLeaf(ch.charAt(0)));
            }
        }
    }
}
