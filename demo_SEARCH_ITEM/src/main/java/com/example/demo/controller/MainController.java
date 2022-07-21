package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping(value = {"/Top"})
	String Top(){
		
		//↑URLの末尾が/Topであれば↓Top.htmlを（返す）表示する。
		return "top";
	}
//	@RequestMapping(value = {"/Enter"})
//	String Enter(){
		
//		//↑URLの末尾が/Topであれば↓Top.htmlを（返す）表示する。
//		return "Login";
//	}
	
	@RequestMapping(value = {"/Enter"})
	String enter(@RequestParam Optional<String> error,Model model){
	
		if(error.isPresent()){
			//nullチェック
			model.addAttribute("error","ログインエラー");
		}
		
	
	
	return "Login";
	}
}
