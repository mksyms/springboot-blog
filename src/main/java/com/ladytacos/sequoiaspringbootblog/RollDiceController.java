package com.ladytacos.sequoiaspringbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Random;

// Create a page at /roll-dice that asks the user to guess a number.
// There should be links on this page for 1 through 6
// that should make a get request to /roll-dice/n where n is the number guessed.
// This page should display a random number (the dice roll), the user's guess,
// and a message based on whether or not they guessed the correct number.

// Bonus
// "Roll" a series of dice on each page load, as opposed to an individual die.
// Show all the rolls to the user and display how many rolls matched their guess.

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String index() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{quantity}")
    public String userInput(@PathVariable String quantity, Model viewModel) {

        Random rn = new Random();
        int roll = rn.nextInt(6 - 1 + 1) + 1;
//          int rnd = (int) (Math.random() * 6 + 1);

        boolean match = (roll == Integer.parseInt(quantity));
//          boolean = win (rnd == match) ? true : false;

        viewModel.addAttribute("quantity", quantity);
        viewModel.addAttribute("roll", roll);
        viewModel.addAttribute("match", match);

        return "roll-dice";
    }
}

