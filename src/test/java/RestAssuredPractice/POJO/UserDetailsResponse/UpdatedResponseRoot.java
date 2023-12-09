package RestAssuredPractice.POJO.UserDetailsResponse;

import java.util.List;

public class UpdatedResponseRoot{
	private List<UpdatedResponseRootItem> updatedResponseRoot;

	public void setUpdatedResponseRoot(List<UpdatedResponseRootItem> updatedResponseRoot){
		this.updatedResponseRoot = updatedResponseRoot;
	}

	public List<UpdatedResponseRootItem> getUpdatedResponseRoot(){
		return updatedResponseRoot;
	}
}