package com.maartenmusic.day6;

import com.maartenmusic.day4.Limits;

import java.util.ArrayList;
import java.util.List;

public class PassportValidator {

    private String[] requiredFields;
    private int requiredYearLength;
    private Limits birthLimits;
    private Limits issueLimits;
    private Limits expirationLimits;
    private Limits heightLimitsCm;
    private Limits HeightLimitsIn;
    private String hairColorRegex;
    private List<String> allowedEyeColors = new ArrayList<>();
    private String passportRegex;

    public boolean validatePassport(Passport passport) {
        return (validateHeight(passport) &&
                validateBirthYear(passport) &&
                validateExpirationYear(passport) &&
                validateIssueYear(passport) &&
                validateEyeColor(passport) &&
                validateHairColor(passport) &&
                validatePassportID(passport)
                );
    }

    private boolean validatePassportID(Passport passport) {
        return passport.getMappedData().get("pid").matches(this.passportRegex);
    }

    private boolean validateEyeColor(Passport passport) {
        String eyeColor = passport.getMappedData().get("ecl");

        return this.allowedEyeColors.contains(eyeColor);
    }

    private boolean validateHairColor(Passport passport) {
        String hairColor = passport.getMappedData().get("hcl");

        return hairColor.matches(this.hairColorRegex);
    }

    private boolean validateHeight(Passport passport) {
        String height = passport.getMappedData().get("hgt");

        if(height.endsWith("cm") && height.length() == 5) {
            return isNumberWithinLimits(height.substring(0, 3), this.heightLimitsCm);
        }

        if(height.endsWith("in") &&  height.length() == 4) {
            return isNumberWithinLimits(height.substring(0, 2), this.HeightLimitsIn);
        }

        return false;
    }

    private boolean validateBirthYear(Passport passport) {
        String birthYear = passport.getMappedData().get("byr");

        return isNumberWithinLimits(birthYear, birthLimits);
    }

    private boolean validateIssueYear(Passport passport) {
        String issueYear = passport.getMappedData().get("iyr");

        return isNumberWithinLimits(issueYear, issueLimits);
    }

    private boolean validateExpirationYear(Passport passport) {
        String expirationYear = passport.getMappedData().get("eyr");

        return (isNumberWithinLimits(expirationYear, expirationLimits) && checkYearLength(expirationYear));
    }

    private boolean checkYearLength(String year) {
        return year.length() == this.requiredYearLength;
    }

    private boolean isNumberWithinLimits(String numberString, Limits limits) {
        int number = Integer.parseInt(numberString);
        return (number >= limits.getMin()
                && number <= limits.getMax());
    }

    public boolean validateRawData(Passport passport) {
        for (String field : this.requiredFields) {
            if(!passport.getRawData().contains(field)) {
                return false;
            }
        }

        return true;
    }

    public boolean validatePasswordKeys(Passport passport) {
        for (String field : this.requiredFields) {
            if(!passport.getMappedData().containsKey(field)) {
                return false;
            }
        }

        return true;
    }

    public void setRequiredFields(String[] requiredFields) {
        this.requiredFields = requiredFields;
    }

    public void setBirthYearLimits(int minBirthYear, int maxBirthYear) {
        this.birthLimits = new Limits(minBirthYear, maxBirthYear);
    }

    public void setIssueYearLimits(int minIssueYear, int maxIssueYear) {
        this.issueLimits = new Limits(minIssueYear, maxIssueYear);
    }

    public void setExpirationYearLimits(int minExpirationYear, int maxExpirationYear) {
        this.expirationLimits = new Limits(minExpirationYear, maxExpirationYear);
    }

    public void setRequiredYearLength(int requiredYearLength) {
        this.requiredYearLength = requiredYearLength;
    }

    public void setHeightLimitsCm(int minHeight, int maxHeight) {
        this.heightLimitsCm = new Limits(minHeight, maxHeight);
    }

    public void setHeightLimitsIn(int minHeight, int maxHeight) {
        this.HeightLimitsIn = new Limits(minHeight, maxHeight);
    }

    public void setHairColorRegex(String hairColorRegex) {
        this.hairColorRegex = hairColorRegex;
    }

    public void setAllowedEyeColors(List<String> allowedEyeColors) {
        this.allowedEyeColors = allowedEyeColors;
    }

    public void setPassportRegex(String passportRegex) {
        this.passportRegex = passportRegex;
    }
}
