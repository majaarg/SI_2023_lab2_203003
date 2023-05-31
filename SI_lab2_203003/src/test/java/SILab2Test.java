import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    @Test
    void EveryBranchTest1() {
        User user = null; //nema user
        List<User> allUsers = new ArrayList<>();

        Assertions.assertThrows(RuntimeException.class, () -> {
            SILab2.function(user, allUsers);
        });

        User user1 = new User("maja_argirova", "maja_argirova", "maja@example.com"); //ist username i pass
        boolean result = SILab2.function(user1, allUsers);
        Assertions.assertFalse(result, "Vneseni se isto korisnicko ime i password.");

        User user2 = new User("maja_argirova", "maja argirova", "maja@example.com"); //pass ima prazno mesto
        boolean result2 = SILab2.function(user2, allUsers);
        Assertions.assertFalse(result2, "Vneseni se isto korisnicko ime i password.");

        User user3 = new User(null, "maja123@", "maja@example.com"); //nema postoecki username, validen pass i email
        boolean result3 = SILab2.function(user3, allUsers);
        Assertions.assertFalse(result3, "Mora da vnesete postoecki korisnik.");
    }

    @Test
    void MultipleConditionsTest(){
        List<User> allUsers = new ArrayList<>();

        User user = new User("john_doe", "Password123", null);
        Assertions.assertThrows(RuntimeException.class, () -> {
            SILab2.function(user, allUsers);
        });

        User user1 = new User("john_doe", null, "john@example.com");
        Assertions.assertThrows(RuntimeException.class, () -> {
            SILab2.function(user1, allUsers);
        });

        User user2 = null;
        Assertions.assertThrows(RuntimeException.class, () -> {
            SILab2.function(user, allUsers);
        });


    }
}