package com.ndirangu.superdrive.mapper;

import com.ndirangu.superdrive.model.Credential;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CredentialMapper {
    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userId}")
    List<Credential> listAllCredentials(Integer userId);

    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialId}")
    Credential findOne(Integer credentialId);

    @Insert("INSERT INTO CREDENTIALS(url, username, key, password, userid) VALUES(#{url}, #{username}, #{key}, #{password}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialId")
    Integer create(Credential credential);

    @Delete("DELETE FROM CREDENTIALS WHERE credentialid = #{credentialId}")
    void  delete(Integer credentialId);

    @Update("UPDATE CREDENTIALS SET url=#{url}, username =#{username}, key =#{key}, password =#{password} WHERE credentialid =#{credentialId}")
    void update(Credential credential);
}
