package kr.huny.site.domain.db.Login;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import kr.huny.site.domain.db.User.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by sousic on 2017. 3. 5..
 */
@ToString
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_loginhistory")
public class LoginHistory {
    @Column(name = "history_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_no", nullable = false)
    private Long userNo;

    @JsonUnwrapped
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_no", referencedColumnName = "user_no")
    @MapsId("user_no")
    private User user;

    private Date loginDate;

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }*/
}
