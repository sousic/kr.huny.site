package kr.huny.site.domain.web;

import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 목록에 사용할공용 반환 클래스
 * @param <T>
 */
@Data
@ToString
@NoArgsConstructor
public class CommonPageResp<T> {

    public CommonPageResp(Page<T> page) {
        list = page.getContent();
        last = page.isLast();
        first = page.isFirst();
        totalPages = page.getTotalPages();
        size = page.getSize();
        number = page.getNumber();
        totalElements = page.getTotalElements();
    }

    private List<T> list;

    private boolean last;
    private boolean first;
    private int totalPages;
    private int size;
    private int number;
    private Long totalElements;
}
