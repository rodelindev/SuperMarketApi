package com.rodelindev.SuperMarketApi.controller;

import com.rodelindev.SuperMarketApi.dto.ClientDTO;
import com.rodelindev.SuperMarketApi.model.Client;
import com.rodelindev.SuperMarketApi.service.IClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService service;
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() throws Exception {
        List<ClientDTO> list = service.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Integer id) throws Exception {
        Client obj = service.findById(id);

        return ResponseEntity.ok(convertToDTO(obj));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> save(@Valid @RequestBody ClientDTO dto) throws Exception {
        Client obj = service.save(convertToEntity(dto));

        return ResponseEntity.status(HttpStatus.CREATED).body(convertToDTO(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@Valid @PathVariable Integer id, @RequestBody ClientDTO dto) throws Exception {
        //dto.setIdClient(id);
        Client obj = service.update(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    private ClientDTO convertToDTO(Client entity) {
        return modelMapper.map(entity, ClientDTO.class);
    }

    private Client convertToEntity(ClientDTO dto) {
        return modelMapper.map(dto, Client.class);
    }
}
