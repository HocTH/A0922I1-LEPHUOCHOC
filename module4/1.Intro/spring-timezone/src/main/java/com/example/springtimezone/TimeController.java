package com.example.springtimezone;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Name;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping(value = "world-clock")
    public String getTimeByTimeZone(ModelMap model, @RequestParam(name = "city",required = false,defaultValue = "Asia/Ho_Chi_Minh") String City){
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(City);
        long locale_time = date.getTime()+locale.getRawOffset()-local.getRawOffset();
          date.setTime(locale_time);
          model.addAttribute("city",City);
          model.addAttribute("date",date);
        return "index";
    }
}
