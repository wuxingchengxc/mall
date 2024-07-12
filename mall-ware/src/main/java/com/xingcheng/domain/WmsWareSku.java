package com.xingcheng.domain;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

/**
 * 商品库存(WmsWareSku)表实体类
 *
 * @author xingcheng.wu
 * @since 2024-04-20 18:48:54
 */
@SuppressWarnings("serial")
public class WmsWareSku extends Model<WmsWareSku> {

    /**
     * 主键值
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    
              
    //sku_id    
    private Long skuId;
    
              
    //仓库id    
    private Long wareId;
    
              
    //库存数    
    private Integer stock;
    
              
    //sku_name    
    private String skuName;
    
              
    //锁定库存    
    private Integer stockLocked;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getWareId() {
        return wareId;
    }

    public void setWareId(Long wareId) {
        this.wareId = wareId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Integer getStockLocked() {
        return stockLocked;
    }

    public void setStockLocked(Integer stockLocked) {
        this.stockLocked = stockLocked;
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

