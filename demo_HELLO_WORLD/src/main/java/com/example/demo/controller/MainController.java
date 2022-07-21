package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping(value = {"/Top"})
	String Top(){
		
		//↑URLの末尾が/Topであれば↓Top.htmlを（返す）表示する。
		return "top";
	}
}
