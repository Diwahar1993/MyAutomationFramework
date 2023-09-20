package POJO;

public class EmailInputRoot{
	private String scenario;
	private String useCase;
	private String email;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setScenario(String scenario){
		this.scenario = scenario;
	}

	public String getScenario(){
		return scenario;
	}

	public String getUseCase() {
		return useCase;
	}

	public void setUseCase(String useCase) {
		this.useCase = useCase;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}
