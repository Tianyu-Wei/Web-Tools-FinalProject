package com.neu.finalpro.test.dao;

import com.neu.finalpro.Dao.CartDao;
import com.neu.finalpro.pojo.MainPagePojo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import sun.applet.Main;

import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class cartDaoTest {

    @Mock
    CartDao cartDao;

    @Mock
    List<MainPagePojo> mainPagePojoList;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void cartItem(){
        try{
            when(cartDao.getCartItem("tianyu")).thenReturn(mainPagePojoList);
            List<MainPagePojo> result = cartDao.getCartItem("tianyu");
            Assert.assertEquals(mainPagePojoList, result);
            verify(cartDao, times(1)).getCartItem("tianyu");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void addcart(){
        try{
            when(cartDao.addCart("tianyu", 2, 15.2, 2)).thenReturn(1);
            int result = cartDao.addCart("tianyu", 2, 15.2, 2);
            Assert.assertEquals(1, result);
            verify(cartDao, times(1)).addCart("tianyu", 2, 15.2, 2);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deletecart(){
        try{
            when(cartDao.deleteCartItem(2, "tianyu")).thenReturn(1);
            int result = cartDao.deleteCartItem(2, "tianyu");
            Assert.assertEquals(1, result);
            verify(cartDao, times(1)).deleteCartItem(2, "tianyu");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
