package com.company.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    BasicRepository basicRepository;

    @RequestMapping("/")
    public String listEntries(Model model, @Valid @ModelAttribute("basic") Basic basic, BindingResult result) {
        Therapist eliza = new Therapist();
        if (result.hasErrors()) {
            return "Main";
        }

        basicRepository.save(basic);
        basicRepository.save(new Basic(getResponse(eliza, basic.getSentence())));
        model.addAttribute("Basic", basicRepository.findAll());
        return "Main";
    }

    @GetMapping("/")
    public String newBasic(Model model) {
        model.addAttribute("basic", new Basic());
        return "Main";
    }
    @GetMapping("/quit")
    public String quit(Model model) {

        basicRepository.save(new Basic("Have a nice day. See you at your next appointment"));
        model.addAttribute("Basic", basicRepository.findAll());
        return "Main";
    }



    public String getResponse(Therapist thisEliza, String t){
        String userinput[] = t.split("\\s+");
        for (String word : userinput) {
            if (word.equalsIgnoreCase("me") || word.equalsIgnoreCase("my") || word.equalsIgnoreCase("I") || word.equalsIgnoreCase("am")) {

                return "Therapist: " + thisEliza.qualifyResponse(userinput);
            }
        }
        return "Therapist: " + thisEliza.hedgeResponse();

    }
}
