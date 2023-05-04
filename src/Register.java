import java.util.Scanner;
import java.util.UUID;

abstract class display{
     void notification(){};

    void showToken(UUID token){
        System.out.println("token generated: "+ token);
    }
}

class User extends display{
    protected String username;
    protected String password;

    protected UUID token;
    void tokenCreation(){
        token = UUID.randomUUID();
    }

    void register(String username, String password){
        this.username = username;
        this.password = password;
        tokenCreation();
        System.out.println("username: "+ this.username);
        System.out.println("password: "+ this.password);
    }

    @Override
    void notification() {
        System.out.println("Account Created by user");
        showToken(this.token);
    }
}
class Admin extends User{
    private final String role = "Admin";
    @Override
    void notification() {
        System.out.println("Account Created by"+ role);
        showToken(this.token);
    }
}
public class Register {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=========================");
        System.out.println("===Registrasi Account====");
        System.out.println("=========================");
        System.out.print("Masukkan username : ");
        String username = input.nextLine();
        System.out.print("Masukkan password : ");
        String password = input.nextLine();
        User user = new User();
        user.register(username,password);
        user.notification();
    }
}