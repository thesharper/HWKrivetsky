package com.example.homeworkkrivetsky;

import java.util.Arrays;

public class ListRepo {
    private Item[] items = new Item[0];

    public void addUnit(Unit unit) {
        addItem(unit);
    }

    public void addSection(Section section) {
        addItem(section);
    }

    public Item[] getItems() {
        return items;
    }

    private void addItem(Item item) {
        items = Arrays.copyOf(items, items.length + 1);
        items[items.length - 1] = item;
    }
}
