//package com.jeju.pagination.controller;
//
//import com.jeju.pagination.domain.Pagination;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//
//public class PaginationController {
//
//    private final Logger logger = LoggerFactory.getLogger(PaginationController.class);
//
//
//    public Pagination paginationList(
//            Integer page,
//            int totalCount,
//            int boardLimit){
//
//        int currentPage = (page != null) ? page : 1; // 현재페이지, page값이 없으면 1로 출력, 아니면 받아온 page값 출력
//
//        int naviLimit = 5; // 한 화면에 출력한 게시판 페이지 수
//        int maxPage; // 게시판의 총 페이지 수
//        int startNavi; // 한 화면에 출력되는 게시판 페이지의 처음 수
//        int endNavi; // 한 화면에 출력되는 게시판 페이지의 마지막 수
//
//        maxPage = (int) ((double) totalCount / boardLimit + 0.9);
//
//        startNavi = ((int) ((double)currentPage / naviLimit + 0.9) -1) * naviLimit + 1;
//        endNavi = startNavi + naviLimit -1;
//
//        if(maxPage < endNavi) {
//            endNavi = maxPage;
//        }
//
//        logger.info(currentPage+"현재페이지");
//        logger.info(maxPage+"총페이지");
//        logger.info(startNavi+"시작페이지");
//        logger.info(endNavi+"마지막 페이지이지");
//
//        Pagination pagination = new Pagination();
//        pagination.setCurrentPage(currentPage);
//        pagination.setEndNavi(endNavi);
//        pagination.setMaxPage(maxPage);
//        pagination.setStartNavi(startNavi);
//
//        return pagination;
//    }
//}
