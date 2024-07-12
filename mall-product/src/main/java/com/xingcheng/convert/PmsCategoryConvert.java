package com.xingcheng.convert;

import com.xingcheng.domain.PmsCategory;
import com.xingcheng.vo.PmsCategoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PmsCategoryConvert {
    PmsCategoryConvert INSTANCT = Mappers.getMapper(PmsCategoryConvert.class);

    PmsCategoryVO converObject(PmsCategory obj);
    List<PmsCategoryVO> converListObject(List<PmsCategory> list);
}
