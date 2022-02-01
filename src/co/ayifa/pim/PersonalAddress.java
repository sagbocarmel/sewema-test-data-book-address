package co.ayifa.pim;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonalAddress {

    // Physical address
    private String address;

    // Postal or zip code
    private String zipCode;

    // City
    private String city;

    // Country
    private String country;

    public PersonalAddress(String address, String zipCode, String city, String country) {
        this.address = address;
        this.setZipCode(zipCode);
        this.city = city;
        this.country = country;
    }

    public PersonalAddress() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        // Check Zip Code format
        Pattern pattern = Pattern.compile("^\\d{0,3}[A-Z]{0,2}\\d{2,5}$");
        Matcher matcher = pattern.matcher(zipCode);
        //If valid pattern match then set value
        if (matcher.matches()){
            System.out.println("valid : "+zipCode);
            this.zipCode = zipCode;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "PersonalAddress{" +
                "address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
