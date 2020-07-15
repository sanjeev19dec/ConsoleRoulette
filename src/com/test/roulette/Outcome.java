package com.test.roulette;

public class Outcome {
	
	public String strPlayerName;
	public String strBet;
	public String strResult;
	public int strWinnings;
	public Outcome() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Outcome(String strPlayerName, String strBet, String strResult, int strWinnings) {
		super();
		this.strPlayerName = strPlayerName;
		this.strBet = strBet;
		this.strResult = strResult;
		this.strWinnings = strWinnings;
	}

	public String getStrPlayerName() {
		return strPlayerName;
	}
	public void setStrPlayerName(String strPlayerName) {
		this.strPlayerName = strPlayerName;
	}
	public String getStrBet() {
		return strBet;
	}
	public void setStrBet(String strBet) {
		this.strBet = strBet;
	}
	public String getStrResult() {
		return strResult;
	}
	public void setStrResult(String strResult) {
		this.strResult = strResult;
	}
	public int getStrWinnings() {
		return strWinnings;
	}
	public void setStrWinnings(int strWinnings) {
		this.strWinnings = strWinnings;
	}

	@Override
	public String toString() {
		return "Outcome [strPlayerName=" + strPlayerName + ", strBet=" + strBet + ", strResult=" + strResult
				+ ", strWinnings=" + strWinnings + "]";
	}

	
}
