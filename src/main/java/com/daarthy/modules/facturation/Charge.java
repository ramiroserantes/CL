package com.daarthy.modules.facturation;

import java.util.HashMap;
import java.util.Map;

public class Charge {

    private final Map<String, Float> items;
    private String msg;

    public Charge() {
        this.items = new HashMap<>();
    }

    public void addItem(String item, Float quantity) {
        items.put(item, items.getOrDefault(item, 0F) + quantity);
    }

    public Float getItemQuantity(String item) {
        return items.getOrDefault(item, 0F);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
