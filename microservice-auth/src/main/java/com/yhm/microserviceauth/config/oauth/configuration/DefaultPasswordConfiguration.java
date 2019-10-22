package com.yhm.microserviceauth.config.oauth.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 声明密码工具类
 * @author zlt
 */
public class DefaultPasswordConfiguration {
    /**
     * 装配BCryptPasswordEncoder用户密码的匹配
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
         /*加密PasswordEncoderFactories.createDelegatingPasswordEncoder()可获取DelegatingPasswordEncoder对象,其使用bcrypt方式加密
           同时其matches方法可支持bcrypt,ldap,MD4,MD5,noop,pbkdf2,scrypt,SHA-1,SHA-256,sha256加密的判断
           通过传入判断值与加密值例matches("123456","{bcrypt}$2a$10$GSMz1Trk/rLEgFKHoOcgJOuzuddvdsmEm2JHxbkT.ccgeHCdfUfny")判断是否一致
           注：通过该方式加密的值同时前缀{加密方式}解析，所以加密值格式为{加密方式}加密值
           */

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //return new BCryptPasswordEncoder();

    }

    public static void main(String[] args) {
        String uuid = "123";
        PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String asd = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(uuid);

        System.out.println(delegatingPasswordEncoder.matches(uuid,asd));
        System.out.println(asd);
        System.out.println(uuid);
    }

}
