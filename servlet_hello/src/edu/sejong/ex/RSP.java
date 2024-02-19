package edu.sejong.ex;

public class RSP {
	private int rspv;
	private int cv;

	public RSP(int r) {
		this.rspv = r;
		this.cv = (int) (Math.random() * 3) + 1;
		;
	}

	public String getrspv() {
		if (rspv == 1)
			return "가위";
		else if (rspv == 2)
			return "보";
		else
			return "바위";
	}

	public String getcv() {
		if (cv == 1)
			return "가위";
		else if (cv == 2)
			return "보";
		else
			return "바위";
	}

	public String getwinner() {
		int result = rspv - cv;
		if (result == 0)
			return "비겼습니다~";
		else if (result == -1 || result == 2)
			return "이겼습니다~";
		else if (result == -2 || result == 1)
			return "졌습니다~";
		else
			return "잉~";
	}
}
