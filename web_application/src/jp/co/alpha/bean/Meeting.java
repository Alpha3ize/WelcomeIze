package jp.co.alpha.bean;

import java.util.Date;

public class Meeting {
	private int m_Id;
	private Date m_Date;
	private Date m_Date_End;
	private String[] m_Name;
	private String m_Place;
	private int m_Delete_Flag;

	public int getM_Id() {
		return m_Id;
	}

	public void setM_Id(int m_Id) {
		this.m_Id = m_Id;
	}

	public Date getM_Date() {
		return m_Date;
	}

	public void setM_Date(Date m_Date) {
		this.m_Date = m_Date;
	}

	public Date getM_Date_End() {
		return m_Date_End;
	}

	public void setM_Date_End(Date m_Date_End) {
		this.m_Date_End = m_Date_End;
	}

	public String[] getM_Name() {
		return m_Name;
	}

	public void setM_Name(String[] m_Name) {
		this.m_Name = m_Name;
	}

	public String getM_Place() {
		return m_Place;
	}

	public void setM_Place(String m_Place) {
		this.m_Place = m_Place;
	}

	public int getM_Delete_Flag() {
		return m_Delete_Flag;
	}

	public void setM_Delete_Flag(int m_Delete_Flag) {
		this.m_Delete_Flag = m_Delete_Flag;
	}
	//koment
}