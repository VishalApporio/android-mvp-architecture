
package com.tukin.user.mvp.data.network.model.trackRideDriverDetails;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("coupon_code ")
    @Expose
    private String couponCode;
    @SerializedName("pickup_lat ")
    @Expose
    private String pickupLat;
    @SerializedName("pickup_long ")
    @Expose
    private String pickupLong;
    @SerializedName("pickup_location ")
    @Expose
    private String pickupLocation;
    @SerializedName("drop_lat ")
    @Expose
    private String dropLat;
    @SerializedName("drop_long ")
    @Expose
    private String dropLong;
    @SerializedName("drop_location ")
    @Expose
    private String dropLocation;
    @SerializedName("order_date ")
    @Expose
    private String orderDate;
    @SerializedName("order_time")
    @Expose
    private String orderTime;
    @SerializedName("last_time_stamp ")
    @Expose
    private String lastTimeStamp;
    @SerializedName("order_image")
    @Expose
    private String orderImage;
    @SerializedName("later_time")
    @Expose
    private String laterTime;
    @SerializedName("driver_id")
    @Expose
    private String driverId;
    @SerializedName("driver_name")
    @Expose
    private String driverName;
    @SerializedName("driver_email")
    @Expose
    private String driverEmail;
    @SerializedName("driver_phone")
    @Expose
    private String driverPhone;
    @SerializedName("later_date")
    @Expose
    private String laterDate;
    @SerializedName("order_type")
    @Expose
    private String orderType;
    @SerializedName("order_status")
    @Expose
    private String orderStatus;
    @SerializedName("driver_rating")
    @Expose
    private String driverRating;
    @SerializedName("user_rating ")
    @Expose
    private String userRating;
    @SerializedName("payment_status")
    @Expose
    private String paymentStatus;
    @SerializedName("reason_id")
    @Expose
    private String reasonId;
    @SerializedName("payment_option_id")
    @Expose
    private String paymentOptionId;
    @SerializedName("order_admin_status")
    @Expose
    private String orderAdminStatus;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("payment_option_name")
    @Expose
    private String paymentOptionName;
    @SerializedName("driver_request_time")
    @Expose
    private String driverRequestTime;
    @SerializedName("differenceInSeconds")
    @Expose
    private String differenceInSeconds;
    @SerializedName("user_image")
    @Expose
    private String userImage;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("user_phone")
    @Expose
    private String userPhone;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("arrived_time")
    @Expose
    private String arrivedTime;
    @SerializedName("begin_lat")
    @Expose
    private String beginLat;
    @SerializedName("begin_long")
    @Expose
    private String beginLong;
    @SerializedName("begin_location")
    @Expose
    private String beginLocation;
    @SerializedName("begin_time")
    @Expose
    private String beginTime;
    @SerializedName("end_lat")
    @Expose
    private String endLat;
    @SerializedName("end_long")
    @Expose
    private String endLong;
    @SerializedName("end_location")
    @Expose
    private String endLocation;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("total_amount")
    @Expose
    private Integer totalAmount;
    @SerializedName("done_order_time")
    @Expose
    private String doneOrderTime;
    @SerializedName("Orders_product_details")
    @Expose
    private List<OrdersProductDetail> ordersProductDetails = null;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getPickupLat() {
        return pickupLat;
    }

    public void setPickupLat(String pickupLat) {
        this.pickupLat = pickupLat;
    }

    public String getPickupLong() {
        return pickupLong;
    }

    public void setPickupLong(String pickupLong) {
        this.pickupLong = pickupLong;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropLat() {
        return dropLat;
    }

    public void setDropLat(String dropLat) {
        this.dropLat = dropLat;
    }

    public String getDropLong() {
        return dropLong;
    }

    public void setDropLong(String dropLong) {
        this.dropLong = dropLong;
    }

    public String getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(String dropLocation) {
        this.dropLocation = dropLocation;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getLastTimeStamp() {
        return lastTimeStamp;
    }

    public void setLastTimeStamp(String lastTimeStamp) {
        this.lastTimeStamp = lastTimeStamp;
    }

    public String getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(String orderImage) {
        this.orderImage = orderImage;
    }

    public String getLaterTime() {
        return laterTime;
    }

    public void setLaterTime(String laterTime) {
        this.laterTime = laterTime;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverEmail() {
        return driverEmail;
    }

    public void setDriverEmail(String driverEmail) {
        this.driverEmail = driverEmail;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getLaterDate() {
        return laterDate;
    }

    public void setLaterDate(String laterDate) {
        this.laterDate = laterDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(String driverRating) {
        this.driverRating = driverRating;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getReasonId() {
        return reasonId;
    }

    public void setReasonId(String reasonId) {
        this.reasonId = reasonId;
    }

    public String getPaymentOptionId() {
        return paymentOptionId;
    }

    public void setPaymentOptionId(String paymentOptionId) {
        this.paymentOptionId = paymentOptionId;
    }

    public String getOrderAdminStatus() {
        return orderAdminStatus;
    }

    public void setOrderAdminStatus(String orderAdminStatus) {
        this.orderAdminStatus = orderAdminStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentOptionName() {
        return paymentOptionName;
    }

    public void setPaymentOptionName(String paymentOptionName) {
        this.paymentOptionName = paymentOptionName;
    }

    public String getDriverRequestTime() {
        return driverRequestTime;
    }

    public void setDriverRequestTime(String driverRequestTime) {
        this.driverRequestTime = driverRequestTime;
    }

    public String getDifferenceInSeconds() {
        return differenceInSeconds;
    }

    public void setDifferenceInSeconds(String differenceInSeconds) {
        this.differenceInSeconds = differenceInSeconds;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getArrivedTime() {
        return arrivedTime;
    }

    public void setArrivedTime(String arrivedTime) {
        this.arrivedTime = arrivedTime;
    }

    public String getBeginLat() {
        return beginLat;
    }

    public void setBeginLat(String beginLat) {
        this.beginLat = beginLat;
    }

    public String getBeginLong() {
        return beginLong;
    }

    public void setBeginLong(String beginLong) {
        this.beginLong = beginLong;
    }

    public String getBeginLocation() {
        return beginLocation;
    }

    public void setBeginLocation(String beginLocation) {
        this.beginLocation = beginLocation;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndLat() {
        return endLat;
    }

    public void setEndLat(String endLat) {
        this.endLat = endLat;
    }

    public String getEndLong() {
        return endLong;
    }

    public void setEndLong(String endLong) {
        this.endLong = endLong;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDoneOrderTime() {
        return doneOrderTime;
    }

    public void setDoneOrderTime(String doneOrderTime) {
        this.doneOrderTime = doneOrderTime;
    }

    public List<OrdersProductDetail> getOrdersProductDetails() {
        return ordersProductDetails;
    }

    public void setOrdersProductDetails(List<OrdersProductDetail> ordersProductDetails) {
        this.ordersProductDetails = ordersProductDetails;
    }

}
