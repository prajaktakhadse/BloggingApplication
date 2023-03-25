package com.learn.payload;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//for paging and sorting
@NoArgsConstructor
@Getter
@Setter
public class PostResponse {

	private List<PostDto> content;
	private int pageNumebr;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean lastpage;//is this  a last page or not ?
	
}
