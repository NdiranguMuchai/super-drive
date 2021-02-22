package com.ndirangu.superdrive.mapper;

import com.ndirangu.superdrive.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM NOTES WHERE userid = #{userId}")
    List<Note> getNotes(Integer userId);

    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid) VALUES(#{noteTitle},#{noteDescription},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insert(Note note);

    @Update("UPDATE NOTES SET notetitle = #{noteTitle}, notedescription = #{noteDescription} WHERE noteid = #{noteId}")
    void updateNote(Note note);

    @Delete("DELETE FROM NOTES WHERE noteid =#{noteId}")
    void deleteNote(Integer noteId);

    @Select("SELECT * FROM NOTES WHERE noteid = #{noteId}")
    Note findOne(Integer noteId);

    @Select("SELECT * FROM NOTES WHERE notetitle = #{noteTitle} AND notedescription =#{noteDescription} " )
    Note findByTitleAndDesc(String noteTitle, String noteDescription);

}
