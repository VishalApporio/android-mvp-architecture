
package com.apporio.ubereats.mvp.data.network.model.allProductresponse;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryProduct implements Serializable{

    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("product_name")
    @Expose
    private String productName;
    @SerializedName("product_image")
    @Expose
    private String productImage;
    @SerializedName("product_description")
    @Expose
    private String productDescription;
    @SerializedName("vergetarial")
    @Expose
    private Boolean vergetarial;
    @SerializedName("vergetarial_text")
    @Expose
    private String vergetarialText;
    @SerializedName("in_stock")
    @Expose
    private String inStock;
    @SerializedName("product_price")
    @Expose
    private Integer productPrice;
    @SerializedName("selectors")
    @Expose
    private List<Selector> selectors = null;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Boolean getVergetarial() {
        return vergetarial;
    }

    public void setVergetarial(Boolean vergetarial) {
        this.vergetarial = vergetarial;
    }

    public String getVergetarialText() {
        return vergetarialText;
    }

    public void setVergetarialText(String vergetarialText) {
        this.vergetarialText = vergetarialText;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public List<Selector> getSelectors() {
        return selectors;
    }

    public void setSelectors(List<Selector> selectors) {
        this.selectors = selectors;
    }

}
