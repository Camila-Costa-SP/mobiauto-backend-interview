package com.mobiauto.resale.service;

import com.mobiauto.resale.dto.ResaleDto;
import com.mobiauto.resale.dto.ResaleRequestDto;

public interface ResaleService {
    ResaleDto createResale(ResaleRequestDto resaleRequestDto);

    ResaleDto getResaleById(Long id);

    ResaleDto updateResale(Long id, ResaleRequestDto resaleRequestDto);

    void deleteResale(Long id);
}