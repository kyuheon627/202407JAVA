package du.db;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {
	@Select("select count(*) from members where email = #{email} and password = #{password}")
	public int isMember(MemberDto memberDto);
	
	@Select("select * from members where email = #{email} and password = #{password}")
	public MemberDto findMember(MemberDto memberDto);
	
	@Insert("INSERT INTO members(member_id, name, email, password) VALUES(members_seq.nextval, #{name}, #{email}, #{password})")
	public void insertMember(MemberDto memberDto);
	
	@Update("UPDATE members set name = #{name}, email = #{email}, password = #{password} where member_id = #{member_id}")
	public void updateMember(MemberDto memberDto);
	
	@Delete("DELETE FROM members WHERE member_id = #{member_id}")
	public void deleteMember(MemberDto memberDto);
}
