package com.paynet.wallet.util;

public enum TransactionType {
	
	ADD_MONEY("add_money"), 
	DEBITED("debited"), 
	CREDITED("credited");
	
	private String value;

 	TransactionType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
