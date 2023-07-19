package com.vanguard.warehousemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TextProcessingServiceImpl implements TextProcessingService{

    @Autowired
    FileReadService fileReadService;
    @Override
    public void textParser() {

        String text = fileReadService.getText();

        // Pattern to match each piece of information

        Pattern productNamePattern = Pattern.compile("Product Name: (.*)");
        Matcher matcher = productNamePattern.matcher(text);
        if (matcher.find()) {
            String productName = matcher.group(1).trim();
            System.out.println("Product Name: " + productName);
        }

        Pattern lastUpdateDateTimePattern = Pattern.compile("Last Updated By: (.*)");
        Matcher lastUpdateDateTimeMatcher = lastUpdateDateTimePattern.matcher(text);

        if (lastUpdateDateTimeMatcher.find()) {
            String lastUpdateDateTime = lastUpdateDateTimeMatcher.group(1).trim();
            System.out.println("Last Update Date/Time: " + lastUpdateDateTime);
        }

    }
}
