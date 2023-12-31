package me.ywj.fmstore.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import me.ywj.fmstore.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * JWTUtil
 * JWT工具类
 */
public class JWTUtil {
    private static final long EXPIRE_TIME= 1000*60*60*10;
    // 私钥 需随机生成ss
    private static final String SECRET_KEY = "4ac59271c598d70afaf591f3f55dd22615d41c35a60d9e5d769690f3d569085d";

    // generate a token for a given user
    public static String generateToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        builder.withIssuedAt(new Date(System.currentTimeMillis()));
        builder.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME));
        return builder.sign(Algorithm.HMAC256(SECRET_KEY));
    }

    // extract the username from a token
    public static String extractUsername(String token) {
        return extractClaim(token, "username");
    }

    // extract the expiration date from a token
    public static Date extractExpiration(String token) {
        return JWT.decode(token).getExpiresAt();
    }

    // extract a specific claim from a token
    public static String extractClaim(String token, String claimName) {
        return JWT.decode(token).getClaim(claimName).asString();
    }
    public static String extractClaim(HttpServletRequest req, String claimName) {
        return JWT.decode(getToken(getHeader(req))).getClaim(claimName).asString();
    }

    // check if a token is expired
    private static Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public static Boolean verifyToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(SECRET_KEY)).build().verify(token);
            return !isTokenExpired(token);
        } catch (JWTVerificationException e) {
            return false;
        }
    }
    public static Boolean verifyFromRequest(HttpServletRequest request) {
        String authHeader = getHeader(request);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = getToken(authHeader);
            return verifyToken(token);
        }
        return false;
    }
    private static String getToken(String authHeader){
        return authHeader.substring(7);
    }
    private static String getHeader(HttpServletRequest req){
        return req.getHeader("Authorization");
    }
}
