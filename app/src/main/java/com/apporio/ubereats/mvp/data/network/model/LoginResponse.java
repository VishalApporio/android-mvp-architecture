/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.apporio.ubereats.mvp.data.network.model;

/**
 * Created by janisharali on 08/01/17.
 */

public class LoginResponse {


    /**
     * result : 1
     * message : Login successfully!
     * response : {"user_id":234,"user_first_name":"vishal","user_last_name":"garg","user_email":"vishal@apporio.com","user_phone":"9898776756","user_image":"http://www.lovemarks.com/wp-content/uploads/profile-avatars/default-avatar-business-bear.png","country_code_id":2,"country_code_value":"91","country_code_name":"India","login_type":1,"session_token":"223jdiuijrekiu78i_pp09_AASDzzr4+9090"}
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
         * user_id : 234
         * user_first_name : vishal
         * user_last_name : garg
         * user_email : vishal@apporio.com
         * user_phone : 9898776756
         * user_image : http://www.lovemarks.com/wp-content/uploads/profile-avatars/default-avatar-business-bear.png
         * country_code_id : 2
         * country_code_value : 91
         * country_code_name : India
         * login_type : 1
         * session_token : 223jdiuijrekiu78i_pp09_AASDzzr4+9090
         */

        private Long user_id;
        private String user_first_name;
        private String user_last_name;
        private String user_email;
        private String user_phone;
        private String user_image;
        private int country_code_id;
        private String country_code_value;
        private String country_code_name;
        private int login_type;
        private String session_token;

        public Long getUser_id() {
            return user_id;
        }

        public void setUser_id(Long user_id) {
            this.user_id = user_id;
        }

        public String getUser_first_name() {
            return user_first_name;
        }

        public void setUser_first_name(String user_first_name) {
            this.user_first_name = user_first_name;
        }

        public String getUser_last_name() {
            return user_last_name;
        }

        public void setUser_last_name(String user_last_name) {
            this.user_last_name = user_last_name;
        }

        public String getUser_email() {
            return user_email;
        }

        public void setUser_email(String user_email) {
            this.user_email = user_email;
        }

        public String getUser_phone() {
            return user_phone;
        }

        public void setUser_phone(String user_phone) {
            this.user_phone = user_phone;
        }

        public String getUser_image() {
            return user_image;
        }

        public void setUser_image(String user_image) {
            this.user_image = user_image;
        }

        public int getCountry_code_id() {
            return country_code_id;
        }

        public void setCountry_code_id(int country_code_id) {
            this.country_code_id = country_code_id;
        }

        public String getCountry_code_value() {
            return country_code_value;
        }

        public void setCountry_code_value(String country_code_value) {
            this.country_code_value = country_code_value;
        }

        public String getCountry_code_name() {
            return country_code_name;
        }

        public void setCountry_code_name(String country_code_name) {
            this.country_code_name = country_code_name;
        }

        public int getLogin_type() {
            return login_type;
        }

        public void setLogin_type(int login_type) {
            this.login_type = login_type;
        }

        public String getSession_token() {
            return session_token;
        }

        public void setSession_token(String session_token) {
            this.session_token = session_token;
        }
    }
}