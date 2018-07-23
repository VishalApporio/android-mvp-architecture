package com.tukin.user.mvp.data.db.model;

import java.util.List;

/**
 * Created by lenovo on 5/5/2018.
 */

public class ViewCartResponse {


    /**
     * result : 1
     * message : Cart Details
     * response : {"restauranent_id":"4","restauranent_name":"Grocerry","restauranent_image":"public/images/category/1525423571.jpg","rating":4.35,"rating_out_of":"100+","average_availbility_time":"25-25 MIN","availability_time":"11:00 AM - 11:00 PM","availibility_text":"Open Now","favourite_visibility":0,"favourite":true,"currency_iso_code":"INR","currency_symbol":"+20B9","Total_Amount":600,"Products_Data":[{"product_id":"1","product_category":"4","product_subcategory":"1","product_name":"First","product_image":"public/images/products/1525430459.jpg","product_description":"Product Description","product_price":"100","product_quantity":"3","product_status":"1","sub_total":300},{"product_id":"2","product_category":"4","product_subcategory":"2","product_name":"Coke","product_image":"public/images/products/1525431103.png","product_description":"Coke Descriptiom","product_price":"100","product_quantity":"3","product_status":"1","sub_total":300}]}
     */

    private int result;
    private String message;
    private ResponseBean response;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseBean getResponse() {
        return response;
    }

    public void setResponse(ResponseBean response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * restauranent_id : 4
         * restauranent_name : Grocerry
         * restauranent_image : public/images/category/1525423571.jpg
         * rating : 4.35
         * rating_out_of : 100+
         * average_availbility_time : 25-25 MIN
         * availability_time : 11:00 AM - 11:00 PM
         * availibility_text : Open Now
         * favourite_visibility : 0
         * favourite : true
         * currency_iso_code : INR
         * currency_symbol : +20B9
         * Total_Amount : 600
         * Products_Data : [{"product_id":"1","product_category":"4","product_subcategory":"1","product_name":"First","product_image":"public/images/products/1525430459.jpg","product_description":"Product Description","product_price":"100","product_quantity":"3","product_status":"1","sub_total":300},{"product_id":"2","product_category":"4","product_subcategory":"2","product_name":"Coke","product_image":"public/images/products/1525431103.png","product_description":"Coke Descriptiom","product_price":"100","product_quantity":"3","product_status":"1","sub_total":300}]
         */

        private String restauranent_id;
        private String restauranent_name;
        private String restauranent_image;
        private double rating;
        private String rating_out_of;
        private String average_availbility_time;
        private String availability_time;
        private String availibility_text;
        private int favourite_visibility;
        private boolean favourite;
        private String currency_iso_code;
        private String currency_symbol;
        private int Total_Amount;
        private List<ProductsDataBean> Products_Data;

        public String getRestauranent_id() {
            return restauranent_id;
        }

        public void setRestauranent_id(String restauranent_id) {
            this.restauranent_id = restauranent_id;
        }

        public String getRestauranent_name() {
            return restauranent_name;
        }

        public void setRestauranent_name(String restauranent_name) {
            this.restauranent_name = restauranent_name;
        }

        public String getRestauranent_image() {
            return restauranent_image;
        }

        public void setRestauranent_image(String restauranent_image) {
            this.restauranent_image = restauranent_image;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getRating_out_of() {
            return rating_out_of;
        }

        public void setRating_out_of(String rating_out_of) {
            this.rating_out_of = rating_out_of;
        }

        public String getAverage_availbility_time() {
            return average_availbility_time;
        }

        public void setAverage_availbility_time(String average_availbility_time) {
            this.average_availbility_time = average_availbility_time;
        }

        public String getAvailability_time() {
            return availability_time;
        }

        public void setAvailability_time(String availability_time) {
            this.availability_time = availability_time;
        }

        public String getAvailibility_text() {
            return availibility_text;
        }

        public void setAvailibility_text(String availibility_text) {
            this.availibility_text = availibility_text;
        }

        public int getFavourite_visibility() {
            return favourite_visibility;
        }

        public void setFavourite_visibility(int favourite_visibility) {
            this.favourite_visibility = favourite_visibility;
        }

        public boolean isFavourite() {
            return favourite;
        }

        public void setFavourite(boolean favourite) {
            this.favourite = favourite;
        }

        public String getCurrency_iso_code() {
            return currency_iso_code;
        }

        public void setCurrency_iso_code(String currency_iso_code) {
            this.currency_iso_code = currency_iso_code;
        }

        public String getCurrency_symbol() {
            return currency_symbol;
        }

        public void setCurrency_symbol(String currency_symbol) {
            this.currency_symbol = currency_symbol;
        }

        public int getTotal_Amount() {
            return Total_Amount;
        }

        public void setTotal_Amount(int Total_Amount) {
            this.Total_Amount = Total_Amount;
        }

        public List<ProductsDataBean> getProducts_Data() {
            return Products_Data;
        }

        public void setProducts_Data(List<ProductsDataBean> Products_Data) {
            this.Products_Data = Products_Data;
        }

        public static class ProductsDataBean {
            /**
             * product_id : 1
             * product_category : 4
             * product_subcategory : 1
             * product_name : First
             * product_image : public/images/products/1525430459.jpg
             * product_description : Product Description
             * product_price : 100
             * product_quantity : 3
             * product_status : 1
             * sub_total : 300
             */

            private String product_id;
            private String product_category;
            private String product_subcategory;
            private String product_name;
            private String product_image;
            private String product_description;
            private String product_price;
            private String product_quantity;
            private String product_status;
            private int sub_total;

            public String getProduct_id() {
                return product_id;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
            }

            public String getProduct_category() {
                return product_category;
            }

            public void setProduct_category(String product_category) {
                this.product_category = product_category;
            }

            public String getProduct_subcategory() {
                return product_subcategory;
            }

            public void setProduct_subcategory(String product_subcategory) {
                this.product_subcategory = product_subcategory;
            }

            public String getProduct_name() {
                return product_name;
            }

            public void setProduct_name(String product_name) {
                this.product_name = product_name;
            }

            public String getProduct_image() {
                return product_image;
            }

            public void setProduct_image(String product_image) {
                this.product_image = product_image;
            }

            public String getProduct_description() {
                return product_description;
            }

            public void setProduct_description(String product_description) {
                this.product_description = product_description;
            }

            public String getProduct_price() {
                return product_price;
            }

            public void setProduct_price(String product_price) {
                this.product_price = product_price;
            }

            public String getProduct_quantity() {
                return product_quantity;
            }

            public void setProduct_quantity(String product_quantity) {
                this.product_quantity = product_quantity;
            }

            public String getProduct_status() {
                return product_status;
            }

            public void setProduct_status(String product_status) {
                this.product_status = product_status;
            }

            public int getSub_total() {
                return sub_total;
            }

            public void setSub_total(int sub_total) {
                this.sub_total = sub_total;
            }
        }
    }
}
