package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Currency;

@RepositoryRestResource
public interface CurrencyRepository  extends JpaRepository<Currency,Integer> {
	List<Currency> findAll();
	
	//有問題
	Currency findByName(String name);
	
	Currency findByCode(String code);
	
	Currency findById(int id);
	
	@SuppressWarnings("unchecked")
	Currency save(Currency currency);
	
	boolean getById(int id);
	
	void deleteById(int id);
	
	boolean deleteByName(String name);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE currency SET code=?1 , name=?2 WHERE id=?3 ", nativeQuery = true)
	int UpdateBySQL(String code,String name,String id );
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "insert into  currency (code,name) values (?1 ,?2) ", nativeQuery = true)
	Object SaveBySQL(String code,String name );

	

//	void insert(String name,String code);
	

	
//	@Query(value = "select * from currency", nativeQuery = true)//?1表示第一個引數，?2表示第二個引數
//	List<Currency> findBySQL();
//	
//	
//	@Query(value = "insert into currency(name,code) values('?1','?2')", nativeQuery = true)//?1表示第一個引數，?2表示第二個引數
//	Currency insertBySQL(String name,String code);
//	

	
	
//	@Query(value = "SELECT * FROM currency where 1=1", nativeQuery = true)//?1表示第一個引數，?2表示第二個引數
//	List<Currency> findBySQL();
	
	// 通過名稱找到使用者
//	User findByName(String name);
//	// 通過名稱和年齡找到使用者
//	User findByNameAndAge(String name, Integer age);
//	// 通過名稱模糊查詢
//	List<User> findByNameLike(String name);
//	// 使用hql查詢
//	@Query("from User u where u.name=:name")//:name對應@Param裡的name
//	User findByHQL(@Param("name") String name);
//	// 使用sql查詢
//	@Query(value = "select * from user where name = ?1 and age = ?2", nativeQuery = true)//?1表示第一個引數，?2表示第二個引數
//	User findBySQL(String name, Integer age);
	
//	DROP TABLE IF EXISTS TEST;
//	CREATE TABLE TEST(ID INT PRIMARY KEY,NAME VARCHAR(255));
//	INSERT INTO TEST VALUES(1, 'Hello');
//	INSERT INTO TEST VALUES(2, 'World');
//	SELECT * FROM TEST ORDER BY ID;
//	UPDATE TEST SET NAME='Hi' WHERE ID=1;
//	DELETE FROM TEST WHERE ID=2;
	
//	List<T> findAll();
//	Page<T> findAll(Pageable pageable);
//	T getOne(ID id);
//	T S save(T entity);
//	void deleteById(ID id);
}
