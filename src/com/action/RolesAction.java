package com.action;

import java.util.List;

import javax.annotation.Resource;

import com.entity.TActer;
import com.entity.TLimit;
import com.entity.TMiddle;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ILimitsService;
import com.service.IRoleService;
import com.service.IRoleandlimitsService;

/***
 * 角色管理action
 * @author Eric
 *
 */
public class RolesAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4868922737555726360L;
	//页面上需要的东西
	/**角色**/
	private TActer role;
	/**角色权限*/
	private List<TMiddle> rolelimitList;
	/***菜单总列表*/
	private List<TLimit> limitList;
	/**角色拥有的菜单列表*/
	private List<TLimit> hadLimitList;
	/**角色 未拥有的菜单列表*/
	private List<TLimit> noHadLimitList;
	
	
	public List<TLimit> getHadLimitList() {
		return hadLimitList;
	}
	public void setHadLimitList(List<TLimit> hadLimitList) {
		this.hadLimitList = hadLimitList;
	}
	public List<TLimit> getNoHadLimitList() {
		return noHadLimitList;
	}
	public void setNoHadLimitList(List<TLimit> noHadLimitList) {
		this.noHadLimitList = noHadLimitList;
	}
	/**角色权限service实现*/
	private IRoleandlimitsService rolelimitservice;

	public IRoleandlimitsService getRolelimitservice() {
		return rolelimitservice;
	}
	@Resource(name="roleandlimitsService")
	public void setRolelimitservice(IRoleandlimitsService rolelimitservice) {
		this.rolelimitservice = rolelimitservice;
	}
//---------------------------------------------------//	
	//页面返回的权限数组
	/*private String[] limitArr;
	public String[] getLimitArr() {
		return limitArr;
	}
	public void setLimitArr(String[] limitArr) {
		this.limitArr = limitArr;
	}*/
	
	private String[] left=null;
	private String[] right=null;	
	
	public String[] getLeft() {
		return left;
	}
	public void setLeft(String[] left) {
		this.left = left;
	}
	public String[] getRight() {
		return right;
	}
	public void setRight(String[] right) {
		this.right = right;
	}

	//--------------------------------------------------//
	/**角色列表*/
	private List<TActer> roleList;
	public List<TActer> getRoleList(){
		return roleList;
	}
	
	/**菜单service实现*/
	private ILimitsService limitService;
	private IRoleService roleService;
	
	public TActer getRole() {
		return role;
	}
	public void setRole(TActer role) {
		this.role = role;
	}
	public List<TMiddle> getRolelimitList() {
		return rolelimitList;
	}
	public void setRolelimitList(List<TMiddle> rolelimitList) {
		this.rolelimitList = rolelimitList;
	}
	public List<TLimit> getLimitList() {
		return limitList;
	}
/*	public void setLimitList(List<Limits> limitList) {
		this.limitList = limitList;
	}*/
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
	
	
	//跳转到添加角色页面
	public String toAddRoles(){
		limitList = limitService.listAll();
		return "success";
	}
	
	//添加角色
	public String addRoles(){
		System.out.println("here is RolesAction addRoles 85 , "+right.length);
		for(int i=0;i<right.length;i++){
			System.out.println(right[i]);
		}
		System.out.println("the role is "+role.toString());
	//System.out.println(role.getRoleandlimitses().size());
	
			if(roleService.insRoles(role,right)){
			System.out.println("here is addRoles 74 ,is OK");
			return "RolesList";
		}else{
			System.out.println("here is addRoles 77, the return is input");
			return "input";
		}
		
	}

	//跳转到list页面
	public String ListRoles(){
		roleList = roleService.list(null);
		return "toList";
	}
	
	//删除角色 
	public String delRoles(){
		
		//System.out.println(role.getRoleId()+"...........roleId....");
		if(roleService.delRoles(role)){
			return "RolesList";
		}else{
			return "input";
		}
	}
	
	//跳转到修改页面
	public String getRolesA(){
		/**
		 * 页面上需要
		 * 1.角色的信息
		 * 2.未拥有的菜单权限
		 * 3.已经拥有的菜单权限
		 * */
		role = roleService.getRoles(role);
		
		//用角色拥有的菜单id组成字符条件 
		StringBuffer sbr = new StringBuffer("");
		//rolelimitList = rolelimitservice.list(" where role_id="+role.getRoleId());
		if(rolelimitList.size()>0){
/*			for(Roleandlimits limit : rolelimitList){
				sbr.append(limit.getLimits().getLimitId()+",");
			}*/
			String idStr = sbr.substring(0, sbr.lastIndexOf(","));
			System.out.println(idStr);
			hadLimitList = limitService.list(" where limit_id in("+idStr+")");
			noHadLimitList = limitService.list(" where limit_id not in("+idStr+")");
		}else{
			hadLimitList = limitService.list(null);
		//	noHadLimitList = 
		}
		return "success";
	}
	
	
	//修改角色 
	public String uptRoles(){
		/***
		 * 修改角色前应该先将角色本来拥有的菜单全部删除，再重新插入
		 */
		System.out.println("here is uptRoles 131 .... ");
	//	System.out.println(role.toString());
		//System.out.println(role.getRoleandlimitses().size()+"...."+role.getRoleandlimitses().toString());
		if(roleService.uptRoles(role,right)){
			System.out.println("here is RolesAction 204 ..is ok");
			return "RolesList";
		}else{
			return "input";
		}
	}
	
	
}
