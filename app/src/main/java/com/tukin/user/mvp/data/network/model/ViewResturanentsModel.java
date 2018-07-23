package com.tukin.user.mvp.data.network.model;

import java.util.List;

/**
 * Created by lenovo on 4/23/2018.
 */

public class ViewResturanentsModel {


    /**
     * result : 1
     * message : Data grabbed Successfully
     * response : {"promotional_data":[{"promotional_id":"1","promotional_type":"","promotional_image":"public/images/banner/1525423516.png","promotional_medium_txt":"Promotion Data","promotional_small_txt":"","promotional_status":"1"},{"promotional_id":"2","promotional_type":"","promotional_image":"public/images/banner/1525423542.jpg","promotional_medium_txt":"Promotion Image","promotional_small_txt":"","promotional_status":"1"}],"scroller_all_data":[{"category":"4","category_id":"4","category_name":"Grocerry","category_image":"public/images/category/1525423571.jpg","category_icon":"public/images/category/icon1525423571.png","country":"","sates":"","cities":"","zip":"","category_status":"1","language_id":"1"},{"category":"5","category_id":"5","category_name":"Liquior","category_image":"public/images/category/1525423603.jpg","category_icon":"public/images/category/icon1525423603.png","country":"","sates":"","cities":"","zip":"","category_status":"1","language_id":"1"}]}
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
        private List<PromotionalDataBean> promotional_data;
        private List<ScrollerAllDataBean> scroller_all_data;

        public List<PromotionalDataBean> getPromotional_data() {
            return promotional_data;
        }

        public void setPromotional_data(List<PromotionalDataBean> promotional_data) {
            this.promotional_data = promotional_data;
        }

        public List<ScrollerAllDataBean> getScroller_all_data() {
            return scroller_all_data;
        }

        public void setScroller_all_data(List<ScrollerAllDataBean> scroller_all_data) {
            this.scroller_all_data = scroller_all_data;
        }

        public static class PromotionalDataBean {
            /**
             * promotional_id : 1
             * promotional_type :
             * promotional_image : public/images/banner/1525423516.png
             * promotional_medium_txt : Promotion Data
             * promotional_small_txt :
             * promotional_status : 1
             */

            private String promotional_id;
            private String promotional_type;
            private String promotional_image;
            private String promotional_medium_txt;
            private String promotional_small_txt;
            private String promotional_status;

            public String getPromotional_id() {
                return promotional_id;
            }

            public void setPromotional_id(String promotional_id) {
                this.promotional_id = promotional_id;
            }

            public String getPromotional_type() {
                return promotional_type;
            }

            public void setPromotional_type(String promotional_type) {
                this.promotional_type = promotional_type;
            }

            public String getPromotional_image() {
                return promotional_image;
            }

            public void setPromotional_image(String promotional_image) {
                this.promotional_image = promotional_image;
            }

            public String getPromotional_medium_txt() {
                return promotional_medium_txt;
            }

            public void setPromotional_medium_txt(String promotional_medium_txt) {
                this.promotional_medium_txt = promotional_medium_txt;
            }

            public String getPromotional_small_txt() {
                return promotional_small_txt;
            }

            public void setPromotional_small_txt(String promotional_small_txt) {
                this.promotional_small_txt = promotional_small_txt;
            }

            public String getPromotional_status() {
                return promotional_status;
            }

            public void setPromotional_status(String promotional_status) {
                this.promotional_status = promotional_status;
            }
        }

        public static class ScrollerAllDataBean {
            /**
             * category : 4
             * category_id : 4
             * category_name : Grocerry
             * category_image : public/images/category/1525423571.jpg
             * category_icon : public/images/category/icon1525423571.png
             * country :
             * sates :
             * cities :
             * zip :
             * category_status : 1
             * language_id : 1
             */

            private String category;
            private String category_id;
            private String category_name;
            private String category_image;
            private String category_icon;
            private String country;
            private String sates;
            private String cities;
            private String zip;
            private String category_status;
            private String language_id;

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getCategory_image() {
                return category_image;
            }

            public void setCategory_image(String category_image) {
                this.category_image = category_image;
            }

            public String getCategory_icon() {
                return category_icon;
            }

            public void setCategory_icon(String category_icon) {
                this.category_icon = category_icon;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getSates() {
                return sates;
            }

            public void setSates(String sates) {
                this.sates = sates;
            }

            public String getCities() {
                return cities;
            }

            public void setCities(String cities) {
                this.cities = cities;
            }

            public String getZip() {
                return zip;
            }

            public void setZip(String zip) {
                this.zip = zip;
            }

            public String getCategory_status() {
                return category_status;
            }

            public void setCategory_status(String category_status) {
                this.category_status = category_status;
            }

            public String getLanguage_id() {
                return language_id;
            }

            public void setLanguage_id(String language_id) {
                this.language_id = language_id;
            }
        }
    }
}