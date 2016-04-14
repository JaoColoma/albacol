package Classes;

import java.sql.Date;

public class Account {

    private String firstname;
    private String lastname;
    private String middlename;

    private Date birthday;
    private String address;
    private String nationality;

    private String gender;
    private String status;

    private String number;

	private String votersID;
	
	public String getVotersID(){
		return votersID;
	}
	
	public void setVotersID(String votersID){
		this.votersID = votersID;
	}

    public String getAddress() {
        return address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getGender() {
        return gender;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getNationality() {
        return nationality;
    }

    public String getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
