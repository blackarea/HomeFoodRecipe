package food.foodrecipe.repository;

import food.foodrecipe.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m where m.user_id = :user_id")
    Optional<Member> findOptionalByUser_id(String user_id);
}
