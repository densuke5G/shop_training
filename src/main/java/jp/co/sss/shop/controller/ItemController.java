package jp.co.sss.shop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.bean.ItemBean;
import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.form.ItemForm;
import jp.co.sss.shop.repository.ItemRepository;

@Controller
public class ItemController {
	@Autowired
	ItemRepository repository;

	@RequestMapping("/items/findAll")
	public String showItemList(Model model) {
		model.addAttribute("items", repository.findAllByOrderByNameDesc());
		return "items/item_list";
	}

	@RequestMapping("/items/getOne/{id}")
	public String showItem(@PathVariable int id, Model model) {
		Item item = repository.getReferenceById(id);
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(item, itemBean);
		model.addAttribute("item", itemBean);
		return "items/item";
	}

	@RequestMapping("/items/findByNameAndPrice/{price}")
	public String showItemListByPrice(@PathVariable Integer price, Model model) {
		model.addAttribute("items", repository.findByPrice(price));
		return "items/item_list";
	}

	@RequestMapping("/items/findByNameAndPrice/{name}/{price}")
	public String showItemListByNameAndPrice(@PathVariable String name, @PathVariable Integer price, Model model) {
		model.addAttribute("items", repository.findByNameAndPrice(name, price));
		return "items/item_list";
	}

	@RequestMapping("/items/findByNameLike/{name}")
	public String showItemListByNameLike(@PathVariable String name, Model model) {
		model.addAttribute("items", repository.findByNameContaining(name));
		return "items/item_list";
	}

	@RequestMapping(path = "/items/findAllAndSetDropdown")
	public String itemListSetDropdown(Model model) {
		model.addAttribute("items", repository.findAll());
		return "items/item_list_dropdown";
	}

	@RequestMapping("/items/create/input")
	public String createInput() {
		return "items/create_input";
	}

	@RequestMapping(path = "/items/create/complete", method = RequestMethod.POST)
	public String createComplete(ItemForm form, Model model) {
		Item item = new Item();
		BeanUtils.copyProperties(form, item, "id");
		item = repository.save(item);
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(item, itemBean);
		model.addAttribute("item", itemBean);
		return "items/item";
	}

	@RequestMapping(path = "/items/update/input/{id}")
	public String updateInput(@PathVariable Integer id, Model model) {
		Item item = repository.getReferenceById(id);
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(item, itemBean);
		model.addAttribute("item", itemBean);
		return "items/update_input";
	}

	@RequestMapping(path = "/items/update/complete/{id}", method = RequestMethod.POST)
	public String updateComplete(ItemForm form, Model model) {
		//		Item item = repository.getReferenceById(id);
		Item item = new Item();
		BeanUtils.copyProperties(form, item);
		item = repository.save(item);
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(item, itemBean);
		model.addAttribute("item", itemBean);
		return "items/item";
	}

	@RequestMapping("/lesson")
	public String lesson(Model model) {
		String name = "ちだ";
		model.addAttribute("name", name);

		int hobby = 2;
		model.addAttribute("hobby", hobby);

		List<String> jobs = new ArrayList<>();
		jobs.add("SE");
		jobs.add("医師");
		jobs.add("教師");
		model.addAttribute("jobs", jobs);

		int speed = 2;
		model.addAttribute("speed", speed);

		String suda = "すだ";
		model.addAttribute("suda", suda);

		Date birthday = new Date();
		model.addAttribute("birthday", birthday);

		int deptId = 3;
		model.addAttribute("deptId", deptId);
		return "lesson";
	}
	
	@RequestMapping("/items/findAllJs")
	public String showItemListJs(Model model) {
		model.addAttribute("items", repository.findAll());
		return "items/item_list_js";
	}
}
