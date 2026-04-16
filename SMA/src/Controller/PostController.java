package Controller;
import Model.*;
public class PostController
{

    public void createPost(User user, String content) 
    {
        user.getPosts().add(new Post(user, content));
    }

    public void showFeed(User user)
    {
        for (User f : user.getFriends()) 
        {
            for (Post p : f.getPosts())
            {
                System.out.println("\n" + p.getAuthor().getName() + ": " + p.getContent());
                System.out.println("Likes: " + p.getLikes());
                for (Comment c : p.getComments())
                {
                    System.out.println(c.getUser().getName() + ": " + c.getText());
                }
            }
        }
    }
    public void likePost(Post post) 
    {
        post.like();
    }
    public void comment(Post post, User user, String text) 
    {
        post.addComment(new Comment(user, text));
    }
}