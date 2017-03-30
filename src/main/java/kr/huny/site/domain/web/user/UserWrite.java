package kr.huny.site.domain.web.user;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by sousic on 2017-03-30.
 */
@Data
@ToString
public class UserWrite {
    @NotNull
    @Size(min=6, max=100)
    private String email;

    @NotNull
    @Size(min=6, max=100)
    private String pwd;

    @NotNull
    @Size(min=6, max=100)
    private String pwdConfirm;

    @NotNull
    @Size(min=2, max=50)
    private String nickName;

    /*
    * 이메일 중복 체크
    **/
    private String emailStatus = "none";

    /*
    * 닉네임 중복 체크
     */
    private String nickNameState = "none";
}
