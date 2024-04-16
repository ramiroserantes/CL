package com.daarthy.modules.banks;

import com.daarthy.exceptions.NotEnoughCoinsException;
import com.daarthy.modules.facturation.Charge;
import com.daarthy.modules.facturation.Payment;

public interface Bank {

    Float getCoins();

    int getPremiumCoins();

    void addCoins(Float coins);

    void addPremiumCoins(int premiumCoins);

    void removeCoins(Float coins) throws NotEnoughCoinsException;

    void removePremiumCoins(int premiumCoins) throws NotEnoughCoinsException;

    void acceptPayment(Payment payment);

    String acceptCharge(Charge charge);

}
