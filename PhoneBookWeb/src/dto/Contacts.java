package dto;

public class Contacts 
{
	
	private String firstName;
//	private String middleName;
	private String lastName;
	private String mobile;
	private String landLine;
	private String fax;
	private int id;
	
	public Contacts(String firstname,String lastname,String mob,String landline,String fx,int id)
	{
		firstName=firstname;
		//middleName=middlename;
		lastName=lastname;
		mobile=mob;
		landLine=landline;
	    fax=fx;	
	    this.id=id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contacts()
	{
		
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
//	public void setMiddleName(String middleName) {
//		this.middleName = middleName;
//	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setLandLine(String landLine) {
		this.landLine = landLine;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getFirstName() {
		return firstName;
	}
//	public String getMiddleName() {
//		return middleName;
//	}
	public String getLastName() {
		return lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public String getLandLine() {
		return landLine;
	}
	public String getFax() {
		return fax;
	}
	
	
	

}
