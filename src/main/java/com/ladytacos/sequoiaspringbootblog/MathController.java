package com.ladytacos.sequoiaspringbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

//  ------------------------ Addition
    @GetMapping("/add/{numberFirst}/and/{numberSecond}")
    @ResponseBody
    public String add(@PathVariable String numberFirst, @PathVariable String numberSecond) {
        return Integer.parseInt(numberFirst) + " plus " + Integer.parseInt(numberSecond) + " equals " + (Integer.parseInt(numberFirst)+Integer.parseInt(numberSecond));
    }

    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public String add(@PathVariable int x, @PathVariable int y) {
        return "" + (x + y);
    }


//  ------------------------ Subtraction
    @GetMapping("/subtract/{numberSecond}/from/{numberFirst}")
    @ResponseBody
    public String subtract(@PathVariable String numberSecond, @PathVariable String numberFirst) {
        return Integer.parseInt(numberFirst) + " minus " + Integer.parseInt(numberSecond) + " equals " + (Integer.parseInt(numberFirst)-Integer.parseInt(numberSecond));
    }

    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public String subtract(@PathVariable int x, @PathVariable int y) {
        return "" + (y - x);
    }


//  ------------------------ Multiplication
    @GetMapping("/multiply/{numberFirst}/and/{numberSecond}")
    @ResponseBody
    public String multiply(@PathVariable String numberFirst, @PathVariable String numberSecond) {
        return Integer.parseInt(numberFirst) + " times " + Integer.parseInt(numberSecond) + " equals " + (Integer.parseInt(numberFirst)*Integer.parseInt(numberSecond));
    }

    @GetMapping("/multiply/{x}/by/{y}")
    @ResponseBody
    public String multiply(@PathVariable int x, @PathVariable int y) {
        return "" + (x * y);
    }


//  ------------------------ Division
    @GetMapping("/divide/{numberSecond}/by/{numberFirst}")
    @ResponseBody
    public String divide(@PathVariable String numberSecond, @PathVariable String numberFirst) {
        return Float.parseFloat(numberSecond) + " divided by " + Float.parseFloat(numberFirst) + " equals " + (Float.parseFloat(numberSecond)/Float.parseFloat(numberFirst));
    }

    @GetMapping("/divide/{x}/by/{y}")
    @ResponseBody
    public String divide(@PathVariable int x, @PathVariable int y) {
        return "" + (x / y);
    }
}
