package kr.huny.site.domain.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sousic on 2017. 5. 26..
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResp {
    private int errCode;
    private String errMsg;
    private String extraMsg;
}
