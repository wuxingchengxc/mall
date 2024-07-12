package com.xingcheng.controller;

import com.github.pagehelper.PageInfo;
import com.xingcheng.domain.Result;
import com.xingcheng.enums.ReturnCodeEnum;
import com.xingcheng.util.PageUtils;

import java.util.List;

public class BaseController<T> {


    protected <T>Result<T> success () {
        return Result.success();
    }
    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageUtils.startPage();
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected PageInfo<?> getPageInfo(List<?> list)
    {
        return new PageInfo(list);
    }

    protected <T>Result<T> success (T data) {
        return Result.success(data);
    }

    protected <T>Result<T> error () {
        return Result.error();
    }

    protected <T>Result<T> error (ReturnCodeEnum returnCodeEnum) {
        return Result.error(returnCodeEnum);
    }


}
