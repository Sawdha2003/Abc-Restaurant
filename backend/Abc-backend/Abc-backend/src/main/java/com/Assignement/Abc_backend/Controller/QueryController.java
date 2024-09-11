package com.Assignment.Abc_Restaurant.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Assignment.Abc_Restaurant.Model.Contact;
import com.Assignment.Abc_Restaurant.Repository.QueryRepository;
import com.Assignment.Abc_Restaurant.Service.QueryService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class QueryController {

    private final QueryRepository queryRepository;  
    private final QueryService queryService;

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "Contact";
    }

    @PostMapping("/query")
    public String submitQuery(@RequestBody Contact contact) {
       
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUserName = authentication.getName();

      
        contact.setName(loggedInUserName);

        queryService.saveQuery(contact);

       
        return "redirect:/Dashboard";  
    }
}
