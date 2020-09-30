package com.paynet.wallet.util;

import java.util.Comparator;
import java.util.Date;

import com.paynet.wallet.model.Transactions;

public class SortByTransactionTime implements Comparator<Transactions>  {

	 public int compare(Transactions a, Transactions b) { 
	        return  b.getDateOfTransaction().compareTo(a.getDateOfTransaction());
	 } 
	 
}
