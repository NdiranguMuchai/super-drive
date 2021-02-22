package com.ndirangu.superdrive.service;

import com.ndirangu.superdrive.mapper.FileMapper;
import com.ndirangu.superdrive.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FileService {
    private final FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    public List<File> listAll(Integer userId){

        return fileMapper.list(userId);
    }

    public File findById(Integer fileId){
        return fileMapper.findById(fileId);
    }

    public File findOne(String fileName){
        return fileMapper.findOne(fileName);
    }

    public int upload(File file, MultipartFile multipartFile) throws Exception{
        file.setFileName(multipartFile.getOriginalFilename());
        file.setContentType(multipartFile.getContentType());
        file.setFileSize(String.valueOf(multipartFile.getSize()));
        file.setFileData(multipartFile.getBytes());

        return fileMapper.upload(file);
    }

    public void delete(Integer fileId){
        fileMapper.delete(fileId);
    }
}
