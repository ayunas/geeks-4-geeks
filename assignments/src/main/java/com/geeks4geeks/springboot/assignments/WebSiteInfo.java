package com.geeks4geeks.springboot.assignments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class WebSiteInfo {
	private String website;
	@Getter @Setter private byte[] byte_arr;
}


