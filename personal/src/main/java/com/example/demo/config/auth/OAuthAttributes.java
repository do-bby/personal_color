package com.example.demo.config.auth;

import java.util.Map;

import com.example.demo.entity.Member;
import com.example.demo.entity.Role;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
	
	private Map<String,Object> attributes;
	private String nameAttributeKey;	
	private String name;
	private String email;
	//private String nickname;
	
	@Builder
	public OAuthAttributes(Map<String,Object> attributes, String nameAttributeKey
			,String name, String email) {
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.name = name;
		this.email = email;
		//this.nickname = nickname;
	}
	
	public static OAuthAttributes of(String registrationId, String userNameAttributeName,
			Map<String, Object> attributes) {
		return ofGoogle(userNameAttributeName, attributes);
	}
	
	private static OAuthAttributes ofGoogle(String userNameAttributeName,
			Map<String, Object> attributes) {
		return OAuthAttributes.builder()
				.name((String) attributes.get("name"))
				.email((String) attributes.get("email"))
				//.nickname((String)attributes.get("nickname"))
				.attributes(attributes)
				.nameAttributeKey(userNameAttributeName)
				.build();
	}
	public Member toEntity() {
		return Member.builder()
				.name(name)
				.email(email)
				.role(Role.USER)
				.build();
	}

}
