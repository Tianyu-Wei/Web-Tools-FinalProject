package com.neu.finalpro.controller;

import com.neu.finalpro.Dao.UserAccountDao;
import com.neu.finalpro.pojo.UserAccountPojo;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailController {

    public int SignupSuccess(String username, String emailadd) throws EmailException {
        int result = 0;

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("tianyuwei69@gmail.com", "15897089071wtY"));
        email.setSSLOnConnect(true);
        email.setFrom("tianyuwei69@gmail.com");
        email.setSubject("Sign Up successfully!");
        email.setMsg("Dear " + username + ": Your account have successfully signed up!");
        email.addTo(emailadd);
        email.send();
        result = 1;
        return result;
    }

    public int UserUpdateSuccess(String username) throws EmailException {
        int result = 0;
        UserAccountDao uad = new UserAccountDao();
        UserAccountPojo uap = uad.getUserByName(username);
        String emailadd = uap.getEmail();

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("tianyuwei69@gmail.com", "15897089071wtY"));
        email.setSSLOnConnect(true);
        email.setFrom("tianyuwei69@gmail.com");
        email.setSubject("Updated successfully!");
        email.setMsg("Dear " + username + ": Your account have successfully Updated!");
        email.addTo(emailadd);
        email.send();
        result = 1;
        return result;
    }

    public int UserDeleteSuccess(String username) throws EmailException {
        int result = 0;
        UserAccountDao uad = new UserAccountDao();
        UserAccountPojo uap = uad.getUserByName(username);
        String emailadd = uap.getEmail();

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("tianyuwei69@gmail.com", "15897089071wtY"));
        email.setSSLOnConnect(true);
        email.setFrom("tianyuwei69@gmail.com");
        email.setSubject("Account deleted successfully!");
        email.setMsg("Dear " + username + ": Your account have successfully deleted!");
        email.addTo(emailadd);
        email.send();
        result = 1;
        return result;
    }

    public int responseMessage(String message, String username) throws EmailException {
        int result = 0;
        UserAccountDao uad = new UserAccountDao();
        UserAccountPojo uap = uad.getUserByName(username);
        String emailadd = uap.getEmail();

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("tianyuwei69@gmail.com", "15897089071wtY"));
        email.setSSLOnConnect(true);
        email.setFrom("tianyuwei69@gmail.com");
        email.setSubject("Regarding the question");
        email.setMsg(message);
        email.addTo(emailadd);
        email.send();
        result = 1;
        return result;
    }

    public int orderSuccess(String username) throws EmailException {
        int result = 0;
        UserAccountDao uad = new UserAccountDao();
        UserAccountPojo uap = uad.getUserByName(username);
        String emailadd = uap.getEmail();

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("tianyuwei69@gmail.com", "15897089071wtY"));
        email.setSSLOnConnect(true);
        email.setFrom("tianyuwei69@gmail.com");
        email.setSubject("Order recieved successfully!");
        email.setMsg("Dear " + username + ": Your Order orderNum recieved!");
        email.addTo(emailadd);
        email.send();
        result = 1;
        return result;
    }

    public int orderReturnRecieved(String username, String orderNum) throws EmailException {
        int result = 0;
        UserAccountDao uad = new UserAccountDao();
        UserAccountPojo uap = uad.getUserByName(username);
        String emailadd = uap.getEmail();

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("tianyuwei69@gmail.com", "15897089071wtY"));
        email.setSSLOnConnect(true);
        email.setFrom("tianyuwei69@gmail.com");
        email.setSubject("Order return");
        email.setMsg("Dear " + username + ": Your order: " + orderNum + " We have recieved your return requests, please wait for seller to process!");
        email.addTo(emailadd);
        email.send();
        result = 1;
        return result;
    }

    public int orderReturnSuccess(String username, String orderNum) throws EmailException {
        int result = 0;
        UserAccountDao uad = new UserAccountDao();
        UserAccountPojo uap = uad.getUserByName(username);
        String emailadd = uap.getEmail();

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("tianyuwei69@gmail.com", "15897089071wtY"));
        email.setSSLOnConnect(true);
        email.setFrom("tianyuwei69@gmail.com");
        email.setSubject("Return success");
        email.setMsg("Dear " + username + ": Your order: " + orderNum + " has returned successfully, your refund typically need less than 48 hours to process!");
        email.addTo(emailadd);
        email.send();
        result = 1;
        return result;
    }

    public int orderReturnFailed(String username, String orderNum) throws EmailException {
        int result = 0;
        UserAccountDao uad = new UserAccountDao();
        UserAccountPojo uap = uad.getUserByName(username);
        String emailadd = uap.getEmail();

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("tianyuwei69@gmail.com", "15897089071wtY"));
        email.setSSLOnConnect(true);
        email.setFrom("tianyuwei69@gmail.com");
        email.setSubject("Return failed");
        email.setMsg("Dear " + username + ": Your order: " + orderNum + " has returned failed, Please contact your seller for more information!");
        email.addTo(emailadd);
        email.send();
        result = 1;
        return result;
    }

    public int orderShipped(String username, String orderNum) throws EmailException {
        int result = 0;
        UserAccountDao uad = new UserAccountDao();
        UserAccountPojo uap = uad.getUserByName(username);
        String emailadd = uap.getEmail();

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("tianyuwei69@gmail.com", "15897089071wtY"));
        email.setSSLOnConnect(true);
        email.setFrom("tianyuwei69@gmail.com");
        email.setSubject("Order shipped");
        email.setMsg("Dear " + username + ": Your order: " + orderNum + " has shipped! Please wait for the delivery.");
        email.addTo(emailadd);
        email.send();
        result = 1;
        return result;
    }

    public int orderCanceled(String username, String orderNum) throws EmailException {
        int result = 0;
        UserAccountDao uad = new UserAccountDao();
        UserAccountPojo uap = uad.getUserByName(username);
        String emailadd = uap.getEmail();

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("tianyuwei69@gmail.com", "15897089071wtY"));
        email.setSSLOnConnect(true);
        email.setFrom("tianyuwei69@gmail.com");
        email.setSubject("Order canceled");
        email.setMsg("Dear " + username + ": Your order: " + orderNum + " has been canceled by seller, Please contact seller for more information.");
        email.addTo(emailadd);
        email.send();
        result = 1;
        return result;
    }
}
