package jp.co.alpha.bean;

//ホーム画面「もっと見る」クリックした後の処理

public class Clean_Info {
	private String Serch_CleanInfo;
	private int id;
	private String name;
	private String placeList;
	private String detailList;

	public String getSerch_CleanInfo() {
		return Serch_CleanInfo;
	}

	public void setSerch_CleanInfo(String Serch_CleanInfo) {
		this.Serch_CleanInfo = Serch_CleanInfo;
	}

	public int getplaceList() {
		return placeList;
	}

	public void setplaceList(String placeList) {
		this.placeList = placeList;
	}

	public String getplaceList() {
		return placeList;
	}

	public void setdetailList(String detailList) {
		this.detailList = detailList;
	}

	// getterとsetterメソッド
	public int getdetailList() {
		return detailList;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}