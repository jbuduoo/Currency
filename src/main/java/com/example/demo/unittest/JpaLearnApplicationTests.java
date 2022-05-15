package com.example.demo.unittest;

//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
////https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/13854/
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class JpaLearnApplicationTests
//{
//// 注入userRepository
//@Autowired
//private UserRepository userRepository;
//@Test
//public void contextLoads()
//{
//// 新增10個測試用例
//userRepository.save(new User("QQQ",1));
//userRepository.save(new User("WWW",2));
//userRepository.save(new User("EEE",3));
//userRepository.save(new User("AAA",4));
//userRepository.save(new User("SSS",5));
//userRepository.save(new User("DDD",6));
//userRepository.save(new User("ZZZ",7));
//userRepository.save(new User("XXX",8));
//userRepository.save(new User("CCC",9));
//userRepository.save(new User("QQQ2",10));
//// 測試findAll, 查詢所有記錄
//Assert.assertEquals(10, userRepository.findAll().size());
//// 測試findByName, 查詢姓名為AAA的User
//Assert.assertEquals(4, userRepository.findByName("AAA").getAge().longValue());
//// 測試findByHQL, 查詢姓名為AAA的User
//Assert.assertEquals(4, userRepository.findByHQL("AAA").getAge().longValue());
//// 測試findByNameAndAge, 查詢姓名為SSS並且年齡為5的User
//Assert.assertEquals("SSS", userRepository.findByNameAndAge("SSS", 5).getName());
//// 測試findBySQL, 查詢姓名為SSS並且年齡為5的User
//Assert.assertEquals("SSS", userRepository.findBySQL("SSS", 5).getName());
//// 測試刪除姓名為AAA的User
//userRepository.delete(userRepository.findByName("AAA"));
//// 測試findAll, 查詢所有記錄, 驗證上面的刪除是否成功
//Assert.assertEquals(9, userRepository.findAll().size());
//// 測試findAll, 查詢名字有Q的有幾個
//Assert.assertEquals(2,userRepository.findByNameLike("%Q%").size());
//}
//}