package com.paradigmadigital.watto.item;

import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
	@Id	private String id;
	private String name;
	private String description;
	private String alttext;
	private String img;
	private float price;
	private List<Photo> photos;
	private String categoryId;
	private ItemStatus status;
}
