package hr.danko.model;


public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String mailAddress;
    private String validStatus;

    public Contact(){

    }

    public Contact(String firstName, String lastName, String mailAddress, String validStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAddress = mailAddress;
        this.validStatus = validStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(String validStatus) {
        this.validStatus = validStatus;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", validStatus='" + validStatus + '\'' +
                '}';
    }
}
