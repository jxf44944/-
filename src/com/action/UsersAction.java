package com.action;

import java.util.List;

import javax.annotation.Resource;

import com.entity.TActer;
import com.entity.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IRoleService;
import com.service.IUsersService;
/***
 * 用户action类
 * @author Feng
 * 2014-02-18
 */
public class UsersAction extends ActionSupport{
	
	private static final long serialVersionUID = 6374777244509185789L;
	/**用户service接口*/
	private IUsersService userService;
	/**角色service接口**/
	private IRoleService roleService;
	/**用户**/
	private TUser user;
	/**用户列表**/
	private List<TUser> userList;
	/***角色列表**/
	private List<TActer> roleList;
	
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
	public List<TUser> getUserList() {
		return userList;
	}
/*	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}*/
	public List<TActer> getRoleList() {
		return roleList;
	}
	public IRoleService getRoleService() {
		return roleService;
	}
	@Resource(name="roleService")
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
/*	public IDeptsService getDeptService() {
		return deptService;
	}
	@Resource(name="deptsService")
	public void setDeptService(IDeptsService deptService) {
		this.deptService = deptService;
	}*/
	
	//跳转到添加页面
	public String toAddUsers(){
		roleList= roleService.list(null);
		//sdeptList = deptService.list(null);
		//System.out.println("roleList.size::::"+roleList.size()+"......deptList.size:::"+deptList.size());
		
		return "success";
	}
	
	//添加用户
	public String addUsers(){
		
		if(userService.insUsers(user)){
			return "UsersList";
		}else{
			return "input";
		}
	}
	
	//跳转到列表页面
	public String ListUsers(){
		userList = userService.listAll();
		return "toList";
	}
	
	//跳转到修改页面
	public String getUsersA(){
		user=userService.getUsers(user);
		return "success";
	}
	
	//修改
	public String UpdateUsers(){
		userService.uptUsers(user);
		ActionContext.getContext().getSession().remove("mylimitlist");
		ActionContext.getContext().getSession().remove("loginUser");
		ActionContext.getContext().getSession().remove("role");
		return "Exitsuccess";
	}
	
	//删除
	public String delUsers(){
		if(userService.delUsers(user)){
			return "UsersList";
		}else{
			return "input";
		}
	
	}
	
}
