package co.ayifa.pim;

import co.ayifa.pim.exception.InvalidFormatException;
import co.ayifa.pim.utils.PhoneValidator;

public class PhoneNumber {

    // Phone number country
    private String countryCode;

    // Phone Number
    private String phone;

    public PhoneNumber() {
    }

    public PhoneNumber(String countryCode, String phone) {
        this.countryCode = countryCode;
        this.setPhone(phone);
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        try {
            this.phone = PhoneValidator.validate(this.countryCode, phone) ? phone : null;
        } catch (InvalidFormatException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "countryCode='" + countryCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
