package com.sjm.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private Long total;//总记录数
    private Integer totalPage;//总页数
    private List<T> items;//数据
    private Integer code = 0;

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }


}
