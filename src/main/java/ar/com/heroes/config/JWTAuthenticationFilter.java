package ar.com.heroes.config;

import ar.com.heroes.model.domain.staff.StaffEntity;
import ar.com.heroes.model.domain.user.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static ar.com.heroes.config.Constants.*;

/**
 * Created by nlosada on 01/07/18.
 */

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try {
            StaffEntity credenciales = new ObjectMapper().readValue(request.getInputStream(), StaffEntity.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    credenciales.getEmail(), credenciales.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
                .setSubject(((User)auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();

        String email = ((User) auth.getPrincipal()).getUsername().toString();
        Collection<GrantedAuthority> roles = ((User) auth.getPrincipal()).getAuthorities();

        String userJson = getUserData(email, roles).toJSONString();

        response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        response.getWriter().write(userJson);

        response.addHeader("access-control-expose-headers", HEADER_AUTHORIZACION_KEY);
        response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);


    }



    private JSONObject getUserData(String name, Collection<GrantedAuthority> credenciales){
        JSONObject obj = new JSONObject();
        obj.put("email", name);

        JSONArray authorities = new JSONArray();
        for (GrantedAuthority cred: credenciales) {
            authorities.add(cred.toString());
        }
        obj.put("authorities", authorities);
        return obj;
    }


}
