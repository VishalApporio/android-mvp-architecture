

package com.apporio.ubereats.mvp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vishal@apporio.com on 08/01/17.
 */

public class LoginRequest {

    private LoginRequest() {
        // This class is not publicly instantiable
    }

    public static class ServerLoginRequest {

        @Expose
        @SerializedName("email")
        private String email;

        @Expose
        @SerializedName("password")
        private String password;

        public ServerLoginRequest(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            ServerLoginRequest that = (ServerLoginRequest) object;

            if (email != null ? !email.equals(that.email) : that.email != null) return false;
            return password != null ? password.equals(that.password) : that.password == null;

        }

        @Override
        public int hashCode() {
            int result = email != null ? email.hashCode() : 0;
            result = 31 * result + (password != null ? password.hashCode() : 0);
            return result;
        }
    }

    public static class ServerRegisterRequest {

        @Expose
        @SerializedName("first_name")
        private String first_name;

        @Expose
        @SerializedName("last_name")
        private String last_name;

        @Expose
        @SerializedName("email")
        private String email;

        @Expose
        @SerializedName("phone_no")
        private String phone_no;

        @Expose
        @SerializedName("password")
        private String password;

        public ServerRegisterRequest(String first_name,String last_name,String email,String phone_no, String password) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;
            this.phone_no = phone_no;
            this.password = password;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone_no() {
            return phone_no;
        }

        public void setPhone_no(String phone_no) {
            this.phone_no = phone_no;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            ServerRegisterRequest that = (ServerRegisterRequest) object;

            if (first_name != null ? !first_name.equals(that.first_name) : that.first_name != null) return false;
            if (last_name != null ? !last_name.equals(that.last_name) : that.last_name != null) return false;
            if (email != null ? !email.equals(that.email) : that.email != null) return false;
            if (phone_no != null ? !phone_no.equals(that.phone_no) : that.phone_no != null) return false;
            return password != null ? password.equals(that.password) : that.password == null;

        }
    }

    public static class GoogleLoginRequest {
        @Expose
        @SerializedName("google_user_id")
        private String googleUserId;

        @Expose
        @SerializedName("google_id_token")
        private String idToken;

        public GoogleLoginRequest(String googleUserId, String idToken) {
            this.googleUserId = googleUserId;
            this.idToken = idToken;
        }

        public String getGoogleUserId() {
            return googleUserId;
        }

        public void setGoogleUserId(String googleUserId) {
            this.googleUserId = googleUserId;
        }

        public String getIdToken() {
            return idToken;
        }

        public void setIdToken(String idToken) {
            this.idToken = idToken;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            GoogleLoginRequest that = (GoogleLoginRequest) object;

            if (googleUserId != null ? !googleUserId.equals(that.googleUserId)
                    : that.googleUserId != null)
                return false;
            return idToken != null ? idToken.equals(that.idToken) : that.idToken == null;

        }

        @Override
        public int hashCode() {
            int result = googleUserId != null ? googleUserId.hashCode() : 0;
            result = 31 * result + (idToken != null ? idToken.hashCode() : 0);
            return result;
        }
    }

    public static class FacebookLoginRequest {
        @Expose
        @SerializedName("fb_user_id")
        private String fbUserId;

        @Expose
        @SerializedName("fb_access_token")
        private String fbAccessToken;

        public FacebookLoginRequest(String fbUserId, String fbAccessToken) {
            this.fbUserId = fbUserId;
            this.fbAccessToken = fbAccessToken;
        }

        public String getFbUserId() {
            return fbUserId;
        }

        public void setFbUserId(String fbUserId) {
            this.fbUserId = fbUserId;
        }

        public String getFbAccessToken() {
            return fbAccessToken;
        }

        public void setFbAccessToken(String fbAccessToken) {
            this.fbAccessToken = fbAccessToken;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;

            FacebookLoginRequest that = (FacebookLoginRequest) object;

            if (fbUserId != null ? !fbUserId.equals(that.fbUserId) : that.fbUserId != null)
                return false;
            return fbAccessToken != null ? fbAccessToken.equals(that.fbAccessToken)
                    : that.fbAccessToken == null;

        }

        @Override
        public int hashCode() {
            int result = fbUserId != null ? fbUserId.hashCode() : 0;
            result = 31 * result + (fbAccessToken != null ? fbAccessToken.hashCode() : 0);
            return result;
        }
    }
}
