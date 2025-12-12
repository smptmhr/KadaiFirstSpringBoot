package com.techacademy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
public class KadaiFirstController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/dayofweek/{yyyymmdd}")
    public String dispDayOfWeek(@PathVariable String yyyymmdd) {

        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(yyyymmdd, inputFormat);
        
        String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        return "param : " + dayOfWeek;
    }
}