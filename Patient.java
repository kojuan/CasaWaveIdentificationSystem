package healthMonitoringSystem;

public class Patient {

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String genderSelect;
    private String dateOfBirth;
    private String bloodType;
    private String civilStatus;
    private String religion;
    private String nationality;
    private String phonenumber;
    private byte[] imagePath;

// Constructors
//    public Patient(int iD, String firstName, String middleName, String lastName, String genderSelect,
//            Date dateOfBirth, String bloodType, String civilStatus, String religion,
//            String nationality, String phonenumber, byte[] imagePath) {
//
//        super();
//        id = iD;
//        this.firstName = firstName;
//        this.middleName = middleName;
//        this.lastName = lastName;
//        this.genderSelect = genderSelect;
//        this.dateOfBirth = dateOfBirth;
//        this.bloodType = bloodType;
//        this.civilStatus = civilStatus;
//        this.religion = religion;
//        this.nationality = nationality;
//        this.phonenumber = phonenumber;
//        this.imagePath = imagePath;
//
//    }
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

    public String getMiddleName() {
        return middleName;
    }

    public void setmiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return genderSelect;
    }

    public void setGender(String genderSelect) {
        this.genderSelect = genderSelect;
    }

    public String getdateOfBirth() {
        return dateOfBirth;
    }

    public void setdateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getbloodType() {
        return bloodType;
    }

    public void setbloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getcivilStatus() {
        return civilStatus;
    }

    public void setcivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getphoneNumber() {
        return phonenumber;
    }

    public void setphoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public byte[] getimagePath() {
        return imagePath;
    }

    public void setimagePath(byte[] imagePath) {
        this.imagePath = imagePath;
    }

}
