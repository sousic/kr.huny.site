package kr.huny.site.domain.db.User;

import kr.huny.site.domain.db.Login.LoginHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sousic on 2017. 3. 5..
 */
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_no")
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 200, nullable = false)
    private String pwd;

    private Date pwdChangeDate;

    @Column(length = 50)
    private String nickname;

    private Date regDate;

    private int grade;

    private int lastLoginDate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "code")
    @Null
    private UserCode userCode;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<LoginHistory> loginHistoryList = new ArrayList<LoginHistory>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getPwdChangeDate() {
        return pwdChangeDate;
    }

    public void setPwdChangeDate(Date pwdChangeDate) {
        this.pwdChangeDate = pwdChangeDate;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(int lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public List<LoginHistory> getLoginHistoryList() {
        return loginHistoryList;
    }

    public void setLoginHistoryList(List<LoginHistory> loginHistoryList) {
        this.loginHistoryList = loginHistoryList;
    }
}
