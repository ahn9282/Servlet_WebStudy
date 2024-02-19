package edu.sejong.ex;

public class Grade {
private int kor;
private int eng;
private int math;
private int total;
private int avg;
private String level;
public Grade() {
	
}
public int getKor() {
	return kor;
}
public void setKor(int kor) {
	this.kor = kor;
}
public int getEng() {
	return eng;
}
public void setEng(int eng) {
	this.eng = eng;
}
public int getMath() {
	return math;
}
public void setMath(int math) {
	this.math = math;
}
public int getTotal() {
	return total;
}
public void setTotal(int sum) {
	this.total = kor + eng + math;
}
public int getAvg() {
	return avg;
}
public void setAvg(int average) {
	this.avg = total/3;
}
public String getLevel() {
	return level;
}
public void setLevel(String level) {
	this.level = level;
}

}
