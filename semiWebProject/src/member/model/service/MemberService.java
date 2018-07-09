package member.model.service;

import member.model.dao.MemberDao;
import member.model.vo.MemberVo;

public class MemberService {
	public MemberVo login(String id, String pwd){
//		MemberVo result = null;
//		result = new MemberDao().login(id, pwd);
//		return result;
		//selectMemberList
		return new MemberDao().login(id, pwd);
	}
	public MemberVo getMemberId(String id){
		return new MemberDao().selectMemberId(id);
	}
	
	public int joinMember(MemberVo m){
		return new MemberDao().insertMember(m);
	}
	
	public int setMemberInfo(MemberVo m){
		return new MemberDao().updateMember(m);
	}
	public int deleteMember(String id) {
		return new MemberDao().deleteMember(id);
	}
}
