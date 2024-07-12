package com.xingcheng.exception.file;

/**
 * 文件名称超长限制异常类
 *
 */
public class FileNameLengthLimitExceededException extends FileException
{
    private static final long serialVersionUID = 1L;

    public FileNameLengthLimitExceededException(int defaultFileNameLength)
    {
        super(006, new Object[] { defaultFileNameLength }, "the filename is too long");
    }
}
