package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import com.example.demo.Dao.CurrencyRepository;
import com.example.demo.Model.Currency;
import com.example.demo.Service.CurrencyService;


@SpringBootTest
public class CurrencyTest {

	@Autowired
	CurrencyRepository currencyRepository;
	@Autowired
	CurrencyService currencyService;
	
	//1. 測試呼叫查詢幣別對應表資料 API，並顯示其內容。
//	@Test
//	public void findAll() {
//
//		List<Currency> list = new ArrayList<Currency>();
//		list = currencyService.findAll();
//
//		for (int i = 0; i < list.size(); i++) {
//			System.err.println("findAll:"+list.get(i).getName());
//		}
//	}
	
	//1. 測試呼叫查詢幣別對應表資料 API，並顯示其內容。
//	@Test
//    public void findById(){
//		Currency curreny=currencyService.findById(5);
//        System.err.println("findById:" +curreny.toString());
//    }
	
	//2. 測試呼叫新增幣別對應表資料 API。
//	@Test
//	public void addCurrency()  {
//		Currency currency=new Currency();
//		currency.setCode("abc");
//		currency.setName("狗狗幣");
//		currencyService.save(currency);
//	}
	

	//3. 測試呼叫更新幣別對應表資料 API，並顯示其內容。
//	@Test
//	public void currencySave(){
//		currencyRepository.UpdateBySQL("aaaa","aaaa","5" );
//	}	
	
	//4. 測試呼叫刪除幣別對應表資料 API。
//	@Test
//	public void deleteById() {
//		currencyService.deleteById(3);
//	}

	//5. 測試呼叫 coindesk API，並顯示其內容。
	@Test
	public void currencyApi() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("http://localhost:8080/rest/api/currencyApi.rest", String.class);
		System.out.println("currencyApi test:"+response.toString());
	}

	//6. 測試呼叫資料轉換的 API，並顯示其內容
	@Test
	public void newCurrencyApi() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("http://localhost:8080/rest/api/newCurrencyApi.rest", String.class);
		System.err.println("newCurrencyApi test:"+response.toString());
	}
	

}
