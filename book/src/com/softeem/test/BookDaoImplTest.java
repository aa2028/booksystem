package com.softeem.test; 

import com.softeem.bean.Book;
import com.softeem.dao.BookDao;
import com.softeem.dao.impl.BookDaoImpl;
import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.math.BigDecimal;
import java.util.List;

/** 
* BookDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>8月 1, 2022</pre> 
* @version 1.0 
*/ 
public class BookDaoImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: queryForPageTotalCount() 
* 
*/ 
@Test
public void testQueryForPageTotalCount() throws Exception {
    BookDao bookDao = new BookDaoImpl() ;
    Integer integer = bookDao.queryForPageTotalCount();
    System.out.println("integer = " + integer);
} 

/** 
* 
* Method: queryForPageItems(int begin, int pageSize) 
* 
*/ 
@Test
public void testQueryForPageItems() throws Exception {
    BookDao bookDao = new BookDaoImpl() ;
    List<Book> bookList =
            bookDao.queryForPageItems(0, 5,null,null,new BigDecimal(16),new BigDecimal(16));
    for (Book book : bookList) {
        System.out.println("book = " + book);
    }
} 

/** 
* 
* Method: findAll() 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: save(Book Book) 
* 
*/ 
@Test
public void testSave() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateById(Book book) 
* 
*/ 
@Test
public void testUpdateById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: deleteById(Integer id) 
* 
*/ 
@Test
public void testDeleteById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findById(Integer id) 
* 
*/ 
@Test
public void testFindById() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: page(Integer pageNumber) 
* 
*/ 
@Test
public void testPage() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: pageRecord() 
* 
*/ 
@Test
public void testPageRecord() throws Exception { 
//TODO: Test goes here... 
} 


} 
