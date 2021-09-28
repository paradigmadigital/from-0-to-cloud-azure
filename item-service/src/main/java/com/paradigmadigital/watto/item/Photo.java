package com.paradigmadigital.watto.item;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
	@Id
	private String id;
	private String name;
	private String url;
	private String description;
	private String alt;
	private Item item;
}
