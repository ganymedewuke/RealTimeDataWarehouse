package com.ganymede.product;

public class ProductType {
    private int id;
    private String productTypeName;
    private String productTypeLevel;
    private int parentId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public String getProductTypeLevel() {
        return productTypeLevel;
    }

    public void setProductTypeLevel(String productTypeLevel) {
        this.productTypeLevel = productTypeLevel;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
