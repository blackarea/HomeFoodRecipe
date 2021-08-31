package food.foodrecipe.domain;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString(of = {"id", "name"})
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String user_id;
    @Column(nullable = false, length = 100)
    private String password;

    @Column(length = 12)
    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder.Default
    @OneToMany(mappedBy = "member")
    private List<Recipe> recipes = new ArrayList<>();

    public Member(String user_id, String password, String name){
        this.user_id = user_id;
        this.password = password;
        this.name = name;
    }
}
