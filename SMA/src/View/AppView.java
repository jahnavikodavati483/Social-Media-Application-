package View;

import Controller.*;
import Model.*;

import java.util.*;

public class AppView {

    private Scanner sc = new Scanner(System.in);
    private UserController userController = new UserController();
    private PostController postController = new PostController();

    public void start() {
        while (true) {
            System.out.println("\n1.Signup 2.Login 3.Exit");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> signup();
                case 2 -> login();
                case 3 -> System.exit(0);
            }
        }
    }

    private void signup() {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("DOB: ");
        String dob = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Location: ");
        String loc = sc.nextLine();

        System.out.print("Occupation: ");
        String occ = sc.nextLine();

        userController.addUser(new User(name, dob, age, loc, occ));
        System.out.println("Signup done!");
    }

    private void login() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        User user = userController.login(name);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        userMenu(user);
    }

    private void userMenu(User user) {
        while (true) {
            System.out.println("\n1.Suggestions 2.Post 3.Feed 4.Notifications 5.Logout");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> userController.showSuggestions(user);
                case 2 -> {
                    System.out.print("Enter post: ");
                    String content = sc.nextLine();
                    postController.createPost(user, content);
                }
                case 3 -> postController.showFeed(user);
                case 4 -> showNotifications(user);
                case 5 -> { return; }
            }
        }
    }

    private void showNotifications(User user) {
        for (Notification n : user.getNotifications()) {
            System.out.println(n.getMessage());
        }
        user.getNotifications().clear();
    }
}