package food.foodrecipe.repository;

import food.foodrecipe.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>{
    @EntityGraph(attributePaths = {"recipes"}) // fetch join
    @Query("select m from Member m where m.user_id = :user_id")
    Optional<Member> findOptionalByUser_id(@Param("user_id") String user_id);
}
