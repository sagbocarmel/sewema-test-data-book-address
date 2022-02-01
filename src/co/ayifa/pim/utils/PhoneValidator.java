package co.ayifa.pim.utils;

import co.ayifa.pim.PhoneNumber;
import co.ayifa.pim.exception.FormatNotFoundException;
import co.ayifa.pim.exception.InvalidFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {

    /**
     * Availbale country for our pim
     */
    private final static String BENIN = "BENIN";

    private final static String TOGO = "TOGO";

    private final static String NIGERIA = "NIGERIA";

    private final static String USA = "USA";

    private final static String FRANCE = "FRANCE";


    /**
     * Regex Pattern for phone validation based on provided country
     */
    private final static String BENIN_PATTERN = "^(\\+\\d{3}[- ]?)?(\\d{2}[- ]?){3}\\d{2}$|(\\d{2}[- ]?){3}\\d{2}$";

    private final static String TOGO_PATTERN = "^(\\+\\d{3}[- ]?)?(\\d{2}[- ]?){3}\\d{2}$|(\\d{2}[- ]?){3}\\d{2}$";

    private final static String NIGERIA_PATTERN = "^(\\+\\d{3}[- ]?)?(\\d{3}[- ]?){2,3}\\d{3}$|(\\d{3}[- ]?){2,3}\\d{3}$";

    private final static String USA_PATTERN = "^(\\+\\d{1,3}[- ]?)?(\\d{3}[- ]?){4}\\d{2}$|(\\d{3}[- ]?){2}\\d{4}$";

    private final static String FRANCE_PATTERN = "^(\\+\\d{2}[- ]?)?(0)?[0-9][- ]?(\\d{2}[- ]?){3}\\d{2}$|(0)?[0-9][- ]?(\\d{2}[- ]?){3}\\d{2}$";

    /**
     * Function used to validate PhoneNumber object using country
     * @param phoneNumber PhoneNumber
     * @return boolean
     */
    public static boolean validatePhone(String phoneNumber, String country) throws FormatNotFoundException, InvalidFormatException {

        switch (country.toUpperCase()){
            case BENIN:
                return validator(BENIN_PATTERN, phoneNumber);
            case TOGO:
                return validator(TOGO_PATTERN, phoneNumber);
            case NIGERIA:
                return validator(NIGERIA_PATTERN, phoneNumber);
            case FRANCE:
                return validator(FRANCE_PATTERN, phoneNumber);
            case USA:
                return validator(USA_PATTERN, phoneNumber);
            default:
                throw new FormatNotFoundException("Phone number country not supported");
        }
    }

    /**
     * Function used to validate phone number based on regex
     * @param regexPattern String
     * @param phone String
     * @return boolean
     */
    private static boolean validator(String regexPattern, String phone) throws InvalidFormatException {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()){
            System.out.println("Valid phone : "+phone);
            return true;
        }
        throw new InvalidFormatException("Invalid format match for phone number");
    }
}
