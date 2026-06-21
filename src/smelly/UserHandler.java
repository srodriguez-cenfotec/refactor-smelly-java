
public class UserHandler {
    public void process(String name) {
        if (name == null || name.equals("")) {
            System.out.println("Error: empty user");
        } else {
            System.out.println("Welcome " + name);
        }
    }

    public void notify(String name) {
        if (name == null || name.equals("")) {
            System.out.println("Error: empty user");
        } else {
            System.out.println("Sending welcome email to " + name);
        }
    }

    public void print(String name) {
        if (name == null || name.equals("")) {
            System.out.println("Error: empty user");
        } else {
            System.out.println("User printed: " + name);
        }
    }
}
