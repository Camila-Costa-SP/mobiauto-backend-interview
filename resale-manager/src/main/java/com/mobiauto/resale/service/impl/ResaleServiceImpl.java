package com.mobiauto.resale.service.impl;

import com.mobiauto.resale.dto.ResaleDto;
import com.mobiauto.resale.dto.ResaleRequestDto;
import com.mobiauto.resale.entity.ResaleEntity;
import com.mobiauto.resale.mapper.ResaleMapper;
import com.mobiauto.resale.repository.ResaleRepository;
import com.mobiauto.resale.service.ResaleService;
import com.mobiauto.resale.exceptions.ResaleNotFoundException;
import com.mobiauto.resale.exceptions.ResaleAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResaleServiceImpl implements ResaleService {
    @Autowired
    private ResaleRepository resaleRepository;

    @Autowired
    private ResaleMapper resaleMapper;

    @Transactional
    public ResaleDto createResale(final ResaleRequestDto requestDto) {
        if (resaleRepository.existsByCnpj(requestDto.cnpj())) {
            throw new ResaleAlreadyExistsException();
        }
        var resale = resaleMapper.toResaleEntity(requestDto);
        resale = resaleRepository.save(resale);
        return resaleMapper.toResaleDto(resale);
    }

    @Override
    public ResaleDto getResaleById(final Long id) {
        var resale = findResaleById(id);
        return resaleMapper.toResaleDto(resale);
    }
    @Override
    public ResaleDto updateResale(final Long id, final ResaleRequestDto resaleRequestDto) {
        var resale = findResaleById(id);

        resale.setCnpj(resaleRequestDto.cnpj());
        resale.setSocialName(resaleRequestDto.socialName());
        resaleRepository.save(resale);
        return new ResaleDto(resale.getId(), resale.getCnpj(), resale.getSocialName());
    }
    @Override
    public void deleteResale(Long id) {
        findResaleById(id);
        resaleRepository.deleteById(id);
    }

    private ResaleEntity findResaleById(Long id) {
        return resaleRepository.findById(id)
                .orElseThrow(ResaleNotFoundException::new);
    }
}