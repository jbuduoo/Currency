package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Dao.CurrencyRepository;
import com.example.demo.Model.Currency;


//@Transactional
@Service
public class CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;
	
	//查詢
	public List<Currency> findAll() {

		List<Currency> list = new ArrayList<Currency>();
		list = currencyRepository.findAll();

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		return list;
	}
	//新增
	public void save(Currency currency)  {
		currencyRepository.save(currency);
	}

	//修改
	public void update(Currency currency) {
		currencyRepository.save(currency);
	}
	
	//刪除
    public void deleteById(int id){
    	currencyRepository.deleteById(id);
    }
    
    //用id去查詢
    public Currency findById(int id){
        return currencyRepository.findById(id);
    }
    
  //新增
	public void SaveBySQL(Currency currency) {
		System.err.println("getCode"+currency.getCode());
		System.err.println("getName"+currency.getName());
		currencyRepository.SaveBySQL(currency.getCode(),currency.getName());
	}

//	public void delete(int id) {
//		currencyRepository.deleteById(id);
//	}
//
//	public List<Currency> listUserAll(){
//        return currencyRepository.findAll();
//    }
//

//
//    public Currency findByName(String name){
//        return currencyRepository.findByName(name);
//    }
//
//
//    
//    public void deleteByName(String name){
//    	currencyRepository.deleteByName(name);
//    }
    
}
