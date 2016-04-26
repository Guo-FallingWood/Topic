package com.sang.topic.util;

import org.apache.ibatis.session.RowBounds;

/**
 * Created by arch on 2016/4/26.
 * 每次调用set方法自动计算pageNumber
 */
public class Page {
    private int currentPage;    //当前页   提供set get
    private int pageSize;       //每页大小 提供set
    private int rowNumber;      //总行数   提供set   需要外部计算行数
    private int pageNumber;     //总页数   提供get
    private String url;         //url      提供get   类似 user?p=

    public Page(int rowNumber, String url){
        currentPage = 1;
        pageSize = 10;
        this.url = url;
        setRowNumber(rowNumber);
    }

    private void countPageNumber(){
        int pageNumber = rowNumber / pageSize;
        if(rowNumber % pageSize != 0)
            pageNumber ++;
        this.pageNumber = pageNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
        countPageNumber();
    }

    public void setCurrentPage(int currentPage){
        int _currentPage = 1;
        if(currentPage > 0)
            _currentPage = currentPage;
        if(currentPage > pageNumber)
            _currentPage = pageNumber;
        this.currentPage = _currentPage;
        countPageNumber();
    }

    public void setPageSize(int pageSize){
        int _pageSize = 10;
        if(pageSize >=1 && pageSize <= 100)
            _pageSize = pageSize;
        this.pageSize = _pageSize;
        countPageNumber();
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public String getUrl() {
        return url;
    }

    public RowBounds toRowBounds(){
        RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize, pageSize);
        return rowBounds;
    }
}
