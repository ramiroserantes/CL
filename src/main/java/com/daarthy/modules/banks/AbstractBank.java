package com.daarthy.modules.banks;

import com.daarthy.exceptions.NotEnoughCoinsException;
import com.daarthy.modules.facturation.Charge;
import com.daarthy.modules.facturation.Payment;
import com.daarthy.modules.util.MsgUtil;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractBank implements Bank {

    private Float coins;
    private int premiumCoins;

    private final Lock coinsLock = new ReentrantLock();
    private final Lock premiumLock = new ReentrantLock();

    protected AbstractBank(Float coins, int premiumCoins) {
        this.coins = coins;
        this.premiumCoins = premiumCoins;
    }

    @Override
    public void addCoins(Float coins) {
        coinsLock.lock();
        try {
            this.coins += coins;
        } finally {
            coinsLock.unlock();
        }
    }
    @Override
    public void addPremiumCoins(int premiumCoins) {
        premiumLock.lock();
        try {
            this.premiumCoins += premiumCoins;
        } finally {
            premiumLock.unlock();
        }
    }
    @Override
    public void removeCoins(Float coins) throws NotEnoughCoinsException {
        coinsLock.lock();
        try {
            if (coins > this.coins) {
                throw new NotEnoughCoinsException();
            }
            this.coins -= coins;
        } finally {
            coinsLock.unlock();
        }
    }
    @Override
    public void removePremiumCoins(int premiumCoins) throws NotEnoughCoinsException {
        premiumLock.lock();
        try {
            if (premiumCoins > this.premiumCoins) {
                throw new NotEnoughCoinsException();
            }
            this.premiumCoins -= premiumCoins;
        } finally {
            premiumLock.unlock();
        }
    }

    @Override
    public void acceptPayment(Payment payment) {
        addCoins(payment.getItemQuantity("coins"));
        addPremiumCoins(payment.getItemQuantity("premiumCoins").intValue());
    }

    @Override
    public String acceptCharge(Charge charge) {

        StringBuilder result = new StringBuilder();

        try {
            removeCoins(charge.getItemQuantity("coins"));
        } catch (NotEnoughCoinsException e) {
            result.append("Coins: ").append(getCoins() - charge.getItemQuantity("coins"));
        }

        try {
            removeCoins(charge.getItemQuantity("coins"));
        } catch (NotEnoughCoinsException e) {
            result.append("PremiumCoins: ").append(getCoins() - charge.getItemQuantity("premiumCoins"));
        }

        return result.toString();
    }


    public Float getCoins() {
        return MsgUtil.roundDecimal(this.coins);
    }

    public int getPremiumCoins() {
        return premiumCoins;
    }
}
