package jp.co.alpha.bean;

import java.util.Date;

public class CleanTool {
	private String name;
	private Date updateDate;
	private String content;
	
	public String getToolName() {
		return name;
	}
	public void setToolName() {
		this.name = name;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate() {
		this.updateDate = updateDate;
	}
	public String getNote() {
		return content;
	}
	public void setNote() {
		this.content = content;
	}
}
