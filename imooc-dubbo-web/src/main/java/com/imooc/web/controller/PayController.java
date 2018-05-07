package com.imooc.web.controller;

import com.imooc.curator.ZKCurator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.common.utils.IMoocJSONResult;
import com.imooc.web.service.CulsterService;

/**
 * @Description: 订购商品controller
 */
@Controller
public class PayController {
	
	@Autowired
	private CulsterService buyService;

	@Autowired
	private ZKCurator zkCurator;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/buy-old")
	@ResponseBody
	public IMoocJSONResult doGetlogin(String itemId) {
		
		if (StringUtils.isNotBlank(itemId)) {
			buyService.displayBuy(itemId);
		} else {
			return IMoocJSONResult.errorMsg("商品id不能为空");
		}
		
		return IMoocJSONResult.ok();
	}

	@GetMapping("/buy")
	@ResponseBody
	public IMoocJSONResult buy(String itemId) {

		boolean result = buyService.displayBuy(itemId);

		return IMoocJSONResult.ok(result?"订单创建成功...":"订单创建失败...");
	}

	@GetMapping("/buy2")
	@ResponseBody
	public IMoocJSONResult buy2(String itemId) {

		boolean result = buyService.displayBuy(itemId);

		return IMoocJSONResult.ok(result?"订单创建成功...":"订单创建失败...");
	}

	@RequestMapping("/isZKAlive")
	@ResponseBody
	public IMoocJSONResult isZKAlive() {
		boolean isAlive = zkCurator.isZKAlive();
		String result = isAlive ? "连接" : "断开";
		return IMoocJSONResult.ok(result);
	}
	
}
