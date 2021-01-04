package beans;

public class Action {
	private boolean ActionType;
	private String page;
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isActionType() {
		return this.ActionType;
	}
	public void setActionType(boolean actionType) {
		this.ActionType = actionType;
	}
	public String getPage() {
		return this.page;
	}
	public void setPage(String page) {
		this.page = page;
	}
}
