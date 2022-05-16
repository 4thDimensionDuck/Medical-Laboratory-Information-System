public class Patient {
    
    private String pUID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private String gender;
    private String address;
    private String phoneNo;
    private String natID;
    private Boolean isDeleted;
    private String DelRes;
    
    public Patient() {
    }

    public Patient(String pUID, String firstName, String lastName, String middleName, String birthDate,
            String gender, String address, String phoneNo, String natID, Boolean isDeleted, String DelRes) {
        this.pUID = pUID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.address = address;
        this.phoneNo = phoneNo;
        this.natID = natID;
        this.isDeleted = isDeleted;
        this.DelRes = DelRes;
    }

    public String getpUID() {
        return pUID;
    }

    public void setpUID(String pUID) {
        this.pUID = pUID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getNatID() {
        return natID;
    }

    public void setNatID(String natID) {
        this.natID = natID;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getDelRes() {
        return DelRes;
    }

    public void setDelRes(String delRes) {
        DelRes = delRes;
    }

}
