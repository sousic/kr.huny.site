package kr.huny.site.domain;

import lombok.ToString;

import javax.persistence.*;

/**
 * Created by sousic on 2017. 3. 5..
 */
@ToString
@Entity
public class LoginHistory {
    @Column(name = "history_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
