package com.xingcheng.exception.file;

import com.xingcheng.exception.PublicException;

/**
 * 文件信息异常类
 *
 */
public class FileException extends PublicException
{
    private static final long serialVersionUID = 1L;

    public FileException(Integer code, Object[] args, String msg)
    {
        super("file", code, args, msg);
    }

}
