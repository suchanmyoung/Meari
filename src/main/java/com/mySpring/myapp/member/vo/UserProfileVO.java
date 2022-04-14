package com.mySpring.myapp.member.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Setter
@Getter
@Entity
public class UserProfileVO {

   @Id
   @Column(name = "PROFILE_NO")
   private String profileNo;

   @Column(name = "PROFILE_IMAGE_NAME")
   private String profileImageName;

   @Column(name = "PROFILE_CONTENTS")
   private String profileContents;

   @Column(name = "ID")
   private String id;

   public UserProfileVO(){
   }
}