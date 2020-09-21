
package healthMonitoringSystem;

import java.util.Date;


class Employees {
    private int employeeId;
    private String firstName, middleName, lastName,
        employeeAddress, employeeGender, dateOfBirth, employeeBloodType, cellphoneNumber, civilStatus,
        employeeReligion, employeeNationality, fatherEmailAddress, motherEmailAddress;

    
    public Employees(int employeeId, String firstName, 
        String middleName, String lastName, String employeeAddress,
        String employeeGender, String dateOfBirth, String employeeBloodType, String cellphoneNumber,
        String civilStatus, String employeeReligion, String employeeNationality,
        String fatherEmailAddress, String motherEmailAddress)
    {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.employeeAddress = employeeAddress;
        this.employeeGender = employeeGender;
        this.dateOfBirth = dateOfBirth;
        this.employeeBloodType = employeeBloodType;
        this.cellphoneNumber = cellphoneNumber;
        this.civilStatus = civilStatus;
        this.employeeReligion = employeeReligion;
        this.employeeNationality = employeeNationality;
        this.fatherEmailAddress = fatherEmailAddress;
        this.motherEmailAddress = motherEmailAddress;
    }

    Employees(int aInt, String string, String string0, String string1, String string2, String string3, String string4, String string5, String date, String string6, String string7, String string8, String string9, String string10, String string11, String string12) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getemployeeId(){
        return employeeId;
    }
    public String getfirstName(){
        return firstName;
    }
    public String getmiddleName(){
        return middleName;
    }
    public String getlastName(){
        return lastName;
    }
    public String gethomeAddressString(){
        return employeeAddress;
    }
    public String getgenderString(){
        return employeeGender;
    }
    public String getselectedbDay(){
        return dateOfBirth;
    }
    public String getbloodTypeString(){
        return employeeBloodType;
    }
    public String getphoneString(){
        return cellphoneNumber;
    }
    public String getcivilStatusString(){
        return civilStatus;
    }
    public String getreligionString(){
        return employeeReligion;
    }
    public String getnationalityString(){
        return employeeNationality;
    }
    public String getfatherEmailAddressString(){
        return fatherEmailAddress;
    }
    public String getmotherEmailAddressString(){
        return motherEmailAddress;
    }
    
    
    
    
    
    
    
    
    
            } // class Employees
