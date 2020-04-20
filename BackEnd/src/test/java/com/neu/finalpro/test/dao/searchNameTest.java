package com.neu.finalpro.test.dao;

import com.neu.finalpro.Dao.SearchItemDao;
import com.neu.finalpro.pojo.MainPagePojo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class searchNameTest {

    @Mock
    SearchItemDao searchItemDao;

    @Mock
    List<MainPagePojo> mainPagePojoList;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void searchItem(){
        try {
            when(searchItemDao.searchItem("books", "Java")).thenReturn(mainPagePojoList);
            List<MainPagePojo> mpp = searchItemDao.searchItem("books", "Java");
            Assert.assertEquals(searchItemDao, mpp);
            verify(searchItemDao, times(1)).searchItem("books", "Java");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void categoryItem(){
        try {
            when(searchItemDao.categoryItem("books")).thenReturn(mainPagePojoList);
            List<MainPagePojo> mpp = searchItemDao.categoryItem("books");
            Assert.assertEquals(searchItemDao, mpp);
            verify(searchItemDao, times(1)).categoryItem("books");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
