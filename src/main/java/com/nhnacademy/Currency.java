package com.nhnacademy;

import java.math.BigDecimal;

public enum Currency implements Exchangable {

    WON(1000L) {
        @Override
        public BigDecimal toWon(BigDecimal thisAmount) {
            return thisAmount;
        }

        @Override
        public BigDecimal fromWon(BigDecimal wonAmount) {
            return wonAmount.divide(BigDecimal.valueOf(getRate()));
        }
    },

    DOLLAR(1000L) {
        @Override
        public BigDecimal toWon(BigDecimal thisAmount) {
            return thisAmount.multiply(BigDecimal.valueOf(getRate()));
        }

        @Override
        public BigDecimal fromWon(BigDecimal wonAmount) {
            return wonAmount.divide(BigDecimal.valueOf(getRate()));
        }
    },

    EURO(1300L) {
        @Override
        public BigDecimal toWon(BigDecimal thisAmount) {
            return thisAmount.multiply(BigDecimal.valueOf(getRate()));
        }

        @Override
        public BigDecimal fromWon(BigDecimal wonAmount) {
            return wonAmount.divide(BigDecimal.valueOf(getRate()));
        }
    };

    private final long rate;

    public long getRate() {
        return rate;
    }

    Currency(long rate) {
        this.rate = rate;
    }
}
