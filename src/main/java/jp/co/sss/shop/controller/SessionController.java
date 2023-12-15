package jp.co.sss.shop.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.sss.shop.form.LoginForm;
import jp.co.sss.shop.form.LoginFormWithValidation;

@Controller
public class SessionController {

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "session/login";
	}

	@RequestMapping(path = "/doLogin", method = RequestMethod.GET)
	public String doLoginGet(Integer userId) {
		System.out.println("ユーザーID" + userId);
		return "session/login";
	}

	@RequestMapping(path = "/doLogin", method = RequestMethod.POST)
	public String doLoginPost(Integer userId) {
		System.out.println("ユーザーID" + userId);
		return "session/login";
	}

	@RequestMapping(path = "/loginUsingForm", method = RequestMethod.GET)
	public String loginUsingForm() {
		return "session/loginUsingForm";
	}

	@RequestMapping(path = "/doLoginUsingForm", method = RequestMethod.POST)
	public String doLoginUsingForm(LoginForm form) {
		System.out.println("ユーザーID" + form.getUserId());
		System.out.println("パスワード" + form.getPassword());
		return "session/loginUsingForm";
	}

	@RequestMapping(path = "/loginOnRequest", method = RequestMethod.GET)
	public String loginOnRequest() {
		return "session/loginOnRequest";
	}

	@RequestMapping(path = "/doLoginOnRequest", method = RequestMethod.POST)
	public String doLoginOnRequest(LoginForm form, Model model) {
		model.addAttribute("userId", form.getUserId());
		model.addAttribute("password", form.getPassword());
		return "session/loginOnRequest";
	}

	@RequestMapping(path = "/loginOnSession", method = RequestMethod.GET)
	public String loginOnSession() {
		return "session/loginOnSession";
	}

	@RequestMapping(path = "doLoginOnSession", method = RequestMethod.POST)
	public String doLoginOnSession(LoginForm form, HttpSession session) {
		if (form.getUserId() == 123) {
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/loginOnSession";
		}
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(path = "/loginWithValidation", method = RequestMethod.GET)
	public String loginWithValidation(@ModelAttribute LoginFormWithValidation form) {
		return "session/loginWithValidation";
	}

	@RequestMapping(path = "/loginWithValidation", method = RequestMethod.POST)
	public String doLoginWithValidation(@Valid @ModelAttribute LoginFormWithValidation form,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "session/loginWithValidation";

		}
		if (form.getUserId() == 123) {
			return "redirect:/";

		} else {
			return "session/loginWithValidation";

		}
	}

	@RequestMapping(path = "/loginOnFlash", method = RequestMethod.GET)
	public String loginOnFlash(Model model) {
		if (!model.containsAttribute("loginFormWithValidation")) {
			model.addAttribute("loginFormWithValidation", new LoginFormWithValidation());
		}
		return "session/loginOnFlash";
	}

	@RequestMapping(path = "/doLoginOnFlash", method = RequestMethod.POST)
	public String doLoginFlash(@Valid @ModelAttribute LoginFormWithValidation form, BindingResult result,
			HttpSession session, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute(
					"org.springframework.validation.BindingResult.loginFormWithValidation", result);
			redirectAttributes.addFlashAttribute("loginFormWithValidation", form);
			System.out.println("redirect");
			return "redirect:/loginOnFlash";
		}
		if (form.getUserId() == 123) {
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/loginOnFlash";
		}
	}

}
