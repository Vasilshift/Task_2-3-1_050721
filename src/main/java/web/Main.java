//package web;
//
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import web.config.AppHiberConfig;
//import web.model.User;
//import web.service.UserService;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) throws SQLException {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppHiberConfig.class);
//
//        UserService userService = context.getBean(UserService.class);
//
//        userService.add(new User("User1", "Lastname1"));
//        userService.add(new User( "User2", "Lastname2"));
//
//        List<User> users = userService.showAllUsers();
//        for (User user : users) {
//            System.out.println("Id = "+user.getId());
//            System.out.println("First Name = "+user.getName());
//            System.out.println("Last Name = "+user.getSurName());
//            System.out.println();
//        }
//
//        context.close();
//    }
//}
