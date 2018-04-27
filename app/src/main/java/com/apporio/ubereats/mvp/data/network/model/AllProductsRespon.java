package com.apporio.ubereats.mvp.data.network.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 4/24/2018.
 */

public class AllProductsRespon {


    /**
     * result : 1
     * message : Restauranent products successfully found
     * response : {"restauranent_id":1,"restauranent_name":"Om Sweets, can be some bigger name as well","restauranent_image":"https://duyt4h9nfnj50.cloudfront.net/resized/302a413ea81cc026f7c1b97fdb3938eb-w550-09.jpg","restauranent_style":[{"style_id":1,"style_name":"North Indian"},{"style_id":4,"style_name":"South Indian"},{"style_id":8,"style_name":"Chinese"},{"style_id":13,"style_name":"Masala"},{"style_id":12,"style_name":"Italian"}],"restauranent_branched":[],"rating":4.35,"rating_out_of":"100+","average_availbility_time":"25-25 MIN","availability_time":"11:00 AM - 11:00 PM","availibility_text":"Open Now","favourite_visibility":0,"favourite":true,"currency_iso_code":"INR","currency_symbol":"+20B9","categories":[{"category_id":1,"category_name":"Combos","category_description":"some description about this catogory here.","category_products":[{"product_id":45,"product_name":"Chole Chawal.","product_image":"https://duyt4h9nfnj50.cloudfront.net/resized/5100a59\u2026-w550-e4.jpg","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":true,"vergetarial_text":"vegetarian","in_stock":"","product_price":145,"selectors":[{"selector_type":"checkbox","selector_name":"Choise of chrust","mandatory":true,"selector_data":[{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""},{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""}]},{"selector_type":"checkbox","selector_name":"Choise of dips","mandatory":true,"selector_data":[{"product_id":50,"product_name":"Spicy Tomato and Basil","product_availability":true,"product_price":"+40"},{"product_id":52,"product_name":"Tartare Sauce","product_availability":true,"product_price":"-20"},{"product_id":42,"product_name":"Agilo Mayonaise","product_availability":true,"product_price":"+20"}]},{"selector_type":"radio","selector_name":"Choise of Cofee flask","mandatory":true,"selector_data":[{"product_id":60,"product_name":"Filter Coffee Uniflask","product_availability":true,"product_price":""},{"product_id":62,"product_name":"Filter Coffee Mini Flask","product_availability":true,"product_price":"+50.00"},{"product_id":92,"product_name":"Filter Coffee Flask","product_availability":true,"product_price":"+110"}]}]},{"product_id":45,"product_name":"Chole Chawal.","product_image":"https://duyt4h9nfnj50.cloudfront.net/resized/5100a59\u2026-w550-e4.jpg","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":false,"vergetarial_text":"non-vegetarian","in_stock":"","product_price":145,"selectors":[{"selector_type":"checkbox","selector_name":"Choise of chrust","mandatory":true,"selector_data":[{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""},{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""}]},{"selector_type":"checkbox","selector_name":"Choise of dips","mandatory":true,"selector_data":[{"product_id":50,"product_name":"Spicy Tomato and Basil","product_availability":true,"product_price":"+40"},{"product_id":52,"product_name":"Tartare Sauce","product_availability":true,"product_price":"-20"},{"product_id":42,"product_name":"Agilo Mayonaise","product_availability":true,"product_price":"+20"}]},{"selector_type":"radio","selector_name":"Choise of Cofee flask","mandatory":true,"selector_data":[{"product_id":60,"product_name":"Filter Coffee Uniflask","product_availability":true,"product_price":""},{"product_id":62,"product_name":"Filter Coffee Mini Flask","product_availability":true,"product_price":"+50.00"},{"product_id":92,"product_name":"Filter Coffee Flask","product_availability":true,"product_price":"+110"}]}]},{"product_id":45,"product_name":"Chole Chawal.","product_image":"https://duyt4h9nfnj50.cloudfront.net/resized/5100a59\u2026-w550-e4.jpg","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":true,"vergetarial_text":"vegetarian","in_stock":"","product_price":145,"selectors":[{"selector_type":"checkbox","selector_name":"Choise of chrust","mandatory":true,"selector_data":[{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""},{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""}]},{"selector_type":"checkbox","selector_name":"Choise of dips","mandatory":true,"selector_data":[{"product_id":50,"product_name":"Spicy Tomato and Basil","product_availability":true,"product_price":"+40"},{"product_id":52,"product_name":"Tartare Sauce","product_availability":true,"product_price":"-20"},{"product_id":42,"product_name":"Agilo Mayonaise","product_availability":true,"product_price":"+20"}]},{"selector_type":"radio","selector_name":"Choise of Cofee flask","mandatory":true,"selector_data":[{"product_id":60,"product_name":"Filter Coffee Uniflask","product_availability":true,"product_price":""},{"product_id":62,"product_name":"Filter Coffee Mini Flask","product_availability":true,"product_price":"+50.00"},{"product_id":92,"product_name":"Filter Coffee Flask","product_availability":true,"product_price":"+110"}]}]}]},{"category_id":2,"category_name":"All day breakfast","category_description":"some description about this catogory here.","category_products":[{"product_id":65,"product_name":"Bombay masala Sandwich","product_image":"http://www.sailusfood.com/wp-content/uploads/2010/11/iyengar-bakery-toast.jpg","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":false,"vergetarial_text":"non-vegetarian","in_stock":"30","product_price":89,"selectors":[]},{"product_id":45,"product_name":"Chinese Poha.","product_image":"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBz2MDPboA0SDKNV4egxas-m5Jwle5Vdaxc5OANE7rJMso2k8Q","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":true,"vergetarial_text":"vegetarian","in_stock":"4","product_price":145,"selectors":[]},{"product_id":425,"product_name":"Parsi eg sandwich","product_image":"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHl-9n-N85G1lZsVdbPKn-7pKJ2sC5GpLYNF2ZLlYMVsofsX5O","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":true,"vergetarial_text":"vegetarian","in_stock":"","product_price":55,"selectors":[]}]}]}
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
         * restauranent_id : 1
         * restauranent_name : Om Sweets, can be some bigger name as well
         * restauranent_image : https://duyt4h9nfnj50.cloudfront.net/resized/302a413ea81cc026f7c1b97fdb3938eb-w550-09.jpg
         * restauranent_style : [{"style_id":1,"style_name":"North Indian"},{"style_id":4,"style_name":"South Indian"},{"style_id":8,"style_name":"Chinese"},{"style_id":13,"style_name":"Masala"},{"style_id":12,"style_name":"Italian"}]
         * restauranent_branched : []
         * rating : 4.35
         * rating_out_of : 100+
         * average_availbility_time : 25-25 MIN
         * availability_time : 11:00 AM - 11:00 PM
         * availibility_text : Open Now
         * favourite_visibility : 0
         * favourite : true
         * currency_iso_code : INR
         * currency_symbol : +20B9
         * categories : [{"category_id":1,"category_name":"Combos","category_description":"some description about this catogory here.","category_products":[{"product_id":45,"product_name":"Chole Chawal.","product_image":"https://duyt4h9nfnj50.cloudfront.net/resized/5100a59\u2026-w550-e4.jpg","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":true,"vergetarial_text":"vegetarian","in_stock":"","product_price":145,"selectors":[{"selector_type":"checkbox","selector_name":"Choise of chrust","mandatory":true,"selector_data":[{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""},{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""}]},{"selector_type":"checkbox","selector_name":"Choise of dips","mandatory":true,"selector_data":[{"product_id":50,"product_name":"Spicy Tomato and Basil","product_availability":true,"product_price":"+40"},{"product_id":52,"product_name":"Tartare Sauce","product_availability":true,"product_price":"-20"},{"product_id":42,"product_name":"Agilo Mayonaise","product_availability":true,"product_price":"+20"}]},{"selector_type":"radio","selector_name":"Choise of Cofee flask","mandatory":true,"selector_data":[{"product_id":60,"product_name":"Filter Coffee Uniflask","product_availability":true,"product_price":""},{"product_id":62,"product_name":"Filter Coffee Mini Flask","product_availability":true,"product_price":"+50.00"},{"product_id":92,"product_name":"Filter Coffee Flask","product_availability":true,"product_price":"+110"}]}]},{"product_id":45,"product_name":"Chole Chawal.","product_image":"https://duyt4h9nfnj50.cloudfront.net/resized/5100a59\u2026-w550-e4.jpg","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":false,"vergetarial_text":"non-vegetarian","in_stock":"","product_price":145,"selectors":[{"selector_type":"checkbox","selector_name":"Choise of chrust","mandatory":true,"selector_data":[{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""},{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""}]},{"selector_type":"checkbox","selector_name":"Choise of dips","mandatory":true,"selector_data":[{"product_id":50,"product_name":"Spicy Tomato and Basil","product_availability":true,"product_price":"+40"},{"product_id":52,"product_name":"Tartare Sauce","product_availability":true,"product_price":"-20"},{"product_id":42,"product_name":"Agilo Mayonaise","product_availability":true,"product_price":"+20"}]},{"selector_type":"radio","selector_name":"Choise of Cofee flask","mandatory":true,"selector_data":[{"product_id":60,"product_name":"Filter Coffee Uniflask","product_availability":true,"product_price":""},{"product_id":62,"product_name":"Filter Coffee Mini Flask","product_availability":true,"product_price":"+50.00"},{"product_id":92,"product_name":"Filter Coffee Flask","product_availability":true,"product_price":"+110"}]}]},{"product_id":45,"product_name":"Chole Chawal.","product_image":"https://duyt4h9nfnj50.cloudfront.net/resized/5100a59\u2026-w550-e4.jpg","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":true,"vergetarial_text":"vegetarian","in_stock":"","product_price":145,"selectors":[{"selector_type":"checkbox","selector_name":"Choise of chrust","mandatory":true,"selector_data":[{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""},{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""}]},{"selector_type":"checkbox","selector_name":"Choise of dips","mandatory":true,"selector_data":[{"product_id":50,"product_name":"Spicy Tomato and Basil","product_availability":true,"product_price":"+40"},{"product_id":52,"product_name":"Tartare Sauce","product_availability":true,"product_price":"-20"},{"product_id":42,"product_name":"Agilo Mayonaise","product_availability":true,"product_price":"+20"}]},{"selector_type":"radio","selector_name":"Choise of Cofee flask","mandatory":true,"selector_data":[{"product_id":60,"product_name":"Filter Coffee Uniflask","product_availability":true,"product_price":""},{"product_id":62,"product_name":"Filter Coffee Mini Flask","product_availability":true,"product_price":"+50.00"},{"product_id":92,"product_name":"Filter Coffee Flask","product_availability":true,"product_price":"+110"}]}]}]},{"category_id":2,"category_name":"All day breakfast","category_description":"some description about this catogory here.","category_products":[{"product_id":65,"product_name":"Bombay masala Sandwich","product_image":"http://www.sailusfood.com/wp-content/uploads/2010/11/iyengar-bakery-toast.jpg","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":false,"vergetarial_text":"non-vegetarian","in_stock":"30","product_price":89,"selectors":[]},{"product_id":45,"product_name":"Chinese Poha.","product_image":"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRBz2MDPboA0SDKNV4egxas-m5Jwle5Vdaxc5OANE7rJMso2k8Q","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":true,"vergetarial_text":"vegetarian","in_stock":"4","product_price":145,"selectors":[]},{"product_id":425,"product_name":"Parsi eg sandwich","product_image":"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHl-9n-N85G1lZsVdbPKn-7pKJ2sC5GpLYNF2ZLlYMVsofsX5O","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":true,"vergetarial_text":"vegetarian","in_stock":"","product_price":55,"selectors":[]}]}]
         */

        private int restauranent_id;
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
        private List<RestauranentStyleBean> restauranent_style;
        private List<?> restauranent_branched;
        private List<CategoriesBean> categories;

        public int getRestauranent_id() {
            return restauranent_id;
        }

        public void setRestauranent_id(int restauranent_id) {
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

        public List<RestauranentStyleBean> getRestauranent_style() {
            return restauranent_style;
        }

        public void setRestauranent_style(List<RestauranentStyleBean> restauranent_style) {
            this.restauranent_style = restauranent_style;
        }

        public List<?> getRestauranent_branched() {
            return restauranent_branched;
        }

        public void setRestauranent_branched(List<?> restauranent_branched) {
            this.restauranent_branched = restauranent_branched;
        }

        public List<CategoriesBean> getCategories() {
            return categories;
        }

        public void setCategories(List<CategoriesBean> categories) {
            this.categories = categories;
        }

        public static class RestauranentStyleBean {
            /**
             * style_id : 1
             * style_name : North Indian
             */

            private int style_id;
            private String style_name;

            public int getStyle_id() {
                return style_id;
            }

            public void setStyle_id(int style_id) {
                this.style_id = style_id;
            }

            public String getStyle_name() {
                return style_name;
            }

            public void setStyle_name(String style_name) {
                this.style_name = style_name;
            }
        }

        public static class CategoriesBean {
            /**
             * category_id : 1
             * category_name : Combos
             * category_description : some description about this catogory here.
             * category_products : [{"product_id":45,"product_name":"Chole Chawal.","product_image":"https://duyt4h9nfnj50.cloudfront.net/resized/5100a59\u2026-w550-e4.jpg","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":true,"vergetarial_text":"vegetarian","in_stock":"","product_price":145,"selectors":[{"selector_type":"checkbox","selector_name":"Choise of chrust","mandatory":true,"selector_data":[{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""},{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""}]},{"selector_type":"checkbox","selector_name":"Choise of dips","mandatory":true,"selector_data":[{"product_id":50,"product_name":"Spicy Tomato and Basil","product_availability":true,"product_price":"+40"},{"product_id":52,"product_name":"Tartare Sauce","product_availability":true,"product_price":"-20"},{"product_id":42,"product_name":"Agilo Mayonaise","product_availability":true,"product_price":"+20"}]},{"selector_type":"radio","selector_name":"Choise of Cofee flask","mandatory":true,"selector_data":[{"product_id":60,"product_name":"Filter Coffee Uniflask","product_availability":true,"product_price":""},{"product_id":62,"product_name":"Filter Coffee Mini Flask","product_availability":true,"product_price":"+50.00"},{"product_id":92,"product_name":"Filter Coffee Flask","product_availability":true,"product_price":"+110"}]}]},{"product_id":45,"product_name":"Chole Chawal.","product_image":"https://duyt4h9nfnj50.cloudfront.net/resized/5100a59\u2026-w550-e4.jpg","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":false,"vergetarial_text":"non-vegetarian","in_stock":"","product_price":145,"selectors":[{"selector_type":"checkbox","selector_name":"Choise of chrust","mandatory":true,"selector_data":[{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""},{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""}]},{"selector_type":"checkbox","selector_name":"Choise of dips","mandatory":true,"selector_data":[{"product_id":50,"product_name":"Spicy Tomato and Basil","product_availability":true,"product_price":"+40"},{"product_id":52,"product_name":"Tartare Sauce","product_availability":true,"product_price":"-20"},{"product_id":42,"product_name":"Agilo Mayonaise","product_availability":true,"product_price":"+20"}]},{"selector_type":"radio","selector_name":"Choise of Cofee flask","mandatory":true,"selector_data":[{"product_id":60,"product_name":"Filter Coffee Uniflask","product_availability":true,"product_price":""},{"product_id":62,"product_name":"Filter Coffee Mini Flask","product_availability":true,"product_price":"+50.00"},{"product_id":92,"product_name":"Filter Coffee Flask","product_availability":true,"product_price":"+110"}]}]},{"product_id":45,"product_name":"Chole Chawal.","product_image":"https://duyt4h9nfnj50.cloudfront.net/resized/5100a59\u2026-w550-e4.jpg","product_description":"some basic informationm about product can be a html as well if there is need to show somem bullet points ","vergetarial":true,"vergetarial_text":"vegetarian","in_stock":"","product_price":145,"selectors":[{"selector_type":"checkbox","selector_name":"Choise of chrust","mandatory":true,"selector_data":[{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""},{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""}]},{"selector_type":"checkbox","selector_name":"Choise of dips","mandatory":true,"selector_data":[{"product_id":50,"product_name":"Spicy Tomato and Basil","product_availability":true,"product_price":"+40"},{"product_id":52,"product_name":"Tartare Sauce","product_availability":true,"product_price":"-20"},{"product_id":42,"product_name":"Agilo Mayonaise","product_availability":true,"product_price":"+20"}]},{"selector_type":"radio","selector_name":"Choise of Cofee flask","mandatory":true,"selector_data":[{"product_id":60,"product_name":"Filter Coffee Uniflask","product_availability":true,"product_price":""},{"product_id":62,"product_name":"Filter Coffee Mini Flask","product_availability":true,"product_price":"+50.00"},{"product_id":92,"product_name":"Filter Coffee Flask","product_availability":true,"product_price":"+110"}]}]}]
             */

            private int category_id;
            private String category_name;
            private String category_description;
            private List<CategoryProductsBean> category_products;

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getCategory_description() {
                return category_description;
            }

            public void setCategory_description(String category_description) {
                this.category_description = category_description;
            }

            public List<CategoryProductsBean> getCategory_products() {
                return category_products;
            }

            public void setCategory_products(List<CategoryProductsBean> category_products) {
                this.category_products = category_products;
            }

            public static class CategoryProductsBean implements Serializable {
                /**
                 * product_id : 45
                 * product_name : Chole Chawal.
                 * product_image : https://duyt4h9nfnj50.cloudfront.net/resized/5100a59…-w550-e4.jpg
                 * product_description : some basic informationm about product can be a html as well if there is need to show somem bullet points
                 * vergetarial : true
                 * vergetarial_text : vegetarian
                 * in_stock :
                 * product_price : 145
                 * selectors : [{"selector_type":"checkbox","selector_name":"Choise of chrust","mandatory":true,"selector_data":[{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""},{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""}]},{"selector_type":"checkbox","selector_name":"Choise of dips","mandatory":true,"selector_data":[{"product_id":50,"product_name":"Spicy Tomato and Basil","product_availability":true,"product_price":"+40"},{"product_id":52,"product_name":"Tartare Sauce","product_availability":true,"product_price":"-20"},{"product_id":42,"product_name":"Agilo Mayonaise","product_availability":true,"product_price":"+20"}]},{"selector_type":"radio","selector_name":"Choise of Cofee flask","mandatory":true,"selector_data":[{"product_id":60,"product_name":"Filter Coffee Uniflask","product_availability":true,"product_price":""},{"product_id":62,"product_name":"Filter Coffee Mini Flask","product_availability":true,"product_price":"+50.00"},{"product_id":92,"product_name":"Filter Coffee Flask","product_availability":true,"product_price":"+110"}]}]
                 */

                private int product_id;
                private String product_name;
                private String product_image;
                private String product_description;
                private boolean vergetarial;
                private String vergetarial_text;
                private String in_stock;
                private int product_price;
                private List<SelectorsBean> selectors;

                public int getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(int product_id) {
                    this.product_id = product_id;
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

                public boolean isVergetarial() {
                    return vergetarial;
                }

                public void setVergetarial(boolean vergetarial) {
                    this.vergetarial = vergetarial;
                }

                public String getVergetarial_text() {
                    return vergetarial_text;
                }

                public void setVergetarial_text(String vergetarial_text) {
                    this.vergetarial_text = vergetarial_text;
                }

                public String getIn_stock() {
                    return in_stock;
                }

                public void setIn_stock(String in_stock) {
                    this.in_stock = in_stock;
                }

                public int getProduct_price() {
                    return product_price;
                }

                public void setProduct_price(int product_price) {
                    this.product_price = product_price;
                }

                public List<SelectorsBean> getSelectors() {
                    return selectors;
                }

                public void setSelectors(List<SelectorsBean> selectors) {
                    this.selectors = selectors;
                }

                public static class SelectorsBean {
                    /**
                     * selector_type : checkbox
                     * selector_name : Choise of chrust
                     * mandatory : true
                     * selector_data : [{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""},{"product_id":55,"product_name":"Regular Chrust","product_availability":true,"product_price":""}]
                     */

                    private String selector_type;
                    private String selector_name;
                    private boolean mandatory;
                    private List<SelectorDataBean> selector_data;

                    public String getSelector_type() {
                        return selector_type;
                    }

                    public void setSelector_type(String selector_type) {
                        this.selector_type = selector_type;
                    }

                    public String getSelector_name() {
                        return selector_name;
                    }

                    public void setSelector_name(String selector_name) {
                        this.selector_name = selector_name;
                    }

                    public boolean isMandatory() {
                        return mandatory;
                    }

                    public void setMandatory(boolean mandatory) {
                        this.mandatory = mandatory;
                    }

                    public List<SelectorDataBean> getSelector_data() {
                        return selector_data;
                    }

                    public void setSelector_data(List<SelectorDataBean> selector_data) {
                        this.selector_data = selector_data;
                    }

                    public static class SelectorDataBean {
                        /**
                         * product_id : 55
                         * product_name : Regular Chrust
                         * product_availability : true
                         * product_price :
                         */

                        private int product_id;
                        private String product_name;
                        private boolean product_availability;
                        private String product_price;

                        public int getProduct_id() {
                            return product_id;
                        }

                        public void setProduct_id(int product_id) {
                            this.product_id = product_id;
                        }

                        public String getProduct_name() {
                            return product_name;
                        }

                        public void setProduct_name(String product_name) {
                            this.product_name = product_name;
                        }

                        public boolean isProduct_availability() {
                            return product_availability;
                        }

                        public void setProduct_availability(boolean product_availability) {
                            this.product_availability = product_availability;
                        }

                        public String getProduct_price() {
                            return product_price;
                        }

                        public void setProduct_price(String product_price) {
                            this.product_price = product_price;
                        }
                    }
                }
            }
        }
    }
}