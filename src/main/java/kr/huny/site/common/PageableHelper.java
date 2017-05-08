package kr.huny.site.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by sousic on 2017. 5. 8..
 */
public class PageableHelper {
    /**
     * 페이징 넘버링 헬퍼 처리
     * @param pageable
     * @return
     */
    public static PageRequest getPageRequest(Pageable pageable, Sort sort) {
        return new PageRequest(pageable.getPageNumber() > 0 ? pageable.getPageNumber()-1 : pageable.getPageNumber(),pageable.getPageSize(), sort);
    }
}
