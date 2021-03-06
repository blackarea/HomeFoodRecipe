package food.foodrecipe.config;

import food.foodrecipe.domain.Member;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SecurityUser extends User {
    private static final long serialVersionUID = 1L;
    private Member member;

    public SecurityUser(Member member){
        super(member.getUser_id(), "{noop}"+member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
        this.member=member;
    }

    public Member getMember() {
        return member;
    }
}
