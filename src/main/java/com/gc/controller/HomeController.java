package com.gc.controller;

/**
 * Created by michaelgleeson on 7/21/17.
 */


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")

    public ModelAndView helloWorld() {
        String name = "Michael's Coffee Shop";
        return new
                ModelAndView("welcome","name", name);

    }

    @RequestMapping("/form")
    //String method returns the jsp Page that we want to show
    public String htmlForm() {

        return "htmlform";
    }

    @RequestMapping("/success")
    //Model is a parameter that allows us to add stuff to our jsp pages
    //RequestParam allows us to take in data from the form -- we must assign a type and variable name with it
    public String formSuccess(Model model, @RequestParam("c_name") String name, @RequestParam("c_lastname") String lastName, @RequestParam("c_email") String eMail,
                              @RequestParam("c_phone") String phoneNumber, @RequestParam("c_password") String password) {
        model.addAttribute("userName", name);
        model.addAttribute("lastName", lastName);
        model.addAttribute("email", eMail);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("passWord", password);

        return "formsuccess";
    }
}