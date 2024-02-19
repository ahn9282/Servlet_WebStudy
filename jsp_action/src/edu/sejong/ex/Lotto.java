package edu.sejong.ex;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
String numstr;
public Lotto() {
	
}
public String getNumstr() {
	return numstr;
}
public void setNumstr(String a) {
	int n;
	this.numstr = "";
	Set<Integer> set = new HashSet<>();
	for(int i =0 ; set.size() <6; i++) {
		n = (int)(Math.random()*45) + 1;
		set.add(n);
		
	}
	this.numstr = set.toString();
}

}
