package com.xingcheng.convert;

import com.xingcheng.domain.SysMenu;
import com.xingcheng.vo.SysMenuVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysMenuConvert {
    SysMenuConvert INSTANCT = Mappers.getMapper(SysMenuConvert.class);

    SysMenuVo converObject(SysMenu obj);
    List<SysMenuVo> converListObject(List<SysMenu> list);
}
