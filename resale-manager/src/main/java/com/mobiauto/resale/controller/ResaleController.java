package com.mobiauto.resale.controller;

import com.mobiauto.resale.controller.spec.ResaleApi;
import com.mobiauto.resale.dto.ResaleDto;
import com.mobiauto.resale.dto.ResaleRequestDto;
import com.mobiauto.resale.service.ResaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResaleController implements ResaleApi {

    @Autowired
    private ResaleService resaleService;

    public ResponseEntity<ResaleDto> createResale(ResaleRequestDto resaleRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(resaleService.createResale(resaleRequestDto));
    }

    public ResponseEntity<ResaleDto> getResaleById(Long id) {
        return ResponseEntity.ok(resaleService.getResaleById(id));
    }

    public ResponseEntity<ResaleDto> updateResale(Long id, ResaleRequestDto resaleRequestDto) {
        return ResponseEntity.ok(resaleService.updateResale(id, resaleRequestDto));
    }

    public ResponseEntity<Void> deleteResale(Long id) {
        resaleService.deleteResale(id);
        return ResponseEntity.noContent().build();
    }
}
