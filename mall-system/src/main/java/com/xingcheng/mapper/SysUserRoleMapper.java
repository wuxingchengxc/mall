package com.xingcheng.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.xingcheng.domain.SysUserRole;

/**
 * 用户角色(SysUserRole)表数据库访问层
 *
 * @author xingcheng.wu
 * @since 2024-04-24 22:23:09
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<SysUserRole> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<SysUserRole> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<SysUserRole> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<SysUserRole> entities);

}

