package com.tukin.user.mvp.data.network.model;

import java.util.List;

/**
 * Created by lenovo on 4/21/2018.
 */

public class GetLocationsModelClass {

    /**
     * html_attributions : []
     * result : {"address_components":[{"long_name":"Gurugram","short_name":"Gurugram","types":["locality","political"]},{"long_name":"Sector 29","short_name":"Sector 29","types":["sublocality_level_1","sublocality","political"]},{"long_name":"Gurgaon","short_name":"Gurgaon","types":["administrative_area_level_2","political"]},{"long_name":"Haryana","short_name":"HR","types":["administrative_area_level_1","political"]},{"long_name":"India","short_name":"IN","types":["country","political"]},{"long_name":"122007","short_name":"122007","types":["postal_code"]}],"adr_address":"Delhi, <span class=\"street-address\">Sector 29<\/span>, <span class=\"locality\">Gurugram<\/span>, <span class=\"region\">Haryana<\/span> <span class=\"postal-code\">122007<\/span>, <span class=\"country-name\">India<\/span>","formatted_address":"Delhi, Sector 29, Gurugram, Haryana 122007, India","geometry":{"location":{"lat":28.4592693,"lng":77.0724192},"viewport":{"northeast":{"lat":28.4606182802915,"lng":77.0737681802915},"southwest":{"lat":28.4579203197085,"lng":77.07107021970849}}},"icon":"https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png","id":"a2be6e7e6c85467500d81113d6100f78df7530ac","name":"Shalimar Huda City Center","photos":[{"height":2304,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/108956928207460108038/photos\">Anurag Thakur<\/a>"],"photo_reference":"CmRaAAAAb-UF6wA_TOSPKfidda5fvqXUS6ppnWM4MCcDgaXDuABnLz3lAhpjAroQhPrE9m4_xnj55-0cNDupSuI8goc3E2e-iBgQUJg9xMvBxqIZdO_6EOidxIX7BaUeMzxuFc4vEhCV4fK1q2Nl3kDXtj64O9d5GhQXZZGAj7BX_znerPNkHbGyYoyE0Q","width":4096},{"height":3096,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/116759507233193626176/photos\">ଗୌର ଗୋପାଳ<\/a>"],"photo_reference":"CmRaAAAAIr9KzMvuRo0eLqd92W_nY_UQjjl8UdkDuFDn2-FoWVB8cvjwKBTuFiH-_qZ9kn2wi4nPMSmXBANMBygg7fLDfdKKfuUNInTDr02Xgu414InlajQ5KyGaVEFj9cPe3Lb3EhDWtO0yP_x855pdQj69j63FGhQtufVfOGAvv1fpFL1lbXXRbkGwZA","width":4128},{"height":1080,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/114315319987761387838/photos\">Rahul Kumar<\/a>"],"photo_reference":"CmRaAAAABzIyTe7FsuBhOJu_H1_4N6Fzb1Z4wMRDcXxKyEinBanaEH-vYvHWnvKig8sCN2Iw2eZsTVn7YwdwVFvtsyD1rZT4h7xeG2R8_DnCTF1WpZf34XV1sS4u90VGTFR4n2ATEhCNdu4tkQqWXJH-09ACovR6GhSaLYs9Ccrt3Uq_c207ouWENC15jg","width":1080},{"height":3120,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/105275058795600989431/photos\">pradeep kumar<\/a>"],"photo_reference":"CmRaAAAAydTAuenMSgzy8j2a3NsiZTZi1egA9z2m8anZ-iiGmdeCRFv3Yz34G5P7VHe5rxCuVgBDQGO_R8uSj7EBXR3H-5bUgkhiKtmHJsEFBjOOFttyvAiDKogrxJ5O7_jGy49eEhDpuSTjyM05WCkO4VPxnr8aGhSpgTeQHgOv0PwuwwR35oRNAPDqaA","width":4160},{"height":3096,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/103181697640655131152/photos\">Srishti Sarawagi<\/a>"],"photo_reference":"CmRaAAAARVQvFZ0FssTFDyHxL4SbUTUpTtAnfiSYTpXXg1az_ndKFpC5-SOZ0Vcr1s77UJlrrRAgcY3w6MT9iATusngmbcj7GeNHyZ-aUM3c_CTKW-LV8TLVvFeUBNM0FqGk33GYEhCmqAWJY6uybTn20aoWrEZhGhQVKHhwIuhgX_HcYZOUvduA_L3gqg","width":4128},{"height":2400,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/111296534101156358814/photos\">Aman Deep<\/a>"],"photo_reference":"CmRaAAAADiSswaYbJ84KCa4vCAWQJsKPPsAcF8Nbpe0vFwb1v9KWZnLX1uwWaGfmQ3QsBQzSEcmlYSHp28GMNlWaQJsV2-2DA2YqP50NnNnyeJKL2vblqqpbVfTFhkIDg_gTfTOkEhDX3vSZobYNG2EEHF1KnY3BGhTxdsuT3r_nBv_XuIW44Yx4woMwtg","width":3200},{"height":900,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/111558997245801229699/photos\">yogendra sahu<\/a>"],"photo_reference":"CmRaAAAA4AJ1ym2HneazEmHhHwM8KEHQDzzz5838TZ32MRZudUG5JRXZoiqgzQ5Ao6XskhpB-OBmuBmfgs_xZC3FA2FUiPVYK3LH1pN8LDm5NQKh5FzG8junba7yBu_kD8leIhB7EhCVKdij5qmkIsxEMwpG9nl8GhTnOBQDSfZoBKylrp_KvIhqOO-StA","width":1600},{"height":3120,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/114305203585357317930/photos\">Parvez Khan<\/a>"],"photo_reference":"CmRZAAAASaGyVnWzuALiCo24OjS52QMblJcG_ITSAyDTsSumj7RmnoheYoCEdHjR-oZIh8C-frbFglogJDjAFn2au-ianC8bJ4i1xyUnLG-ya6T9whlRKQ6X9b1KFusbSTjpvqudEhB8GJMBepKCI9-nSvm_uZy4GhSiO34GZexucIidUuJ8I_Cr-Gby4g","width":4160},{"height":2448,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/111271819053656960972/photos\">Aman Dhayal<\/a>"],"photo_reference":"CmRaAAAAnvKF50Osnhq1SvUvYzWn-LyOUUdo_6FqNWySostfXIPael_RBP1GnS_Oc9rfhLcZInUKjl9YPD8DrYpNzwQeERP7BwfV5hDaZ3Vhkrf7U0xHTEPcCgiO8WfolR3jTuVDEhAfK1Wrx1PRhM-iV3XVIJasGhQtLk9twCWFmXyt77aSLTL2SGK1UA","width":3264},{"height":4032,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/118011766803789561760/photos\">Siddharth Jaswal<\/a>"],"photo_reference":"CmRaAAAA8Kifnc_BYdMZIhLAyMiY9VaYD_QIYS__YjlGkIABoz5ai4yJAxpLgFn-itbk5BU5Z8JCo06Ta7beGjUgyZB_ntj4rlXti_wrEi3if057OO6gsgiHEa9SaOTvN6_l07WzEhDxLuccp7589gZl9xAhgXMAGhRnWgM7AuJYUO9ud4auSbLl2wTSmw","width":3024}],"place_id":"ChIJ1TkoQu8YDTkRVXC88T9HJuU","rating":4.3,"reference":"CmRSAAAAAX7-wF23Wsj3gQXnVOqnVPHseCaPhOUAG2R55zJ-H3fjvOoEgTidYVLRDCIfFrIQ7nwpj1-oqrZegmIUHGolYCbANEB4jwqQj-p708CuVq_iDBx4vGO0_oh8n3-ejN2EEhDxA2o5WWZ7Fq22lrnStKMvGhQxXAzTmstG2mB-d2D-Vn0HzqAm9w","reviews":[{"author_name":"ଗୌର ଗୋପାଳ","author_url":"https://www.google.com/maps/contrib/116759507233193626176/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/-e66mSl0oG04/AAAAAAAAAAI/AAAAAAAAwlI/LyMuSunE4Sc/s128-c0x00000000-cc-rp-mo-ba5/photo.jpg","rating":5,"relative_time_description":"4 weeks ago","text":"Awesome place. \n\nThe metro station is clean.\n\nThey manage the crowd in a good away.\n\nGood security.\n\nThe food near the metro stations are not very good yet very expensive.\n\nThe water ATM is always closed.\n\nStill the metro is good enough because of their service and metro trains are available in every 3 minutes.\n\nLucky peoples get seats in metro, some can't get a seat due to crowd.\n\nAll the best.","time":1519631590},{"author_name":"Ashok Chirvi","author_url":"https://www.google.com/maps/contrib/117864480587599592482/reviews","language":"en","profile_photo_url":"https://lh5.googleusercontent.com/-zwXIbSilfiw/AAAAAAAAAAI/AAAAAAAAAdM/Ts73erCzrRo/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":3,"relative_time_description":"in the last week","text":"End point of Metro Yellow line. This station helps people to enjoy different food joints to relax. It is ATM facilities and affordable transport facilities to various sectors in Gurgaon.","time":1521626985},{"author_name":"Mohamed Eltigani","author_url":"https://www.google.com/maps/contrib/110684257701175088277/reviews","language":"en","profile_photo_url":"https://lh5.googleusercontent.com/-mCdabQdMsJs/AAAAAAAAAAI/AAAAAAAAWs8/1CxW2sGVm5I/s128-c0x00000000-cc-rp-mo-ba6/photo.jpg","rating":4,"relative_time_description":"2 weeks ago","text":"Nice looking, wel maintained, clean and well organized to help the huge number of commuters.. also bus station is nearby, big number of autos and taxi available there. Many shops, hotels and restaurants near it.\nBut is there any toilet?","time":1520614916},{"author_name":"Ahmed Farhan","author_url":"https://www.google.com/maps/contrib/113314672956466253341/reviews","language":"en","profile_photo_url":"https://lh6.googleusercontent.com/-F-tJovek49w/AAAAAAAAAAI/AAAAAAAAAJM/8mf-NpsfixM/s128-c0x00000000-cc-rp-mo-ba4/photo.jpg","rating":5,"relative_time_description":"a month ago","text":"Main Metro station in the Line of Delhi metro rail. Metros are departures from here. Good culture peoples.Big metro station.Auto rickshaws are available in the Metro station.Beware pick pocket issues here. Good Customizing here.","time":1518140937},{"author_name":"Silent Observer","author_url":"https://www.google.com/maps/contrib/105230519091656380679/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/-LLopQZmuAl8/AAAAAAAAAAI/AAAAAAAAAAA/ACLGyWC6Jn4LW_Bd_Xt4zMMw1ZRkmtVXAA/s128-c0x00000000-cc-rp-mo-ba4/photo.jpg","rating":4,"relative_time_description":"a month ago","text":"It\u2019s the last and terminal station on yellow line going to Gurgaon. \nStation premises is quite big to manage large number of commuters. \nOn the ground floor there are plenty of eating options from fast food (Burger King) (McDonalds) or Pizzas to Arabian Food (Middle East Restaurant). \nThere is Decathlon for sports lovers with variety of sports at the hand.","time":1517379777}],"scope":"GOOGLE","types":["subway_station","transit_station","point_of_interest","establishment"],"url":"https://maps.google.com/?cid=16511963423764672597","utc_offset":330,"vicinity":"Delhi, Sector 29, Gurugram"}
     * status : OK
     */

    private ResultBean result;
    private String status;
    private List<?> html_attributions;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<?> getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(List<?> html_attributions) {
        this.html_attributions = html_attributions;
    }

    public static class ResultBean {
        /**
         * address_components : [{"long_name":"Gurugram","short_name":"Gurugram","types":["locality","political"]},{"long_name":"Sector 29","short_name":"Sector 29","types":["sublocality_level_1","sublocality","political"]},{"long_name":"Gurgaon","short_name":"Gurgaon","types":["administrative_area_level_2","political"]},{"long_name":"Haryana","short_name":"HR","types":["administrative_area_level_1","political"]},{"long_name":"India","short_name":"IN","types":["country","political"]},{"long_name":"122007","short_name":"122007","types":["postal_code"]}]
         * adr_address : Delhi, <span class="street-address">Sector 29</span>, <span class="locality">Gurugram</span>, <span class="region">Haryana</span> <span class="postal-code">122007</span>, <span class="country-name">India</span>
         * formatted_address : Delhi, Sector 29, Gurugram, Haryana 122007, India
         * geometry : {"location":{"lat":28.4592693,"lng":77.0724192},"viewport":{"northeast":{"lat":28.4606182802915,"lng":77.0737681802915},"southwest":{"lat":28.4579203197085,"lng":77.07107021970849}}}
         * icon : https://maps.gstatic.com/mapfiles/place_api/icons/generic_business-71.png
         * id : a2be6e7e6c85467500d81113d6100f78df7530ac
         * name : Shalimar Huda City Center
         * photos : [{"height":2304,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/108956928207460108038/photos\">Anurag Thakur<\/a>"],"photo_reference":"CmRaAAAAb-UF6wA_TOSPKfidda5fvqXUS6ppnWM4MCcDgaXDuABnLz3lAhpjAroQhPrE9m4_xnj55-0cNDupSuI8goc3E2e-iBgQUJg9xMvBxqIZdO_6EOidxIX7BaUeMzxuFc4vEhCV4fK1q2Nl3kDXtj64O9d5GhQXZZGAj7BX_znerPNkHbGyYoyE0Q","width":4096},{"height":3096,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/116759507233193626176/photos\">ଗୌର ଗୋପାଳ<\/a>"],"photo_reference":"CmRaAAAAIr9KzMvuRo0eLqd92W_nY_UQjjl8UdkDuFDn2-FoWVB8cvjwKBTuFiH-_qZ9kn2wi4nPMSmXBANMBygg7fLDfdKKfuUNInTDr02Xgu414InlajQ5KyGaVEFj9cPe3Lb3EhDWtO0yP_x855pdQj69j63FGhQtufVfOGAvv1fpFL1lbXXRbkGwZA","width":4128},{"height":1080,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/114315319987761387838/photos\">Rahul Kumar<\/a>"],"photo_reference":"CmRaAAAABzIyTe7FsuBhOJu_H1_4N6Fzb1Z4wMRDcXxKyEinBanaEH-vYvHWnvKig8sCN2Iw2eZsTVn7YwdwVFvtsyD1rZT4h7xeG2R8_DnCTF1WpZf34XV1sS4u90VGTFR4n2ATEhCNdu4tkQqWXJH-09ACovR6GhSaLYs9Ccrt3Uq_c207ouWENC15jg","width":1080},{"height":3120,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/105275058795600989431/photos\">pradeep kumar<\/a>"],"photo_reference":"CmRaAAAAydTAuenMSgzy8j2a3NsiZTZi1egA9z2m8anZ-iiGmdeCRFv3Yz34G5P7VHe5rxCuVgBDQGO_R8uSj7EBXR3H-5bUgkhiKtmHJsEFBjOOFttyvAiDKogrxJ5O7_jGy49eEhDpuSTjyM05WCkO4VPxnr8aGhSpgTeQHgOv0PwuwwR35oRNAPDqaA","width":4160},{"height":3096,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/103181697640655131152/photos\">Srishti Sarawagi<\/a>"],"photo_reference":"CmRaAAAARVQvFZ0FssTFDyHxL4SbUTUpTtAnfiSYTpXXg1az_ndKFpC5-SOZ0Vcr1s77UJlrrRAgcY3w6MT9iATusngmbcj7GeNHyZ-aUM3c_CTKW-LV8TLVvFeUBNM0FqGk33GYEhCmqAWJY6uybTn20aoWrEZhGhQVKHhwIuhgX_HcYZOUvduA_L3gqg","width":4128},{"height":2400,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/111296534101156358814/photos\">Aman Deep<\/a>"],"photo_reference":"CmRaAAAADiSswaYbJ84KCa4vCAWQJsKPPsAcF8Nbpe0vFwb1v9KWZnLX1uwWaGfmQ3QsBQzSEcmlYSHp28GMNlWaQJsV2-2DA2YqP50NnNnyeJKL2vblqqpbVfTFhkIDg_gTfTOkEhDX3vSZobYNG2EEHF1KnY3BGhTxdsuT3r_nBv_XuIW44Yx4woMwtg","width":3200},{"height":900,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/111558997245801229699/photos\">yogendra sahu<\/a>"],"photo_reference":"CmRaAAAA4AJ1ym2HneazEmHhHwM8KEHQDzzz5838TZ32MRZudUG5JRXZoiqgzQ5Ao6XskhpB-OBmuBmfgs_xZC3FA2FUiPVYK3LH1pN8LDm5NQKh5FzG8junba7yBu_kD8leIhB7EhCVKdij5qmkIsxEMwpG9nl8GhTnOBQDSfZoBKylrp_KvIhqOO-StA","width":1600},{"height":3120,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/114305203585357317930/photos\">Parvez Khan<\/a>"],"photo_reference":"CmRZAAAASaGyVnWzuALiCo24OjS52QMblJcG_ITSAyDTsSumj7RmnoheYoCEdHjR-oZIh8C-frbFglogJDjAFn2au-ianC8bJ4i1xyUnLG-ya6T9whlRKQ6X9b1KFusbSTjpvqudEhB8GJMBepKCI9-nSvm_uZy4GhSiO34GZexucIidUuJ8I_Cr-Gby4g","width":4160},{"height":2448,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/111271819053656960972/photos\">Aman Dhayal<\/a>"],"photo_reference":"CmRaAAAAnvKF50Osnhq1SvUvYzWn-LyOUUdo_6FqNWySostfXIPael_RBP1GnS_Oc9rfhLcZInUKjl9YPD8DrYpNzwQeERP7BwfV5hDaZ3Vhkrf7U0xHTEPcCgiO8WfolR3jTuVDEhAfK1Wrx1PRhM-iV3XVIJasGhQtLk9twCWFmXyt77aSLTL2SGK1UA","width":3264},{"height":4032,"html_attributions":["<a href=\"https://maps.google.com/maps/contrib/118011766803789561760/photos\">Siddharth Jaswal<\/a>"],"photo_reference":"CmRaAAAA8Kifnc_BYdMZIhLAyMiY9VaYD_QIYS__YjlGkIABoz5ai4yJAxpLgFn-itbk5BU5Z8JCo06Ta7beGjUgyZB_ntj4rlXti_wrEi3if057OO6gsgiHEa9SaOTvN6_l07WzEhDxLuccp7589gZl9xAhgXMAGhRnWgM7AuJYUO9ud4auSbLl2wTSmw","width":3024}]
         * place_id : ChIJ1TkoQu8YDTkRVXC88T9HJuU
         * rating : 4.3
         * reference : CmRSAAAAAX7-wF23Wsj3gQXnVOqnVPHseCaPhOUAG2R55zJ-H3fjvOoEgTidYVLRDCIfFrIQ7nwpj1-oqrZegmIUHGolYCbANEB4jwqQj-p708CuVq_iDBx4vGO0_oh8n3-ejN2EEhDxA2o5WWZ7Fq22lrnStKMvGhQxXAzTmstG2mB-d2D-Vn0HzqAm9w
         * reviews : [{"author_name":"ଗୌର ଗୋପାଳ","author_url":"https://www.google.com/maps/contrib/116759507233193626176/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/-e66mSl0oG04/AAAAAAAAAAI/AAAAAAAAwlI/LyMuSunE4Sc/s128-c0x00000000-cc-rp-mo-ba5/photo.jpg","rating":5,"relative_time_description":"4 weeks ago","text":"Awesome place. \n\nThe metro station is clean.\n\nThey manage the crowd in a good away.\n\nGood security.\n\nThe food near the metro stations are not very good yet very expensive.\n\nThe water ATM is always closed.\n\nStill the metro is good enough because of their service and metro trains are available in every 3 minutes.\n\nLucky peoples get seats in metro, some can't get a seat due to crowd.\n\nAll the best.","time":1519631590},{"author_name":"Ashok Chirvi","author_url":"https://www.google.com/maps/contrib/117864480587599592482/reviews","language":"en","profile_photo_url":"https://lh5.googleusercontent.com/-zwXIbSilfiw/AAAAAAAAAAI/AAAAAAAAAdM/Ts73erCzrRo/s128-c0x00000000-cc-rp-mo/photo.jpg","rating":3,"relative_time_description":"in the last week","text":"End point of Metro Yellow line. This station helps people to enjoy different food joints to relax. It is ATM facilities and affordable transport facilities to various sectors in Gurgaon.","time":1521626985},{"author_name":"Mohamed Eltigani","author_url":"https://www.google.com/maps/contrib/110684257701175088277/reviews","language":"en","profile_photo_url":"https://lh5.googleusercontent.com/-mCdabQdMsJs/AAAAAAAAAAI/AAAAAAAAWs8/1CxW2sGVm5I/s128-c0x00000000-cc-rp-mo-ba6/photo.jpg","rating":4,"relative_time_description":"2 weeks ago","text":"Nice looking, wel maintained, clean and well organized to help the huge number of commuters.. also bus station is nearby, big number of autos and taxi available there. Many shops, hotels and restaurants near it.\nBut is there any toilet?","time":1520614916},{"author_name":"Ahmed Farhan","author_url":"https://www.google.com/maps/contrib/113314672956466253341/reviews","language":"en","profile_photo_url":"https://lh6.googleusercontent.com/-F-tJovek49w/AAAAAAAAAAI/AAAAAAAAAJM/8mf-NpsfixM/s128-c0x00000000-cc-rp-mo-ba4/photo.jpg","rating":5,"relative_time_description":"a month ago","text":"Main Metro station in the Line of Delhi metro rail. Metros are departures from here. Good culture peoples.Big metro station.Auto rickshaws are available in the Metro station.Beware pick pocket issues here. Good Customizing here.","time":1518140937},{"author_name":"Silent Observer","author_url":"https://www.google.com/maps/contrib/105230519091656380679/reviews","language":"en","profile_photo_url":"https://lh3.googleusercontent.com/-LLopQZmuAl8/AAAAAAAAAAI/AAAAAAAAAAA/ACLGyWC6Jn4LW_Bd_Xt4zMMw1ZRkmtVXAA/s128-c0x00000000-cc-rp-mo-ba4/photo.jpg","rating":4,"relative_time_description":"a month ago","text":"It\u2019s the last and terminal station on yellow line going to Gurgaon. \nStation premises is quite big to manage large number of commuters. \nOn the ground floor there are plenty of eating options from fast food (Burger King) (McDonalds) or Pizzas to Arabian Food (Middle East Restaurant). \nThere is Decathlon for sports lovers with variety of sports at the hand.","time":1517379777}]
         * scope : GOOGLE
         * types : ["subway_station","transit_station","point_of_interest","establishment"]
         * url : https://maps.google.com/?cid=16511963423764672597
         * utc_offset : 330
         * vicinity : Delhi, Sector 29, Gurugram
         */

        private String adr_address;
        private String formatted_address;
        private GeometryBean geometry;
        private String icon;
        private String id;
        private String name;
        private String place_id;
        private double rating;
        private String reference;
        private String scope;
        private String url;
        private int utc_offset;
        private String vicinity;
        private List<AddressComponentsBean> address_components;
        private List<PhotosBean> photos;
        private List<ReviewsBean> reviews;
        private List<String> types;

        public String getAdr_address() {
            return adr_address;
        }

        public void setAdr_address(String adr_address) {
            this.adr_address = adr_address;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public GeometryBean getGeometry() {
            return geometry;
        }

        public void setGeometry(GeometryBean geometry) {
            this.geometry = geometry;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPlace_id() {
            return place_id;
        }

        public void setPlace_id(String place_id) {
            this.place_id = place_id;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getUtc_offset() {
            return utc_offset;
        }

        public void setUtc_offset(int utc_offset) {
            this.utc_offset = utc_offset;
        }

        public String getVicinity() {
            return vicinity;
        }

        public void setVicinity(String vicinity) {
            this.vicinity = vicinity;
        }

        public List<AddressComponentsBean> getAddress_components() {
            return address_components;
        }

        public void setAddress_components(List<AddressComponentsBean> address_components) {
            this.address_components = address_components;
        }

        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }

        public List<ReviewsBean> getReviews() {
            return reviews;
        }

        public void setReviews(List<ReviewsBean> reviews) {
            this.reviews = reviews;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }

        public static class GeometryBean {
            /**
             * location : {"lat":28.4592693,"lng":77.0724192}
             * viewport : {"northeast":{"lat":28.4606182802915,"lng":77.0737681802915},"southwest":{"lat":28.4579203197085,"lng":77.07107021970849}}
             */

            private LocationBean location;
            private ViewportBean viewport;

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public ViewportBean getViewport() {
                return viewport;
            }

            public void setViewport(ViewportBean viewport) {
                this.viewport = viewport;
            }

            public static class LocationBean {
                /**
                 * lat : 28.4592693
                 * lng : 77.0724192
                 */

                private double lat;
                private double lng;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLng() {
                    return lng;
                }

                public void setLng(double lng) {
                    this.lng = lng;
                }
            }

            public static class ViewportBean {
                /**
                 * northeast : {"lat":28.4606182802915,"lng":77.0737681802915}
                 * southwest : {"lat":28.4579203197085,"lng":77.07107021970849}
                 */

                private NortheastBean northeast;
                private SouthwestBean southwest;

                public NortheastBean getNortheast() {
                    return northeast;
                }

                public void setNortheast(NortheastBean northeast) {
                    this.northeast = northeast;
                }

                public SouthwestBean getSouthwest() {
                    return southwest;
                }

                public void setSouthwest(SouthwestBean southwest) {
                    this.southwest = southwest;
                }

                public static class NortheastBean {
                    /**
                     * lat : 28.4606182802915
                     * lng : 77.0737681802915
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }

                public static class SouthwestBean {
                    /**
                     * lat : 28.4579203197085
                     * lng : 77.07107021970849
                     */

                    private double lat;
                    private double lng;

                    public double getLat() {
                        return lat;
                    }

                    public void setLat(double lat) {
                        this.lat = lat;
                    }

                    public double getLng() {
                        return lng;
                    }

                    public void setLng(double lng) {
                        this.lng = lng;
                    }
                }
            }
        }

        public static class AddressComponentsBean {
            /**
             * long_name : Gurugram
             * short_name : Gurugram
             * types : ["locality","political"]
             */

            private String long_name;
            private String short_name;
            private List<String> types;

            public String getLong_name() {
                return long_name;
            }

            public void setLong_name(String long_name) {
                this.long_name = long_name;
            }

            public String getShort_name() {
                return short_name;
            }

            public void setShort_name(String short_name) {
                this.short_name = short_name;
            }

            public List<String> getTypes() {
                return types;
            }

            public void setTypes(List<String> types) {
                this.types = types;
            }
        }

        public static class PhotosBean {
            /**
             * height : 2304
             * html_attributions : ["<a href=\"https://maps.google.com/maps/contrib/108956928207460108038/photos\">Anurag Thakur<\/a>"]
             * photo_reference : CmRaAAAAb-UF6wA_TOSPKfidda5fvqXUS6ppnWM4MCcDgaXDuABnLz3lAhpjAroQhPrE9m4_xnj55-0cNDupSuI8goc3E2e-iBgQUJg9xMvBxqIZdO_6EOidxIX7BaUeMzxuFc4vEhCV4fK1q2Nl3kDXtj64O9d5GhQXZZGAj7BX_znerPNkHbGyYoyE0Q
             * width : 4096
             */

            private int height;
            private String photo_reference;
            private int width;
            private List<String> html_attributions;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getPhoto_reference() {
                return photo_reference;
            }

            public void setPhoto_reference(String photo_reference) {
                this.photo_reference = photo_reference;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public List<String> getHtml_attributions() {
                return html_attributions;
            }

            public void setHtml_attributions(List<String> html_attributions) {
                this.html_attributions = html_attributions;
            }
        }

        public static class ReviewsBean {
            /**
             * author_name : ଗୌର ଗୋପାଳ
             * author_url : https://www.google.com/maps/contrib/116759507233193626176/reviews
             * language : en
             * profile_photo_url : https://lh3.googleusercontent.com/-e66mSl0oG04/AAAAAAAAAAI/AAAAAAAAwlI/LyMuSunE4Sc/s128-c0x00000000-cc-rp-mo-ba5/photo.jpg
             * rating : 5
             * relative_time_description : 4 weeks ago
             * text : Awesome place.

             The metro station is clean.

             They manage the crowd in a good away.

             Good security.

             The food near the metro stations are not very good yet very expensive.

             The water ATM is always closed.

             Still the metro is good enough because of their service and metro trains are available in every 3 minutes.

             Lucky peoples get seats in metro, some can't get a seat due to crowd.

             All the best.
             * time : 1519631590
             */

            private String author_name;
            private String author_url;
            private String language;
            private String profile_photo_url;
            private int rating;
            private String relative_time_description;
            private String text;
            private int time;

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getAuthor_url() {
                return author_url;
            }

            public void setAuthor_url(String author_url) {
                this.author_url = author_url;
            }

            public String getLanguage() {
                return language;
            }

            public void setLanguage(String language) {
                this.language = language;
            }

            public String getProfile_photo_url() {
                return profile_photo_url;
            }

            public void setProfile_photo_url(String profile_photo_url) {
                this.profile_photo_url = profile_photo_url;
            }

            public int getRating() {
                return rating;
            }

            public void setRating(int rating) {
                this.rating = rating;
            }

            public String getRelative_time_description() {
                return relative_time_description;
            }

            public void setRelative_time_description(String relative_time_description) {
                this.relative_time_description = relative_time_description;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }
        }
    }
}

