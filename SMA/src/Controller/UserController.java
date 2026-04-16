package Controller;
import Model.*;
import java.util.*;

public class UserController {

    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User login(String name) {
        for (User u : users) {
            if (u.getName().equalsIgnoreCase(name)) return u;
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }

    // Friend Request
    public void sendRequest(User from, User to)
    {
        to.getRequests().add(from);
        to.getNotifications().add(new Notification(from.getName() + " sent request"));
    }

    public void acceptRequest(User user, User requester) {
        user.getFriends().add(requester);
        requester.getFriends().add(user);
        user.getRequests().remove(requester);
    }

    // Suggestions
    public void showSuggestions(User user) {
        for (User u : users) {
            if (u == user || user.getFriends().contains(u)) continue;

            int mutual = countMutual(user, u);

            if (mutual > 0) {
                System.out.println(u.getName() + " (Mutual: " + mutual + ")");
            } else if (user.getLocation().equals(u.getLocation()) || user.getAge() == u.getAge()) {
                System.out.println(u.getName() + " (Matching Profile)");
            } else {
                System.out.println(u.getName());
            }
        }
    }

    private int countMutual(User a, User b) {
        int count = 0;
        for (User f : a.getFriends()) {
            if (b.getFriends().contains(f)) count++;
        }
        return count;
    }
}