package com.softgraf.primavera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		//carrega formulário login.html
		//return "<h1>Deu certo</h1>";
		return "/login";
	}
}
