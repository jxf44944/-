package com.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.entity.TAllorderdetail;
import com.entity.TUser;

/**
 * 购物车工具类
 * 
 * @author ASUS
 * 
 */
public class ShoppingCartUtil {
	private String type;

	public ShoppingCartUtil(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return "@" + type;
	}

	/**
	 * 获取当前用户的用户名字
	 * 
	 * @param session
	 * @return
	 */
	public String getCurrentUserName(HttpSession session) {
		TUser user = (TUser) session.getAttribute("loginUser");
		if (user == null)
			return null;
		return user.getName();
	}

	/**
	 * 获取当前用户的用户
	 * 
	 * @param session
	 * @return
	 */
	public TUser getCurrentUser(HttpSession session) {
		TUser user = (TUser) session.getAttribute("loginUser");
		if (user == null)
			return null;
		return user;
	}

	/**
	 * 得到购物车的信息
	 * 
	 * @param session
	 */
	public List<TAllorderdetail> getCartInfo(HttpSession session) {
		List<TAllorderdetail> allorderdetails = new ArrayList<TAllorderdetail>();
		Enumeration<String> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String nextElement = attributeNames.nextElement();
			// 判断是哪一个用户的购物车
			String prefix = getCurrentUserName(session) + getType();
			//System.out.println(prefix);
			if (nextElement.startsWith(prefix)) {
				// 保存信息
				TAllorderdetail allorderdetail = (TAllorderdetail) session.getAttribute(nextElement);
				if (allorderdetail != null) {
					allorderdetails.add(allorderdetail);
				}
			}
		}
		return allorderdetails;
	}

	/**
	 * 清空购物车
	 * 
	 * @param session
	 */
	public void removeCartInfo(HttpSession session) {
		Enumeration<String> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String nextElement = attributeNames.nextElement();
			// 判断是哪一个用户的购物车
			String prefix = getCurrentUserName(session) + getType();
//			System.out.println(prefix);
			if (nextElement.startsWith(prefix)) {
				// 删除信息
				session.removeAttribute(nextElement);
			}
		}
	}

	/**
	 * 获取总价
	 * 
	 * @param session
	 * @return
	 */
	public int getCountCartInfo(HttpSession session) {
		Enumeration<String> attributeNames = session.getAttributeNames();
		int count = 0;// 总价
		while (attributeNames.hasMoreElements()) {
			String nextElement = attributeNames.nextElement();
			// 判断是哪一个用户的购物车
			String prefix = getCurrentUserName(session) + getType();
//			System.out.println(prefix);
			if (nextElement.startsWith(prefix)) {
				// 保存信息
				TAllorderdetail allorderdetail = (TAllorderdetail) session.getAttribute(nextElement);
				if (allorderdetail.getSum() != null && allorderdetail.getSum().length() > 0) {
					count += Integer.parseInt(allorderdetail.getSum());
				}
			}
		}
		return count;
	}
}
