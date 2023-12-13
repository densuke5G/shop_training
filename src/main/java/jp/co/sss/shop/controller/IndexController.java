package jp.co.sss.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(path = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(path = "/before")
	public String before() {
		return "before";
	}
	@RequestMapping(path = "/after")
	public String after() {
		return "after";
	}
	@RequestMapping(path = "/transition")
	public String sampleTransition() {
		return "sampleTransition";
	}
	@RequestMapping(path = "/index_f")
	public String indexForward() {
		return "index";
	}
	@RequestMapping(path = "/index_r")
	public String indexRedirect() {
		return "redirect:/";
	}
	
	
}
