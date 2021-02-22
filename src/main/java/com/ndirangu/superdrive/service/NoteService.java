package com.ndirangu.superdrive.service;

import com.ndirangu.superdrive.mapper.NoteMapper;
import com.ndirangu.superdrive.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    public int createNote(Note note) {
        return noteMapper.insert(note);
    }

    public List<Note> getNotes(Integer userId)
    {
        return noteMapper.getNotes(userId);
    }

    public void update(Note note){
        noteMapper.updateNote(note);
    }

    public Note findOne(Integer noteId){
        return noteMapper.findOne(noteId);
    }

    public void deleteNote(Integer noteId){
        noteMapper.deleteNote(noteId);
    }

    public Note findByTitleAndDesc(String noteTitle, String noteDescription){
        return noteMapper.findByTitleAndDesc(noteTitle, noteDescription);
    }
}
