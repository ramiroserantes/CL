package com.daarthy.modules.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MsgUtil {

    public static Float roundDecimal(Float toRound) {

        BigDecimal bd = new BigDecimal(toRound.toString());
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.floatValue();
    }
}
