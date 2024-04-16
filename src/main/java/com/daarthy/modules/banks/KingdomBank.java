package com.daarthy.modules.banks;

import com.daarthy.exceptions.NotEnoughCoinsException;
import com.daarthy.exceptions.NotEnoughMaterialsException;
import com.daarthy.modules.facturation.Charge;
import com.daarthy.modules.facturation.Payment;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KingdomBank extends AbstractBank {

    private int food;
    private int leather;
    private int minerals;

    private KdBuffer kdBuffer = new KdBuffer();

    private final Lock foodLock = new ReentrantLock();
    private final Lock leatherLock = new ReentrantLock();
    private final Lock mineralsLock = new ReentrantLock();

    public KingdomBank(Float coins, int premiumCoins, int food, int leather, int minerals) {
        super(coins, premiumCoins);
        this.food = food;
        this.leather = leather;
        this.minerals = minerals;
    }

    public void addFood(int amount) {
        foodLock.lock();
        try {
            this.food += amount;
        } finally {
            foodLock.unlock();
        }
    }

    public void removeFood(int amount) throws NotEnoughMaterialsException {
        foodLock.lock();
        try {
            if(amount > this.food) {
                throw new NotEnoughMaterialsException();
            } else {
                this.food -= amount;
            }
        } finally {
            foodLock.unlock();
        }
    }

    public void addLeather(int amount) {
        leatherLock.lock();
        try {
            this.leather += amount;
        } finally {
            leatherLock.unlock();
        }
    }

    public void removeLeather(int amount) throws NotEnoughMaterialsException {
        leatherLock.lock();
        try {
            if(amount > this.leather) {
                throw new NotEnoughMaterialsException();
            } else {
                this.leather -= amount;
            }
        } finally {
            leatherLock.unlock();
        }
    }

    public void addMinerals(int amount) {
        mineralsLock.lock();
        try {
            this.minerals += amount;
        } finally {
            mineralsLock.unlock();
        }
    }

    public void removeMinerals(int amount) throws NotEnoughMaterialsException {
        mineralsLock.lock();
        try {
            if(amount > this.minerals) {
                throw new NotEnoughMaterialsException();
            } else {
                this.minerals -= amount;
            }
        } finally {
            mineralsLock.unlock();
        }
    }

    @Override
    public void acceptPayment(Payment payment) {
        super.acceptPayment(payment);
        addFood(payment.getItemQuantity("food").intValue());
        addMinerals(payment.getItemQuantity("minerals").intValue());
        addLeather(payment.getItemQuantity("leather").intValue());
    }

    @Override
    public String acceptCharge(Charge charge) {

        StringBuilder result = new StringBuilder(super.acceptCharge(charge));

        try {
            removeFood(charge.getItemQuantity("food").intValue());
        } catch (NotEnoughMaterialsException e) {
            result.append("Food: ").append(getFood() - charge.getItemQuantity("food"));
        }

        try {
            removeMinerals(charge.getItemQuantity("minerals").intValue());
        } catch (NotEnoughMaterialsException e) {
            result.append("Minerals: ").append(getMinerals() - charge.getItemQuantity("minerals"));
        }

        try {
            removeLeather(charge.getItemQuantity("leather").intValue());
        } catch (NotEnoughMaterialsException e) {
            result.append("Leather: ").append(getLeather() - charge.getItemQuantity("leather"));
        }

        if(result.toString().isEmpty()) {
            return null;
        } else {
            charge.setMsg(result.toString());
            return result.toString();
        }
    }

    public int getFood() {
        return food;
    }

    public int getLeather() {
        return leather;
    }

    public int getMinerals() {
        return minerals;
    }

    public KdBuffer getKdBuffer() {
        return kdBuffer;
    }
}
