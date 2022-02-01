import co.ayifa.pim.PersonalAddress;
import co.ayifa.pim.PersonalInformation;
import co.ayifa.pim.PhoneNumber;
import co.ayifa.pim.exception.FormatNotFoundException;
import co.ayifa.pim.exception.InvalidFormatException;
import co.ayifa.pim.utils.PhoneValidator;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){

        PersonalInformation personalInformation = new PersonalInformation();

        // Create User Personal Address
        PersonalAddress personalAddress = new PersonalAddress();
        personalAddress.setZipCode("724");
        personalAddress.setAddress("Abomey-Calavi ZOCA");
        personalAddress.setCity("Abomey-Calavi");
        personalAddress.setCountry("Benin");

        // Create Phone number
        PhoneNumber phoneNumber = new PhoneNumber("dza","+213-62-81-13-82" );

        // Set Personnal Information
        Set<PersonalAddress> personalAddresses = new HashSet<>();
        personalAddresses.add(personalAddress);

        Set<PhoneNumber> phoneNumbers =  new HashSet<>();
        phoneNumbers.add(phoneNumber);

        personalInformation.setPersonalAddressList(personalAddresses);
        personalInformation.setPhoneNumbers(phoneNumbers);

        // Try to print personnal
        System.out.println(personalInformation.toString());
    }
}
