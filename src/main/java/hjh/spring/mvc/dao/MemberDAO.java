package hjh.spring.mvc.dao;

import hjh.spring.mvc.vo.MemberVO;

public interface MemberDAO {

	int insertMember(MemberVO mvo);

	MemberVO selectOneMember(String uid);

	int selectOneMember(MemberVO m); //다중정리 (오버로딩)

	int selectCountUserid(String uid);

}
