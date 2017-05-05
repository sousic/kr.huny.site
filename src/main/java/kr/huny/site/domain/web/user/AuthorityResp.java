package kr.huny.site.domain.web.user;

import lombok.*;

import java.util.List;

/**
 * Created by sousic on 2017. 5. 5..
 */
@Data
@ToString
@NoArgsConstructor
public class AuthorityResp<T> {
    //{"content":[{"authority":255,"authority_name":"슈퍼관리자"},{"authority":100,"authority_name":"관리자"},{"authority":10,"authority_name":"일반"},{"authority":1,"authority_name":"방문자"}],"last":true,"totalPages":1,"totalElements":4,"size":10,"number":0,"sort":[{"direction":"DESC","property":"authority","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"first":true,"numberOfElements":4}

    private List<T> list;

    private boolean last;
    private boolean first;
    private int totalPages;
    private int size;
    private int number;
    private Long totalElements;
}
