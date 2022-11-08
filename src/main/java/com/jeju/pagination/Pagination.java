package com.jeju.pagination;

public class Pagination {
    private int currentPage;
    private int maxPage;
    private int startNavi;
    private int endNavi;

    public Pagination(
            Integer page,
            int totalCount,
            int boardLimit){

        int currentPage = (page != null) ? page : 1; // 현재페이지, page값이 없으면 1로 출력, 아니면 받아온 page값 출력

        int naviLimit = 5; // 한 화면에 출력한 게시판 페이지 수
        int maxPage; // 게시판의 총 페이지 수
        int startNavi; // 한 화면에 출력되는 게시판 페이지의 처음 수
        int endNavi; // 한 화면에 출력되는 게시판 페이지의 마지막 수

        maxPage = (int) ((double) totalCount / boardLimit + 0.9);
        startNavi = ((int) ((double)currentPage / naviLimit + 0.9) -1) * naviLimit + 1;
        endNavi = startNavi + naviLimit -1;

        if(maxPage < endNavi) {
            endNavi = maxPage;
        }

        this.currentPage = currentPage;
        this.endNavi = endNavi;
        this.maxPage = maxPage;
        this.startNavi = startNavi;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public int getStartNavi() {
        return startNavi;
    }

    public void setStartNavi(int startNavi) {
        this.startNavi = startNavi;
    }

    public int getEndNavi() {
        return endNavi;
    }

    public void setEndNavi(int endNavi) {
        this.endNavi = endNavi;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "currentPage=" + currentPage +
                ", maxPage=" + maxPage +
                ", startNavi=" + startNavi +
                ", endNavi=" + endNavi +
                '}';
    }
}
