package vnua.fita.bookstore.util;

import javax.servlet.http.HttpSession;

import vnua.fita.bookstore.bean.User;

public class MyUtil {
	public static void storeLoginedUser(HttpSession session, User loginedUser) {
		session.setAttribute("loginedUser", loginedUser);
	}
}
