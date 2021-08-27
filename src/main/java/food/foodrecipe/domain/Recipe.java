package food.foodrecipe.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Recipe extends BaseTimeEntity{

    @Id @GeneratedValue
    @Column(name = "recipe_id")
    private Long id;

    @Column(nullable = false, length = 25)
    private String title;
    @Column(length = 1000)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", updatable = false)
    private Member member;

    @OneToMany(mappedBy = "recipe")
    private List<Comment> comments = new ArrayList<>();

    public Recipe(String title, String content, Member member){
        this.title = title;
        this.content = content;
        setMember(member);
    }

    public void setMember(Member member){
        this.member = member;
        member.getRecipes().add(this);
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
