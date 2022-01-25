package com.mikola.handler.parser;

import com.mikola.handler.entity.Component;

public interface Parser {
    Component parse(String text);
}
