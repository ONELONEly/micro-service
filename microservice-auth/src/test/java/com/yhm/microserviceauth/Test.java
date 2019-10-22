package com.yhm.microserviceauth;

import com.yhm.microserviceauth.config.oauth.store.ResJwtTokenStore;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    @org.junit.Test
    public void test(){
        List<String> a = new ArrayList<>();
        List<String> b = null;
        List<String> c = new ArrayList<>();
        c.add("asd");
        System.out.println(CollectionUtils.isEmpty(a));
        System.out.println(CollectionUtils.isEmpty(b));
        System.out.println(CollectionUtils.isEmpty(c));

    }

    @org.junit.Test
    public void tokenDecode(){
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsidGVzdCIsIm1vYmlsZSJdLCJzY29wZSI6WyJhbGwiXSwiZXhwIjoxNTUyNjE3ODc1LCJhdXRob3JpdGllcyI6WyJhIl0sImp0aSI6ImFiZTRkMTZhLWI2M2QtNGVkYS1iYzYzLWQ0MzhmOGYwZDQ2YSIsImNsaWVudF9pZCI6InpsdCJ9.FxG1VADGhv_DtrBWB2UxBSRAeFklnMziGiqHElfqZ1tIokXzenakRwClhkmRBNv-KGJ-3PUXnJ2Eg_wtiFVw1-IJDE65GJHHMBLx_ntnjJeQaJ1NqIoeP5JtaXyTtqcZkHX5H9777H-jSyIwYF0HDCl9yEEX_MUCPbT3paOix7zL00wIqf3TSGz8cucfk9Ji0deTPXCzCAKdna9X-0___qRWOOx1EpB4IlSKXPsbW6lhVSaEXNKaIu29jNoZVgtyViVdX-KzLoZWH9chB6pKUJ--8bMD2hhODv5ohdADeJNLrIJXS0l_ucEnfoD7bG4NoY2YbyvlFBdoLmi-nEFQ9Q";
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setVerifierKey(getPubKey());
        JwtTokenStore jwtTokenStore = new JwtTokenStore(converter);
        OAuth2AccessToken oAuth2AccessToken = jwtTokenStore.readAccessToken(token);
        System.out.println(oAuth2AccessToken);
    }

    private String getPubKey() {
        Resource res = new ClassPathResource("/pubkey.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(res.getInputStream()))) {
            return br.lines().collect(Collectors.joining("\n"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }

}
