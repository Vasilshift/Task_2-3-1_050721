package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/people")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping()
//    public String showAllUsers(Model model) {
//        model.addAttribute("users", userService.showAllUsers());
//        return "people/showallpeople";
//    }

//    @GetMapping("/people")
//    public String viewUsers(Model model, @RequestParam(value = "count", required = false, defaultValue = "2") int count) {
//        //List<User> listUsers = new ArrayList<>();
//        List<User> listUsers =
//                new UserDaoImp().showAllUsers().stream().limit(count).collect(Collectors.toList());
//        //model.addAttribute("listUsers", listUsers);
//        System.out.println(listUsers);
//
//        model.addAttribute("listUsers", listUsers.toString());
//
//        return "showallpeople";
//    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "people/showallpeople";
    }


}
