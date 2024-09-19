package com.example.demo.service;

import com.example.demo.dto.FileinfoDto;
import com.example.demo.entity.Fileinfo;
import com.example.demo.repository.FileinfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FileService {
	@Autowired private FileinfoRepository repository;
	
	public FileinfoDto insert(FileinfoDto dto) {
		return new FileinfoDto(repository.save(dto.toEntity()));
	} 
	public List<FileinfoDto> list(){
		return repository.findAll().stream().map(f->new FileinfoDto(f)).toList();
	}
	public FileinfoDto select(long filenum) {
		return new FileinfoDto(repository.findById(filenum).get());
	}

	public FileinfoDto update(FileinfoDto dto) {
		Fileinfo file = repository.findById(dto.getFilenum()).get();
		file.setContent(dto.getContent());
		file.setFilesize(dto.getFilesize());
		file.setOrgfilename(dto.getOrgfilename());
		file.setSavefilename(dto.getSavefilename());
		file.setTitle(dto.getTitle());
		file.setWriter(dto.getWriter());
		return new FileinfoDto(file);
	}

	public void delete(long filenum) {
		repository.deleteById(filenum);
	}
}
















