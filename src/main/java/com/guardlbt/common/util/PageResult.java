package com.guardlbt.common.util;

import lombok.Data;

import java.util.List;

/**
 * @author 何建哲
 * @date 2019/1/2 18:28
 */
@Data
public class PageResult<T> {
    private Long totle;
    private Integer pageNumber;
    private Integer pageSize;
    private List<T> pages;
   
    	
   
}
