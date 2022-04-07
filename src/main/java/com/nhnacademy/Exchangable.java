package com.nhnacademy;

import java.math.BigDecimal;

public interface Exchangable {

    BigDecimal toWon(BigDecimal thisAmount);

    BigDecimal fromWon(BigDecimal wonAmount);
}
