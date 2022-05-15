package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Controller.CURDController;
import com.example.demo.Dao.CurrencyRepository;
import com.example.demo.Model.Currency;
import com.example.demo.Service.CurrencyService;

@SpringBootTest
public class CURDTest {

	@Autowired
	CurrencyRepository currencyRepository;
	@Autowired
	CurrencyService currencyService;
	@Autowired
	CURDController springBootController;
	
	
	
	//1. 測試呼叫查詢幣別對應表資料 API，並顯示其內容。
	@Test
	public void selectAll() {
		springBootController.selectAll();
	}
	
	//2. 測試呼叫新增幣別對應表資料 API。
	@Test
	public void saveBySQL()  {
		Currency currency=new Currency();
		System.err.println("ccccccc");
		currency.setCode("DE-234");
		currency.setName("Test");
		
		springBootController.saveBySQL(currency);
	}
	
	//3. 測試呼叫更新幣別對應表資料 API，並顯示其內容。
	@Test
    public void save4() {
		springBootController.save4("aaaaa","3","eee-234");
    }
	
	//4. 測試呼叫刪除幣別對應表資料 API。
	@Test
    public void currencyDel() {
		springBootController.currencyDel(2);
    }

}
