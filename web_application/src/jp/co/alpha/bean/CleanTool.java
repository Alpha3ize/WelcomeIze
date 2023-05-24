//掃除備品一覧bean
package jp.co.alpha.bean;

import java.util.Date;

public class CleanTool {
	private int id;
	private int deleatFrag;
	private String name;
	private Date updateDate;
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeleatFrag() {
		return deleatFrag;

	}

	public void setDeleatFrag(int deleatFrag) {
		this.deleatFrag = deleatFrag;
	}

	public String getToolName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getNote() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}