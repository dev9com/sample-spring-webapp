package com.dev9.service.twitter;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitterResult {
    private Date created_at;
    private String from_user;
    private Integer from_user_id;
    private String from_user_id_str;
    private String iso_language_code;
    private String profile_image_url;
    private String text;

    private TwitterResult() {

    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getFrom_user() {
        return from_user;
    }

    public void setFrom_user(String from_user) {
        this.from_user = from_user;
    }

    public Integer getFrom_user_id() {
        return from_user_id;
    }

    public void setFrom_user_id(Integer from_user_id) {
        this.from_user_id = from_user_id;
    }

    public String getFrom_user_id_str() {
        return from_user_id_str;
    }

    public void setFrom_user_id_str(String from_user_id_str) {
        this.from_user_id_str = from_user_id_str;
    }

    public String getIso_language_code() {
        return iso_language_code;
    }

    public void setIso_language_code(String iso_language_code) {
        this.iso_language_code = iso_language_code;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
