package kr.huny.site.domain.db.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sousic on 2017-04-26.
 */
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_code")
public class UserCode {
    @Id
    private String code;

    @Column(length = 50)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
