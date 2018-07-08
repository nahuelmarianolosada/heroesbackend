package ar.com.heroes.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by nlosada on 01/07/18.
 */
public class BcryptGenerator {
    public static void main(String[] args) {

        int i = 0;
        while (i < 5) {
            String password = "user";
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(password);

            System.out.println(hashedPassword);
            i++;
        }

    }
}
