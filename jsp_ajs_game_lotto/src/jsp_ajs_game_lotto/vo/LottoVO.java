package jsp_ajs_game_lotto.vo;

import java.util.*;

public class LottoVO {
	private Set<Integer> numbers = new HashSet<>();
	private int bonusnum ;
	private final static int LOTTO_COUNT=7;


	public LottoVO() {
		 Set<Integer> numstore = new HashSet<>();
		while(numbers.size() < LOTTO_COUNT) {
			int num = (int)(Math.random()*45) +1;
			numstore.add(num);
			if(numbers.size()==6 && numstore.size() ==7) {
				bonusnum=num;
			break;
			}
			if(numbers.size() <=6) {
			numbers.add(num);}
		}
		System.out.println(numstore );
	}

	public Set<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}
	public String getColor(int num) {
		String color;
		if(num >=40) {
			return"red";
		}else if(num >=30) {
			return"green";
		}else if(num >=20) {
			return "blue";
		}else if(num >=10) {
			return "yellow";
		}else {
			return"skyblue";
		}
	}
	
	public int getBonusnum() {
		return bonusnum;
	}
	
	public void setBonusnum(int bonusnum) {
		this.bonusnum = bonusnum;
	}
}


