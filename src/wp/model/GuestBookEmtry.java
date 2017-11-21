package wp.model;

public class GuestBookEmtry {
	
	private long id;
	private String name;
	private String message;
	
	public GuestBookEmtry() {}
	
	public GuestBookEmtry(long id, String name, String message) {
		this.id = id;
		this.name = name;
		this.message = message;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
