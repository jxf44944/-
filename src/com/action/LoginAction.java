package com.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.entity.TActer;
import com.entity.TLimit;
import com.entity.TMiddle;
import com.entity.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ILimitsService;
import com.service.IRoleService;
import com.service.IRoleandlimitsService;
import com.service.IUsersService;

/***
 * 用户登录action
 * @author Feng
 *
 */
public class LoginAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9028325328939969643L;
	/**
	 * 登录操作
	 * 1.需要将页面上的用户名，密码封装到user里，传到后台进行验证
	 * 2.验证通过，需要到后台获取用户对应角色所拥有的菜单项，返回到左侧的菜单栏中
	 *
	 * **/
	
	private IUsersService userService;
	private IRoleService roleService;
	private IRoleandlimitsService roleandlimitService;
	private ILimitsService limitService;
	
	/**登录的用户**/
	private TUser user;
	/**用户所拥有的权限*/
	private List<TLimit> limitList1;
	private List<TLimit> limitList2;
	private List<TLimit> limitList3;
	private List<TLimit> limitList4;
	
	
	public IRoleandlimitsService getRoleandlimitService() {
		return roleandlimitService;
	}
	@Resource(name="roleandlimitsService")
	public void setRoleandlimitService(IRoleandlimitsService roleandlimitService) {
		this.roleandlimitService = roleandlimitService;
	}
	public ILimitsService getLimitService() {
		return limitService;
	}
	@Resource(name="limitsService")
	public void setLimitService(ILimitsService limitService) {
		this.limitService = limitService;
	}
	public IRoleService getRoleService() {
		return roleService;
	}
	@Resource(name="roleService")
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	public IUsersService getUserService() {
		return userService;
	}
	@Resource(name="usersService")
	public void setUserService(IUsersService userService) {
		this.userService = userService;
	}
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	
	public List<TLimit> getLimitList1() {
		return limitList1;
	}
	public void setLimitList1(List<TLimit> limitList1) {
		this.limitList1 = limitList1;
	}
	public List<TLimit> getLimitList2() {
		return limitList2;
	}
	public void setLimitList2(List<TLimit> limitList2) {
		this.limitList2 = limitList2;
	}
	public List<TLimit> getLimitList3() {
		return limitList3;
	}
	public void setLimitList3(List<TLimit> limitList3) {
		this.limitList3 = limitList3;
	}
	public List<TLimit> getLimitList4() {
		return limitList4;
	}
	public void setLimitList4(List<TLimit> limitList4) {
		this.limitList4 = limitList4;
	}
	/**登录验证
	 * 通过验证-->获取角色-->获取角色菜单-->获取菜单-->返回页面
	 * **/
	@SuppressWarnings("unchecked")
	public String checkLogin(){
		System.out.println("here is CheckLogin 88  here is ok........");
		
		TUser retUser = userService.checkUser(user);
		if(retUser!=null){
			TActer role = retUser.getTActer();
			TActer retRole = roleService.getRoles(role);//用户验证的时候已经拿到了角色 了，需不需要再去拿一次呢？
		//	System.out.println(retRole.getRoleGrade()+"..........grade ");
		//	StringBuffer sbr = new StringBuffer("");
			List<TMiddle> roleAndlimitList = roleandlimitService.list("where acterid="+role.getActerid());
			List<TLimit> limitlist1=new ArrayList<TLimit>();
			List<TLimit> limitlist2=new ArrayList<TLimit>();
			List<TLimit> limitlist3=new ArrayList<TLimit>();
			List<TLimit> limitlist4=new ArrayList<TLimit>();
			for(TMiddle randl : roleAndlimitList){
				TLimit limit = randl.getTLimit();
				if(limit.getRank()==1){
					System.out.println(limit.getRank());
					limitlist1.add(limit);
				}
				else if(limit.getRank()==2)	
					limitlist2.add(limit);
				else if(limit.getRank()==3)	
					limitlist3.add(limit);
				else if(limit.getRank()==4)	
					limitlist4.add(limit);
				
			}
			limitList1=limitlist1;
			limitList2=limitlist2;
			limitList3=limitlist3;
			limitList4=limitlist4;
/*			for(TLimit limit : limitList2){
				System.out.println(limit.getLimitName()+"..106.."+limit.getLimitUrl());
			}*/
			Map  session=ActionContext.getContext().getSession();
			session.put("mylimitlist1",limitList1);
			session.put("mylimitlist2",limitList2);
			session.put("mylimitlist3",limitList3);
			session.put("mylimitlist4",limitList4);
			session.put("loginUser", retUser);
			session.put("role", retRole);
			return "LoginSuccess";
		}
		
		return "input";
	}
	public String ExitLogin(){
//		ActionContext.getContext().getSession().remove("mylimitlist1");
//		ActionContext.getContext().getSession().remove("mylimitlist2");
//		ActionContext.getContext().getSession().remove("mylimitlist3");
//		ActionContext.getContext().getSession().remove("mylimitlist4");
//		ActionContext.getContext().getSession().remove("loginUser");
//		ActionContext.getContext().getSession().remove("role");
		ActionContext.getContext().getSession().clear();
		return "Exitsuccess";
	}
	public String ToLogin(){
		return "gosuccess";
	}
	
	@SuppressWarnings("unchecked")
	public String EnLogin(){
		List<TLimit>  limit= (List<TLimit>) ActionContext.getContext().getSession().get("mylimitlist2");
		if(limit!=null)
			return "LoginSuccess";
		
		return "gosuccess";
	}
	
	
}
