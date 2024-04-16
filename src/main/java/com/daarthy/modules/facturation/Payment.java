package com.daarthy.modules.facturation;

import java.util.HashMap;
import java.util.Map;

public class Payment {

    private Map<String, Float> items;

    public Payment() {
        this.items = new HashMap<>();
    }

    public void addItem(String item, Float quantity) {
        items.put(item, items.getOrDefault(item, 0F) + quantity);
    }

    public Float getItemQuantity(String item) {
        return items.getOrDefault(item, 0F);
    }


}
