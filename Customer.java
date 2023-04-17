package avenue;


public class Customer {
	
	private String name;
	private String uname;
	private String password;
	private String email;
	private String mobno;
	private String address;
	private String city;
	private String state;
	private String country;
	

	
	public Customer(String name,String uname,String password,String email,String mobno,String address,String city,String state,String country) {
		this.name = name;
		this.uname = uname;
		this.password = password;
		this.email = email;
		this.mobno = mobno;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	
	
	public String getName() {
		return name;
	}


	public String getUname() {
		return uname;
	}

	
	public String getPassword() {
		return password;
	}


	public String getEmail() {
		return email;
	}


	public String getMobno() {
		return mobno;
	}


	public String getAddress() {
		return address;
	}


	public String getCity() {
		return city;
	}


	public String getState() {
		return state;
	}


	public String getCountry() {
		return country;
	}


	
	
}
