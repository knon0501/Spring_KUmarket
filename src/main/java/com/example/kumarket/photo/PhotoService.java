package com.example.kumarket.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository){
        this.photoRepository=photoRepository;
    }

    public List<PhotoDto> findAllPhotos(){
        List<PhotoEntity> photos = photoRepository.findAll();
        List<PhotoDto> photosDto = new ArrayList<>();
        for(PhotoEntity photo: photos)
            photosDto.add(photo.toDto());
        return photosDto;
    }
}
