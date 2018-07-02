package ar.com.heroes.config;

/**
 * Created by nlosada on 01/07/18.
 * curl -i -H "Content-Type: application/json" -X POST -d '{ "email": "admin", "password": "admin"}' http://localhost:8080/heroes/login
 *
 */
public class Constants {
    // Spring Security

    public static final String LOGIN_URL = "/login";
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT

    public static final String ISSUER_INFO = "https://www.autentia.com/";
    public static final String SUPER_SECRET_KEY = "1234";
    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day
}
