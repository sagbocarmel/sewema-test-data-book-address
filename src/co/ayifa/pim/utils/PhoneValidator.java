package co.ayifa.pim.utils;

import co.ayifa.pim.PhoneNumber;
import co.ayifa.pim.exception.FormatNotFoundException;
import co.ayifa.pim.exception.InvalidFormatException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {

    /**
     * Function used to validate phone number based on regex
     * @param countryCode String
     * @param phone String
     * @return boolean
     */
    public static boolean validate(String countryCode, String phone) throws InvalidFormatException {
        JSONParser jsonParser = new JSONParser();
        String regex = null;

        // Get regex based on iso code alpha
        try {
            FileReader fileReader = new FileReader("./src/co/ayifa/pim/country.json");
            try {
                JSONObject obj = (JSONObject)jsonParser.parse(fileReader);
               regex = obj.get(countryCode).toString();
            } catch (IOException | ParseException e) {
               throw new InvalidFormatException(e.getMessage());
            }
        } catch (FileNotFoundException e) {
            throw new InvalidFormatException(e.getMessage());
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()){
            System.out.println("Valid phone : "+phone);
            return true;
        }
        throw new InvalidFormatException("Invalid format match for phone number");
    }
}
