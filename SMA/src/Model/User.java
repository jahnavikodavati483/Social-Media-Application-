package Model;
import java.util.*;
public class User 
{
    private String name;
    private String dob;
    private int age;
    private String location;
    private String occupation;

    private List<User> friends = new ArrayList<>();
    private List<User> requests = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
    private List<Notification> notifications = new ArrayList<>();

    public User(String name, String dob, int age, String location, String occupation) 
    {
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.location = location;
        this.occupation = occupation;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getLocation() { return location; }
    public String getDob() { return dob; }
    public String getOccupation() { return occupation; }

    public List<User> getFriends() { return friends; }
    public List<User> getRequests() { return requests; }
    public List<Post> getPosts() { return posts; }
    public List<Notification> getNotifications() { return notifications; }
}