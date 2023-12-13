package jp.co.sss.shop.controller;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.shop.repository.ItemWithCategoryRepository;

@Controller
public class ItemWithCategoryConttroller {
	
	@Autowired
	EntityManager entityManager;
	@Autowired
	ItemWithCategoryRepository repository;
	
	@RequestMapping(path = "/items/findItemAndCategory")
	public String showItemAndCategoryList(Model model) {
		model.addAttribute("items", repository.findAll());
		return "items/item_category_list";
	}
	
	@RequestMapping(path = "/items/searchWithNamedQuery/{id}")
	public String searchWithNamedQuery(@PathVariable Integer id, Model model) {
		Query query = entityManager.createNamedQuery("findByIdNamedQuery");
		query.setParameter("id", id);
		model.addAttribute("items", query.getResultList());
		return "items/item_category_list";
	}
}
