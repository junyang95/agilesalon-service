package com.miniprogram.agilesalonservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "agilesalon")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "open_id", length = 64)
    private String openId;  // 微信用户唯一标识

    @Column(name = "nickname")
    private String nickname;  // 微信用户昵称

    @Column(name = "gender")
    private Integer gender;  // 性别 0：未知、1：男、2：女

    @Column(name = "city")
    private String city;  // 所在城市

    @Column(name = "province")
    private String province;  // 所在省份

    @Column(name = "country")
    private String country;  // 所在国家

    @Column(name = "avatar_url")
    private String avatarUrl;  // 用户头像
}
