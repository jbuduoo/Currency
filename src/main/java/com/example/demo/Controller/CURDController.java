package com.example.demo.Controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Dao.CurrencyRepository;
import com.example.demo.Model.Currency;
import com.example.demo.Service.CurrencyService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 

@Controller  
public class CURDController {
	
	@Autowired
	CurrencyRepository currencyRepository;
	@Autowired
	CurrencyService currencyService;

	//查詢
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView selectAll() {
		List<Currency> currencys = currencyService.findAll();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("select-data");
		modelAndView.addObject("currencys", currencys);
		return modelAndView;
	}
	
	//新增
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String saveBySQL(@ModelAttribute Currency currency)  {
		System.err.println("ddddddd");
		currencyService.SaveBySQL(currency);
		return "redirect:/";
	}
	
	//修改，跳轉到修改頁面
	@RequestMapping(value="/currencyUpdate/{id}",method=RequestMethod.POST)
    public ModelAndView currencyUpdate(@PathVariable(value="id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Currency currency=currencyService.findById(id);

		modelAndView.setViewName("edit");
		modelAndView.addObject("currency", currency);
		return modelAndView;
		
    }
	//修改
	@RequestMapping(value ="/save4", method = RequestMethod.POST)
	public String save4(@RequestParam("name") String name,@RequestParam("id") String id,@RequestParam("code") String code) {
		
		currencyService.update(new Currency(Integer.parseInt(id),name,code,""));
		return "redirect:/";
	}
	
	//刪除
	@DeleteMapping(value="/currencyDel/{id}")
    public String currencyDel(@PathVariable(value="id") int id) {
		currencyService.deleteById(id);
        return "redirect:/";
    }



}
