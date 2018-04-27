
package com.apporio.ubereats.mvp.data.network.model.allProductresponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("restauranent_id")
    @Expose
    private Integer restauranentId;
    @SerializedName("restauranent_name")
    @Expose
    private String restauranentName;
    @SerializedName("restauranent_image")
    @Expose
    private String restauranentImage;
    @SerializedName("restauranent_style")
    @Expose
    private List<RestauranentStyle> restauranentStyle = null;
    @SerializedName("restauranent_branched")
    @Expose
    private List<Object> restauranentBranched = null;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("rating_out_of")
    @Expose
    private String ratingOutOf;
    @SerializedName("average_availbility_time")
    @Expose
    private String averageAvailbilityTime;
    @SerializedName("availability_time")
    @Expose
    private String availabilityTime;
    @SerializedName("availibility_text")
    @Expose
    private String availibilityText;
    @SerializedName("favourite_visibility")
    @Expose
    private Integer favouriteVisibility;
    @SerializedName("favourite")
    @Expose
    private Boolean favourite;
    @SerializedName("currency_iso_code")
    @Expose
    private String currencyIsoCode;
    @SerializedName("currency_symbol")
    @Expose
    private String currencySymbol;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = null;

    public Integer getRestauranentId() {
        return restauranentId;
    }

    public void setRestauranentId(Integer restauranentId) {
        this.restauranentId = restauranentId;
    }

    public String getRestauranentName() {
        return restauranentName;
    }

    public void setRestauranentName(String restauranentName) {
        this.restauranentName = restauranentName;
    }

    public String getRestauranentImage() {
        return restauranentImage;
    }

    public void setRestauranentImage(String restauranentImage) {
        this.restauranentImage = restauranentImage;
    }

    public List<RestauranentStyle> getRestauranentStyle() {
        return restauranentStyle;
    }

    public void setRestauranentStyle(List<RestauranentStyle> restauranentStyle) {
        this.restauranentStyle = restauranentStyle;
    }

    public List<Object> getRestauranentBranched() {
        return restauranentBranched;
    }

    public void setRestauranentBranched(List<Object> restauranentBranched) {
        this.restauranentBranched = restauranentBranched;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getRatingOutOf() {
        return ratingOutOf;
    }

    public void setRatingOutOf(String ratingOutOf) {
        this.ratingOutOf = ratingOutOf;
    }

    public String getAverageAvailbilityTime() {
        return averageAvailbilityTime;
    }

    public void setAverageAvailbilityTime(String averageAvailbilityTime) {
        this.averageAvailbilityTime = averageAvailbilityTime;
    }

    public String getAvailabilityTime() {
        return availabilityTime;
    }

    public void setAvailabilityTime(String availabilityTime) {
        this.availabilityTime = availabilityTime;
    }

    public String getAvailibilityText() {
        return availibilityText;
    }

    public void setAvailibilityText(String availibilityText) {
        this.availibilityText = availibilityText;
    }

    public Integer getFavouriteVisibility() {
        return favouriteVisibility;
    }

    public void setFavouriteVisibility(Integer favouriteVisibility) {
        this.favouriteVisibility = favouriteVisibility;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public String getCurrencyIsoCode() {
        return currencyIsoCode;
    }

    public void setCurrencyIsoCode(String currencyIsoCode) {
        this.currencyIsoCode = currencyIsoCode;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
