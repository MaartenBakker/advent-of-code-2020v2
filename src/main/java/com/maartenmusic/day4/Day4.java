package com.maartenmusic.day4;

import com.maartenmusic.util.FilePathGenerator;
import com.maartenmusic.util.FileReaders;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    public static void main(String[] args) {
        PassportValidator validator = new PassportValidator();

        validator.setRequiredFields(new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"});
        validator.setBirthYearLimits(1920, 2002);
        validator.setIssueYearLimits(2010, 2020);
        validator.setExpirationYearLimits(2020, 2030);
        validator.setRequiredYearLength(4);
        validator.setHeightLimitsCm(150, 193);
        validator.setHeightLimitsIn(59, 76);
        validator.setHairColorRegex("#[a-f 0-9]{6}");
        validator.setAllowedEyeColors(Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth"));
        validator.setPassportRegex("[0-9]{9}");

        File txtFile = new File(FilePathGenerator.getFilePath("day4"));
        ArrayList<Passport> passports = FileReaders.readTxtFileIntoArrayListOfPassports(txtFile);
//        passports.forEach(Passport::generateMappedData);

        System.out.println(passports.stream().filter(validator::validatePasswordKeys).count());

        List<Passport> passportsWithValidKeys = passports.stream()
                .filter(validator::validatePasswordKeys)
                .collect(Collectors.toList());

        System.out.println(passportsWithValidKeys.stream()
                .filter(validator::validatePassport)
                .count());
    }
}
