package com.xingcheng.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.xingcheng.domain.PmsAttrAttrgroupRelation;

/**
 * 属性&属性分组关联(PmsAttrAttrgroupRelation)表数据库访问层
 *
 * @author xingcheng.wu
 * @since 2024-04-30 20:33:38
 */
public interface PmsAttrAttrgroupRelationMapper extends BaseMapper<PmsAttrAttrgroupRelation> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<PmsAttrAttrgroupRelation> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<PmsAttrAttrgroupRelation> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<PmsAttrAttrgroupRelation> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<PmsAttrAttrgroupRelation> entities);

}

