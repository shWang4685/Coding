package com.pojo;

import java.util.List;
import java.util.Objects;

public class PagePerformance {
    private  int  pageIndex;//点击的页码
    private List<PerformanceInfo> performanceInfoList;//数据返回值
    private int pageCount=15;//每页的显示数


    public  PagePerformance(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagePerformance that = (PagePerformance) o;
        return pageIndex == that.pageIndex &&
                pageCount == that.pageCount &&
                Objects.equals(performanceInfoList, that.performanceInfoList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pageIndex, performanceInfoList, pageCount);
    }

    @Override
    public String toString() {
        return "PagePerformance{" +
                "pageIndex=" + pageIndex +
                ", performanceInfoList=" + performanceInfoList +
                ", pageCount=" + pageCount +
                '}';
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<PerformanceInfo> getPerformanceInfoList() {
        return performanceInfoList;
    }

    public void setPerformanceInfoList(List<PerformanceInfo> performanceInfoList) {
        this.performanceInfoList = performanceInfoList;
    }

    public int getPageCount() {
        return pageCount;
    }


}
