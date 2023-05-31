import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String s) {
    }

    public void setPassword(String password123) {
    }
}

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) {
        if (user==null || user.getPassword()==null || user.getEmail()==null){//1 //nema korisnik, nema pass, nema meil
            throw new RuntimeException("Mandatory information missing!");//2
        }//3

        if (user.getUsername()==null){//4 //ako nema username definirano
            user.setUsername(user.getEmail());//5
        }//6

        int same = 1;//7
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) {//8 //ako meilot ima @ i .
            same = 0;//9
            for (int i=0;i<allUsers.size();i++) {//10
                User existingUser = allUsers.get(i);//11
                if (existingUser.getEmail() == user.getEmail()) {//12
                    same += 1;//13
                }//14
                if (existingUser.getUsername() == user.getUsername()) {//15
                    same += 1;//16
                }//17
            }//18//10.3
        }//19

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";//20
        String password = user.getPassword();//21
        String passwordLower = password.toLowerCase();//22

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) {//23 //pass ne smee da se sovpagja so username i da pomal od 8 karakteri
            return false;//24
        }//25
        else {//26
            if (!passwordLower.contains(" ")) {//27 //ako pass ima karakter porazlicen od prazno mesto
                for (int i = 0; i < specialCharacters.length(); i++) {//28 //proveri vo listata spec znaci
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) {//29
                        return same == 0;//30
                    }//31
                }//32
            }//33
        } //34
        return false;//35
    }//36

}
