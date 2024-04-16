package com.daarthy.modules.banks;

public class KdBuffer {

    private Float foodBuffer = 0.0F;
    private Float leatherBuffer = 0.0F;
    private Float mineralsBuffer = 0.0F;

    public synchronized boolean increaseFoodBuffer(Float amount) {
        this.foodBuffer += amount;
        if (this.foodBuffer >= 100) {
            this.foodBuffer -= 100;
            return true;
        }
        return false;
    }

    public synchronized boolean increaseLeatherBuffer(Float amount) {
        this.leatherBuffer += amount;
        if (this.leatherBuffer >= 100) {
            this.leatherBuffer -= 100;
            return true;
        }
        return false;
    }

    public synchronized boolean increaseMineralsBuffer(Float amount) {
        this.mineralsBuffer += amount;
        if (this.mineralsBuffer >= 100) {
            this.mineralsBuffer -= 100;
            return true;
        }
        return false;
    }
}
