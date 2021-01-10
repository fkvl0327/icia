package beans;

public class Action {
	private boolean ActionType;
	private String page;
	private String message;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
