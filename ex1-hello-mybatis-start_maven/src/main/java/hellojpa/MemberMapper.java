package hellojpa;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MemberMapper {

	@Insert("INSERT INTO MEMBER (ID, NAME, AGE) VALUES (#{id}, #{username}, #{age})")
	void insertMember(Member member);

	@Update("UPDATE MEMBER SET AGE = #{age} WHERE ID = #{id}")
	void updateMember(Member member);

	@Select("SELECT * FROM MEMBER WHERE ID = #{id}")
	Member selectMember(@Param("id") String id);

	@Select("SELECT * FROM MEMBER")
	List<Member> selectAllMembers();

	@Delete("DELETE FROM MEMBER WHERE ID = #{id}")
	void deleteMember(@Param("id") String id);
}