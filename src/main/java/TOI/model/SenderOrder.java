package TOI.model;

import java.util.Date;

public class SenderOrder {
	int id;

	// taobao info
	String tbOrderId;
	String note;
	double price;

	Date ctime;
	Date mtime;

	public Date getMtime() {
		return mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

	String senderName;
	String senderAdress;
	String senderTele;

	String revName;
	String revAdress;
	String revTele;

	int status;

	public String getExpressNum() {
		return expressNum;
	}

	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}

	public int getTbOrderFlag() {
		return tbOrderFlag;
	}

	public void setTbOrderFlag(int tbOrderFlag) {
		this.tbOrderFlag = tbOrderFlag;
	}

	public String getRevCity() {
		return revCity;
	}

	public void setRevCity(String revCity) {
		this.revCity = revCity;
	}

	public String getRevArea() {
		return revArea;
	}

	public void setRevArea(String revArea) {
		this.revArea = revArea;
	}

	String expressNum;
	String expressId;
	int tbOrderFlag;
	String revCity;
	String revArea;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTbOrderId() {
		return tbOrderId;
	}

	public void setTbOrderId(String tbOrderId) {
		this.tbOrderId = tbOrderId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderAdress() {
		return senderAdress;
	}

	public void setSenderAdress(String senderAdress) {
		this.senderAdress = senderAdress;
	}

	public String getSenderTele() {
		return senderTele;
	}

	public void setSenderTele(String senderTele) {
		this.senderTele = senderTele;
	}

	public String getRevName() {
		return revName;
	}

	public void setRevName(String revName) {
		this.revName = revName;
	}

	public String getRevAdress() {
		return revAdress;
	}

	public void setRevAdress(String revAdress) {
		this.revAdress = revAdress;
	}

	public String getRevTele() {
		return revTele;
	}

	public void setRevTele(String revTele) {
		this.revTele = revTele;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getExpressId() {
		return expressId;
	}

	public void setExpressId(String expressId) {
		this.expressId = expressId;
	}

}
