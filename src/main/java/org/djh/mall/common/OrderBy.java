package org.djh.mall.common;

/**
 * @author alex1024duan
 */
public class OrderBy {

    private String field;
    private boolean isAsc;

    public OrderBy() {

    }

    public OrderBy(String field, boolean isAsc) {
        this.field = field;
        this.isAsc = isAsc;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean isAsc() {
        return isAsc;
    }

    public void setAsc(boolean asc) {
        isAsc = asc;
    }

    @Override
    public String toString() {
        return "OrderBy{" +
                "field='" + field + '\'' +
                ", isAsc=" + isAsc +
                '}';
    }

}
