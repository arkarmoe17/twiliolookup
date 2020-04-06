package lol.gilliard.twiliolookupdemo;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class PersonController {

    @GetMapping("/")
    public String showForm(Person form){
        return "form";
    }

    @PostMapping("/")
    public String checkPersonForm(@Valid Person person, BindingResult bindingResult, RedirectAttributes redirect){

        if (bindingResult.hasErrors()){
            return "form";
        }

        redirect.addFlashAttribute("person", person);
        return "redirect:/showPerson";
    }

    @GetMapping("/showPerson")
    public String showPerson(){
        return "showPerson";
    }

}
