package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/people")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "people/showallpeople";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.show(id));
//        return "people/show";
//    }

//    @GetMapping("/new")
//    public String newUser(@ModelAttribute("user") User user) {
//        return "new";
//    }
//
//    @PostMapping()
//    public String add(@ModelAttribute("user") User user) {
//        userService.add(user);
//        return "redirect:/people";
//    }


}
