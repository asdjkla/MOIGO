package com.kh.moigo.groups.model.service;


import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.moigo.admin.model.vo.PageInfo;
import com.kh.moigo.groups.model.dao.GroupsDao;

import com.kh.moigo.groups.model.vo.GroupMember;

import com.kh.moigo.groups.model.exception.GroupsExeption;
import com.kh.moigo.groups.model.vo.Post;
import com.kh.moigo.groups.model.vo.PostWithMem;

@Service
public class GroupsServiceImpl implements GroupsService {
	
	@Autowired
	private GroupsDao groupDao;


	@Override
	public int addPost(Post p) {
	
		int result = groupDao.addPost(p);
		
		if(result==0) throw new GroupsExeption();
		
		return result;
	}

	@Override
	public ArrayList<PostWithMem> selectPostList(String groupNo, PageInfo p) {
		
		return groupDao.selectPostList(groupNo, p);
	}

	@Override
	public int selectPostCnt(String groupNo) {	
		return groupDao.selectPostCnt(groupNo);
	}
	
	//--------------------------------------------------------------------- 혜진
	
	@Override
	public List<Map<String, String>> selectGroupMemberList(String groupNo) {
		return groupDao.selectGroupMemberList(groupNo);
	}
	
	@Override
	public List<Map<String, String>> searchGroupMemberList(Map<String, String> searchMap) {
		return groupDao.searchGroupMemberList(searchMap);
	}

	@Override
	public int updateGroupMember(GroupMember groupMember) {
		return groupDao.updateGroupMember(groupMember);
	}

	@Override
	public int deleteGroup(String groupNo) {
		return groupDao.deleteGroup(groupNo);
	}

}
