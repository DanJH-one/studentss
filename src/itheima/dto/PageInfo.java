package itheima.dto;

import java.util.List;

public class PageInfo<T> {
    private List<T> data;//总数据
    private Integer pageNum;//当前页
    private boolean isStartpage;//是否是第一页
    private boolean islendpage;//是否是最后一页
    private Integer pageCount;//总页数

    @Override
    public String toString() {
        return "PageInfo{" +
                "data=" + data +
                ", pageNum=" + pageNum +
                ", isStartpage=" + isStartpage +
                ", islendpage=" + islendpage +
                ", pageCount=" + pageCount +
                '}';
    }

    public List<T> getData() {
        return data;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public boolean getIsStartpage() {
        return isStartpage;
    }

    public boolean getIslendpage() {
        return islendpage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setStartpage(boolean startpage) {
        isStartpage = startpage;
    }

    public void setIslendpage(boolean islendpage) {
        this.islendpage = islendpage;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public PageInfo(List<T> data, Integer pageNum, boolean isStartpage, boolean islendpage, Integer pageCount) {
        this.data = data;
        this.pageNum = pageNum;
        this.isStartpage = isStartpage;
        this.islendpage = islendpage;
        this.pageCount = pageCount;


    }
}
