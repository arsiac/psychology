package com.github.arsiac.psychology.utils.entity;

/**
 * <p>分页需要的属性</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/23
 */
public class PageParam {
    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 页面大小
     * */
    private Integer pageSize = 10;

    /**
     * 创建者
     * */
    private Long createBy = 0L;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "PageParam{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", createBy=" + createBy +
                '}';
    }
}
