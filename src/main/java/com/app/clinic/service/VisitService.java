package com.app.clinic.service;

import com.app.clinic.model.dto.VisitDto;
import com.app.clinic.repository.VisitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitRepository repository;
    private final VisitMapper mapper;

    public List<VisitDto> findAll() {
       return mapper.mapToVisitDtoList(repository.findAll());
    }

    public Optional<VisitDto> findById(Long id) {
        return repository.findById(id).map(mapper::mapToVisitDto);
    }
}
