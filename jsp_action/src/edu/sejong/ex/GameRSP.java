package edu.sejong.ex;

public class GameRSP {
	String rspv;
	String result;
	int cv;
	String csv;

	public GameRSP() {
		cv = (int) (Math.random() * 3) + 1;
		if (cv == 1)
			csv = "가위";
		if (cv == 2)
			csv = "보";
		if (cv == 3)
			csv = "바위";
	}

	public String getRspv() {
		return rspv;
	}

	public void setRspv(String rspv) {
		this.rspv = rspv;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String rspv) {
		if (rspv.equals(csv))
			result = "비김";
		else {
			if (rspv.equals("가위") && csv.equals("바위"))
				result = "짐";
			else if (rspv.equals("가위")&& csv.equals("보"))
				result = "이김";
			else if (rspv.equals("보")&& csv.equals("바위"))
				result = "이김";
			else if (rspv.equals("보")&& csv.equals("가위"))
				result = "짐";
			else if (rspv.equals("바위")&& csv.equals("가위"))
				result = "이김";
			else if (rspv.equals("바위")&& csv.equals("보"))
				result = "짐";
			else
				result = "문제발생";
		}
	}

	public String getCsv() {
		return csv;
	}

	public void setCsv(String rspv) {
		if (cv == 1)
			csv = "가위";
		if (cv == 2)
			csv = "보";
		if (cv == 3)
			csv = "바위";
	}

}
