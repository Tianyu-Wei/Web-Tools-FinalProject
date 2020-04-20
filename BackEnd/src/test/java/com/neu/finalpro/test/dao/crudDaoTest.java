package com.neu.finalpro.test.dao;

import com.neu.finalpro.Dao.CrudItemDao;
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
public class crudDaoTest {

    @Mock
    CrudItemDao crudItemDao;

    @Mock
    MainPagePojo mainPagePojo;

    @Mock
    List<MainPagePojo> mainPagePojoList;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void searchItem() {
        try {
            when(crudItemDao.getItemDetail("2")).thenReturn(mainPagePojo);
            MainPagePojo mpp = crudItemDao.getItemDetail("2");
            Assert.assertEquals(mainPagePojo, mpp);
            verify(crudItemDao, times(1)).getItemDetail("2");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getShoppingDetail(){
        try{

            when(crudItemDao.getShoppingDetailR()).thenReturn(mainPagePojoList);
            List<MainPagePojo> result = crudItemDao.getShoppingDetailR();
            Assert.assertEquals(mainPagePojoList, result);
            verify(crudItemDao, times(1)).getShoppingDetailR();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
