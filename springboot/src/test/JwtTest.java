import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mengtian on 2017/12/27
 */
public class JwtTest {
    @Test
    public void jwtTest1() {
        String key = "tian";
        String token = Jwts.builder().setSubject("test")
                .signWith(SignatureAlgorithm.HS512, key)
                .claim("userName", "tian")
                .setId("1")//userId
                .setExpiration(new Date(System.currentTimeMillis() + 3600))
                .setNotBefore(new Date(System.currentTimeMillis()))
                .compact();
        System.out.println(token);

        assert Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject().equals("test");
    }

    @Test
    public void test(){
        Double test = null;
        System.out.println(new BigDecimal(test).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
    }
}
