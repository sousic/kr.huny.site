package kr.huny.site.domain.db.Login;

import kr.huny.site.domain.db.User.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sousic on 2017. 3. 5..
 */
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_loginhistory")
public class LoginHistory {
    @Column(name = "history_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no")
    private User user;

    private Date loginDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getMember() {
        return user;
    }

    public void setMember(User user) {
        this.user = user;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
