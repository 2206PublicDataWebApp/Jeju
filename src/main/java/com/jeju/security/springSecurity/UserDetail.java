/*
package com.jeju.security.springSecurity;


import com.jeju.member.domain.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

public class UserDetail {


    public class CustomUserDetails extends User {

        public CustomUserDetails(Member member, Collection<? extends GrantedAuthority> authorities) {
            super(
                    member.getMemberId(),
                    member.getMemberPwd(),
                    true,
                    true,
                    true,
                    true,
                    authorities
            );
        }
    }
}
*/
