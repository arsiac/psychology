package top.arsiac.psychology.utils.common;

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
    private Integer pageNum;

    /**
     * 页面大小
     * */
    private Integer pageSize;

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

    @Override
    public String toString() {
        return "PageParam{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
