package com.nhnacademy;

public enum Currency implements Exchangable {
    WON{
        @Override
        public long toWon(double thisAmount) {
            return (long) thisAmount;
        }

        @Override
        public double fromWon(long wonAmount) {
            return (double) wonAmount / 1000.0;
        }
    },

    DOLLAR {

        @Override
        public long toWon(double thisAmount) {
            return (long) thisAmount * 1000L;
        }

        @Override
        public double fromWon(long wonAmount) {
            return wonAmount / 1000.0;
        }
    };

}
