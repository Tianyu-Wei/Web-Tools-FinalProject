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

    public int orderSuccess(String username, String orderNum) throws EmailException {
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
}
