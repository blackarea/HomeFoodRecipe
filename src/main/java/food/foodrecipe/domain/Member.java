package food.foodrecipe.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
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

    @Enumerated(EnumType.STRING) //이건왜 @Builder.Default이게 없어도 되는거지?..
    private Role role = Role.ROLE_MEMBER;

    @Builder.Default //builder는 기본적으로 null값이 들어가는데 기본값을 사용하려면 이 어노테이션이 필요하다
    @OneToMany(mappedBy = "member")
    private List<Recipe> recipes = new ArrayList<>();

    public Member(String user_id, String password, String name){
        this.user_id = user_id;
        this.password = password;
        this.name = name;
    }
}
