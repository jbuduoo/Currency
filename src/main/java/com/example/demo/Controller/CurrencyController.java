package com.example.demo.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.Dao.CurrencyRepository;
import com.example.demo.Model.Currency;
import com.example.demo.Service.CurrencyService;
import net.sf.json.JSONObject;

@RestController
public class CurrencyController {
	@Autowired
	CurrencyRepository currencyRepository;

	@Autowired
	CurrencyService currencyService;
	

	@RequestMapping(value = "/rest/api/currencyApi.rest")
	public String currencyApi() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("https://api.coindesk.com/v1/bpi/currentprice.json", String.class);

		return response;
	}
	

	@RequestMapping(value = "/rest/api/newCurrencyApi.rest")
	public HashMap<String,Object> newCurrencyApi() {
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("https://api.coindesk.com/v1/bpi/currentprice.json", String.class);

		Date date=new Date();
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	    
		JSONObject json = JSONObject.fromObject(response);
		JSONObject bpi = json.getJSONObject("bpi");
		JSONObject USD = bpi.getJSONObject("USD");
		JSONObject GBP = bpi.getJSONObject("GBP");
		JSONObject EUR = bpi.getJSONObject("EUR");
		String USDRate = USD.get("rate").toString();
		String GBPRate = GBP.get("rate").toString();
		String EURRate = EUR.get("rate").toString();
		Currency currencyUSD = currencyRepository.findByCode("USD");
		Currency currencyGBP = currencyRepository.findByCode("GBP");
		Currency currencyEUR = currencyRepository.findByCode("EUR");
		currencyUSD.setRate(USDRate);
		currencyGBP.setRate(GBPRate);
		currencyEUR.setRate(EURRate);
		
		currencyService.save(currencyUSD);
		currencyService.save(currencyGBP);
		currencyService.save(currencyEUR);

	    HashMap<String,Object> map=new HashMap<>();
		ArrayList<Currency> list = new ArrayList<>();
		list.add(currencyUSD);
		list.add(currencyGBP);
		list.add(currencyEUR);
		
		map.put("code", "0");
		map.put("date", myFmt.format(date));
		map.put("data", list);
		
		return map;
	}
}
