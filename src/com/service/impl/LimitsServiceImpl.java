package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ILimitsDao;
import com.entity.TLimit;
import com.service.ILimitsService;

/***
 * 菜单service实现
 * @author Feng
 * 2014-02-17
 * 
 */
@Service("limitsService")
public class LimitsServiceImpl implements ILimitsService{

	private ILimitsDao limitDao; 
	public ILimitsDao getLimitDao() {
		return limitDao;
	}
	@Resource(name="limitsDao")
	public void setLimitDao(ILimitsDao limitDao) {
		this.limitDao = limitDao;
	}
	
	
	/**新增*/
	public boolean insLimits(TLimit limit){
		System.out.println("here is the limitservice 34 , the motheds insLimits isnot complate ");
		return false;
	}
	
	/**删除*/
	public boolean delLimits(TLimit limit){
		System.out.println("here is the limitservice 40 , the motheds dellimits isnot complate ");
		return false;
	}
	
	/**修改**/
	public boolean uptLimits(TLimit limit){
		System.out.println("here is the limitservice 46 , the motheds uptLimits isnot complate ");
		return false;
	}
	
	/**查找单条记录信息**/
	public TLimit getLimits(TLimit limit){
		System.out.println("here is the limitservice 52 , the motheds getLimits isnot complate ");
		return null;
	}
	
	/**查找列表
	 * */
	public List<TLimit> listAll(){
		List<TLimit> list = limitDao.list(null);
		System.out.println("here is limitService 60 ");
		return list;
	}
	/***
	 * 按条件搜索
	 */
	public List<TLimit> list(String hql){
		
		List<TLimit> list = limitDao.list(hql);
		
		return list;
	}

}
