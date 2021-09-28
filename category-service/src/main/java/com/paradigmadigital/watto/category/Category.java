package com.paradigmadigital.watto.category;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {

	@Id
	private String id;
	@NonNull
	private String name;
	@NonNull
	private String description;
	
}
