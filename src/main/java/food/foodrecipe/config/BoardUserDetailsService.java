package food.foodrecipe.config;

import food.foodrecipe.domain.Member;
import food.foodrecipe.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
        Optional<Member> optional = memberRepository.findOptionalByUser_id(user_id);
        if(!optional.isPresent()){
            throw new UsernameNotFoundException(user_id+ "사용자 없음");
        }else{
            Member member = optional.get();
            return new SecurityUser(member);
        }
    }
}
