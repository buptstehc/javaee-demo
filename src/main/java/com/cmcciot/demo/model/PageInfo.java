package com.cmcciot.demo.model;

/**
 * @Description
 * @Author 黄川
 * @Date 16/1/13
 */

public class PageInfo {

    private int total = 0; // 总记录数
    private int limit = 20; // 每页显示记录数
    private int pages = 1; // 总页数
    private int pageNumber = 1; // 当前页
    private boolean isFirstPage = false;        //是否为第一页
    private boolean isLastPage = false;         //是否为最后一页
    private boolean hasPreviousPage = false;   //是否有前一页
    private boolean hasNextPage = false;       //是否有下一页
    private static final int navigatePages = 8; //导航页码数
    private int[] navigatePageNumbers;  //所有导航页号

    public PageInfo(int total, int pageNumber, int limit) {
        init(total, pageNumber, limit);
    }

    private void init(int total, int pageNumber, int limit) {
        //设置基本参数
        this.total = total;
        this.limit = limit;
        this.pages = (this.total - 1) / this.limit + 1;

        //根据输入可能错误的当前号码进行自动纠正
        if (pageNumber < 1) {
            this.pageNumber = 1;
        } else if (pageNumber > this.pages) {
            this.pageNumber = this.pages;
        } else {
            this.pageNumber = pageNumber;
        }

        //基本参数设定之后进行导航页面的计算
        calcNavigatePageNumbers();

        //以及页面边界的判定
        judgePageBoudary();
    }

    /**
     * 计算导航页
     */
    private void calcNavigatePageNumbers() {
        //当总页数小于或等于导航页码数时
        if (pages <= navigatePages) {
            navigatePageNumbers = new int[pages];
            for (int i = 0; i < pages; i++) {
                navigatePageNumbers[i] = i + 1;
            }
        } else { //当总页数大于导航页码数时
            navigatePageNumbers = new int[navigatePages];
            int startNum = pageNumber - navigatePages / 2;
            int endNum = pageNumber + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
                //(最前navPageCount页
                for (int i = 0; i < navigatePages; i++) {
                    navigatePageNumbers[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
                //最后navPageCount页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatePageNumbers[i] = endNum--;
                }
            } else {
                //所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatePageNumbers[i] = startNum++;
                }
            }
        }
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNumber == 1;
        isLastPage = pageNumber == pages && pageNumber != 1;
        hasPreviousPage = pageNumber != 1;
        hasNextPage = pageNumber != pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public boolean isFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage) {
        isFirstPage = firstPage;
    }

    public boolean isLastPage() {
        return isLastPage;
    }

    public void setLastPage(boolean lastPage) {
        isLastPage = lastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int[] getNavigatePageNumbers() {
        return navigatePageNumbers;
    }

    public void setNavigatePageNumbers(int[] navigatePageNumbers) {
        this.navigatePageNumbers = navigatePageNumbers;
    }
}
