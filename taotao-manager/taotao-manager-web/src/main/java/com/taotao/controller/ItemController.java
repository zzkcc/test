package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
/**
 * 商品管理Controller
 * @author Administrator
 *
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
	@ResponseBody
	public Object getItemById(@PathVariable Long itemId) {
		TbItem tbItem=itemService.getItemById(itemId);
		return "cnm";
	}

	@RequestMapping(value = "/item",method = RequestMethod.GET)
	@ResponseBody
	public Object cnm() {
//		TbItem tbItem=itemService.getItemById(itemId);
		return "cnm12311";
	}
}
