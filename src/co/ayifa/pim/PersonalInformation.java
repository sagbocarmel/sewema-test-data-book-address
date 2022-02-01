package co.ayifa.pim;

import java.util.Set;

public class PersonalInformation {

    // Lastname
    private String name;

    // Firstname
    private String firstName;

    // Person Addresses
    private Set<PersonalAddress> personalAddressList;

    // Set of phone numbers owned
    private Set<PhoneNumber> phoneNumbers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<PersonalAddress> getPersonalAddressList() {
        return personalAddressList;
    }

    public void setPersonalAddressList(Set<PersonalAddress> personalAddressList) {
        this.personalAddressList = personalAddressList;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }


    @Override
    public String toString() {
        return "PersonalInformation{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", personalAddressList=" + personalAddressList +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
