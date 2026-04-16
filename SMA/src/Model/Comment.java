package Model;

public class Comment {
    private User user;
    private String text;

    public Comment(User user, String text) {
        this.user = user;
        this.text = text;
    }

    public User getUser() { return user; }
    public String getText() { return text; }
}