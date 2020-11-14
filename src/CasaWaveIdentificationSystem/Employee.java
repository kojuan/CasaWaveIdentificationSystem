package CasaWaveIdentificationSystem;

public class Employee {

    private int id;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String employeeAddress;
    private String employeeGender;
    private String dateOfBirth;
    private String employeeBloodType;
    private String cellphoneNumber;
    private String civilStatus;
    private String employeeReligion;
    private String employeeNationality;
    private String fatherEmailAddress;
    private String motherEmailAddress;
    private String dateAndTimeRegistered;
    private byte[] picture;

// Getters and Setters
    public int getID() {
        return id;
    }

    public void setId(int iD) {
        id = iD;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setmiddleName(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return employeeAddress;
    }

    public void setAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getGender() {
        return employeeGender;
    }

    public void setGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getbloodType() {
        return employeeBloodType;
    }

    public void setbloodType(String employeeBloodType) {
        this.employeeBloodType = employeeBloodType;
    }

    public String getphoneNumber() {
        return cellphoneNumber;
    }

    public void setphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getcivilStatus() {
        return civilStatus;
    }

    public void setcivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getReligion() {
        return employeeReligion;
    }

    public void setReligion(String employeeReligion) {
        this.employeeReligion = employeeReligion;
    }

    public String getNationality() {
        return employeeNationality;
    }

    public void setNationality(String employeeNationality) {
        this.employeeNationality = employeeNationality;
    }
    
    public String getFatherEmailAd() {
        return fatherEmailAddress;
    }
    
    public void setFatherEmailAd(String fatherEmailAddress) {
        this.fatherEmailAddress = fatherEmailAddress;
    }

    public String getMotherEmailAd() {
        return motherEmailAddress;
    }
    
    public void setMotherEmailAd(String motherEmailAddress) {
        this.motherEmailAddress = motherEmailAddress;
    }
    
    public String getDateAndTimeRegistered() {
        return dateAndTimeRegistered;
    }
    
    public void setDateAndTimeRegistered(String dateAndTimeRegistered) {
        this.dateAndTimeRegistered = dateAndTimeRegistered;
    }
    
    public byte[] getimagePath() {
        return picture;
    }
    
    public void setimagePath(byte[] picture) {
        this.picture = picture;
    }

}
