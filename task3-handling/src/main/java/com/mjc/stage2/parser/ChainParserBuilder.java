package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser parser) {
        if (!parsers.isEmpty()) {
            parsers.get(parsers.size() - 1).setNextParser(parser);
        }
        parsers.add(parser);
        return this;
    }

    public AbstractTextParser build() {
        if (parsers.isEmpty()) {
            throw new IllegalStateException("No parsers in the chain");
        }
        return parsers.get(0);
    }
}
