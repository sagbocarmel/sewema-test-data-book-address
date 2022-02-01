package co.ayifa.pim;

import co.ayifa.pim.exception.FormatNotFoundException;
import co.ayifa.pim.exception.InvalidFormatException;
import co.ayifa.pim.utils.PhoneValidator;

import javax.xml.validation.Validator;

public class PhoneNumber {

    // Phone number country
    private String country;

    // Phone Number
    private String phone;

    public PhoneNumber() {
    }

    public PhoneNumber(String country, String phone) {
        this.country = country;
        this.setPhone(phone);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        try {
            this.phone = PhoneValidator.validatePhone(phone, this.country) ? phone : null;
        } catch (FormatNotFoundException | InvalidFormatException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
