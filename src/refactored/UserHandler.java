
public class UserHandler {
    public void process(String userName) {
        if (!isValid(userName)) {
            printErrorMessage();
        } else {
            System.out.println("Welcome " + userName);
        }
    }

    public void notify(String userName) {
        if (!isValid(userName)) {
            printErrorMessage();
        } else {
            System.out.println("Sending welcome email to " + userName);
        }
    }

    public void print(String userName) {
        if (!isValid(userName)) {
            printErrorMessage();
        } else {
            System.out.println("User printed: " + userName);
        }
    }


    private isValid(String userName) {
        return userName == null || userName.equals("");
    }


    private printErrorMessage() {
        System.out.println("Error: empty user");
    }
}
