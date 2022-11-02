package com.jeju.pagination.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pagination {
    private int currentPage;
    private int maxPage;
    private int startNavi;
    private int endNavi;
}
