package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.*;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    public LexemeParser() {
    }

    public LexemeParser(AbstractTextParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        String[] lexemes = string.split(LEXEME_REGEX);

        for (String lexeme : lexemes) {
            if (lexeme.matches(WORD_REGEX)) {
                TextComponent wordComponent = new TextComponent(TextComponentType.WORD);
                abstractTextComponent.add(wordComponent);

                if (nextParser != null) {
                    nextParser.parse(wordComponent, lexeme);
                }
            } else {
                // Handle symbols/punctuation
                for (char c : lexeme.toCharArray()) {
                    abstractTextComponent.add(new SymbolLeaf(c));
                }
            }
        }
    }
}

