package com.poscodx.jblog.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/{id:(?!assets).*}")
public class BlogController {
	
	@ResponseBody
	@RequestMapping({"", "/{pathNo1}", "/{pathNo1}/{pathNo2}" })
	public String index(
		@PathVariable("id") String id,
		@PathVariable("pathNo1") Optional<Long> pathNo1,
		@PathVariable("pathNo2") Optional<Long> pathNo2) {
		
		Long categoryNo = 0L;
		Long postNo = 0L;
		
		if(pathNo2.isPresent()) {
			categoryNo = pathNo1.get();
			postNo = pathNo2.get();
		} else if(pathNo1.isPresent()) {
			categoryNo = pathNo1.get();
		}
		
		// categoryNo == 0일때 기본 categoryNo 세팅
		
		// postNo == 0일때 기본 postNo 세팅
		
		return "BlogController.index(" + id + ", " + categoryNo + ", " + postNo + ")";
	
	}
	
	// @Auth
	@RequestMapping("/admin/basic")
	public String adminBasic(@PathVariable("id") String id) {
		return "blog/admin-basic";
	}

	// @Auth
	@RequestMapping("/admin/category")
	public String adminCategory(@PathVariable("id") String id) {
		
		return "blog/admin-category";
	}
	
	//@Auth
	@RequestMapping("/admin/write")
	public String adminWrite(@PathVariable("id") String id) {
		return "blog/admin-write";
	}

}
