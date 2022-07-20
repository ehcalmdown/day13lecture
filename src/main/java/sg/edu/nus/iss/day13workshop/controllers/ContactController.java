package sg.edu.nus.iss.day13workshop.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import sg.edu.nus.iss.day13workshop.models.Contact;
import sg.edu.nus.iss.day13workshop.services.DataBaseService;

@Controller
@RequestMapping(path="/contact")
public class ContactController {
    @Autowired
    private DataBaseService dbSvc;


    @PostMapping(consumes = "application/x-www-form-urlencoded", produces = "text/html")
    public String postContact(@RequestBody MultiValueMap<String, String> form, Model model){
        Contact c = new Contact();
        c.setName(form.getFirst("name"));
        c.setEmail(form.getFirst("email"));
        c.setPhone(form.getFirst("phone"));

        dbSvc.save(c);

        return "/showcontact";
    }
    @GetMapping(value="/{id}", produces="text/html")
    public String getContact(@PathVariable("id") String id, Model model){

        Contact c = new Contact();
        c=dbSvc.read(id);
        System.out.println("id:" + c);

        model.addAttribute("contact", c);
        return "showContact";
    }
}
