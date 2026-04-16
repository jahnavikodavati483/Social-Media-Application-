package Model;
import java.util.*;
public class Post 
{
    private User author;
    private String content;
    private int likes;
    private List<Comment> comments = new ArrayList<>();

    public Post(User author, String content) {
        this.author = author;
        this.content = content;
    }

    public User getAuthor() { return author; }
    public String getContent() { return content; }
    public int getLikes() { return likes; }
    public List<Comment> getComments() { return comments; }

    public void like() { likes++; }

    public void addComment(Comment c) {
        comments.add(c);
    }
}