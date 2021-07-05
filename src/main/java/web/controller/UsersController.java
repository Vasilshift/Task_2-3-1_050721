//package web.controller;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import web.service.UserService;
//
//@Controller
//@RequestMapping("/people")
//public class UsersController {
//
//    private final UserService userService;
//
//    public UsersController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping()
//    public String showAllUsers(Model model) {
//        model.addAttribute("users", userService.showAllUsers());
//        return "people/showallpeople";
//    }
//
//
//}
