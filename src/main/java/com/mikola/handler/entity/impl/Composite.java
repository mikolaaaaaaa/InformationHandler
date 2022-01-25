package com.mikola.handler.entity.impl;

import com.mikola.handler.entity.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private final List<Component> children = new ArrayList<>();

    public Composite() {

    }

    public Composite(List<Component> components) {
        children.addAll(components);
    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    public List<Component> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Composite composite = (Composite) object;
        return children.equals(composite.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Composite{")
                .append("children=").append(children)
                .append('}');
        return stringBuilder.toString();
    }
}
