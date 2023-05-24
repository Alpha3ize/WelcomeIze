package jp.co.alpha.bean;

import jp.co.sss.bean2.Type;
import java.util.Date;

public class Meeting {
	private int m_Id;
	private Date m_Date;
	private Date m_Date_End;
	private String m_Name;
	private String m_Place;
	private int m_Delete_Flag;
	
	public String getM_Id() {
		return m_Id;
	}

	public void setM_Id(String m_Id) {
		this.m_Id = m_Id;
	}

	public Date getM_Date_End() {
		return m_Date_End;
	}

	public void setM_Date_End(Date m_Date_End) {
		this.m_Date_End = m_Date_End;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
