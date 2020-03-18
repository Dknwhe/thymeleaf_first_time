package se.ecutb.cai.ListCrudApplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.ecutb.cai.ListCrudApplication.data.AppUserDao;
import se.ecutb.cai.ListCrudApplication.entity.AppUser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Controller
public class AppUserController {

    private AppUserDao appUserDao;

    @Autowired
    public AppUserController(AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }

    @GetMapping("/users")
    public String findAll (Model model) {
        model.addAttribute("users", appUserDao.findAll());
        return "users-list";
    }

    @PostMapping("/users/process")
    public String process(
            @RequestParam("email") String email,
            @RequestParam("name") String name,
            @RequestParam("birthDate") LocalDate birthDate
    ) {
        AppUser newUser = new AppUser(
                email,
                name,
                birthDate,
                LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)
        );

        appUserDao.save(newUser);
        return "redirect:/users";
    }

    @GetMapping("users/create")
    public String create() {
        return "user-form";
    }

    @GetMapping("users/find")
    public String findById(@RequestParam("id") String id, Model model) {
        AppUser user = appUserDao.findById(id).get();
        model.addAttribute("user", user);
        return "user-details";
    }

    @PostMapping("users/delete")
    public String delete(@RequestParam("id") String id) {
        appUserDao.delete(id);
        return "redirect:/users";

    }
}
