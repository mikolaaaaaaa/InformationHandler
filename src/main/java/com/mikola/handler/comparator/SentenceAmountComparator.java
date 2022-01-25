package com.mikola.handler.comparator;

import com.mikola.handler.entity.Component;
import com.mikola.handler.entity.impl.Composite;

import java.util.Comparator;

public class SentenceAmountComparator implements Comparator<Component> {
    @Override
    public int compare(Component firstComponent, Component secondComponent) {
        Composite firstComposite = (Composite) firstComponent;
        Composite secondComposite = (Composite) secondComponent;
        return Integer.compare(
                firstComposite.getChildren().size(),
                secondComposite.getChildren().size()
        );
    }
}
