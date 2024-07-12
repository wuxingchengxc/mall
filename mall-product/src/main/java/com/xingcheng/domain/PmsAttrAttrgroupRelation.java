package com.xingcheng.domain;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * 属性&属性分组关联(PmsAttrAttrgroupRelation)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-30 20:33:38
 */
@SuppressWarnings("serial")
@Schema(description = "属性&属性分组关联实体类" )
public class PmsAttrAttrgroupRelation extends Model<PmsAttrAttrgroupRelation> {

    /**
     * 主键值
     */
    @TableId(type = IdType.AUTO)
    @Schema(description = "主键值" )
    private Long id;
    
              
    //属性id    
    @Schema(description = "属性id" )
    private Long attrId;
    
              
    //属性分组id    
    @Schema(description = "属性分组id" )
    private Long attrGroupId;
    
              
    //属性组内排序    
    @Schema(description = "属性组内排序" )
    private Integer attrSort;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrGroupId() {
        return attrGroupId;
    }

    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
    }

    public Integer getAttrSort() {
        return attrSort;
    }

    public void setAttrSort(Integer attrSort) {
        this.attrSort = attrSort;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.id;
    }
    }

