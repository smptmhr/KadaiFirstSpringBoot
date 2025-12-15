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
    
    @GetMapping("/dayofweek/{yyyymmdd}")
    public String dispDayOfWeek(@PathVariable String yyyymmdd) {

        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(yyyymmdd, inputFormat);
        
        String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        return "実行結果: " + dayOfWeek;
    }
    
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        var res = val1 + val2;
        return "実行結果: " + res;
    }
    
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        var res = val1 - val2;
        return "実行結果: " + res;
    }
    
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        var res = val1 * val2;
        return "実行結果: " + res;
    }
    
    @GetMapping("/devide/{val1}/{val2}")
    public String calcDevide(@PathVariable int val1, @PathVariable int val2) {
        if (val2 == 0) return "エラー: 0では割れません";
        
        var res = val1 / val2;
        return "実行結果: " + res;
    }
}