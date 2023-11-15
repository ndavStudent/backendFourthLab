package com.example.lab4.Controllers;

import com.example.lab4.DTO.StatusDTO;
import com.example.lab4.DTO.TeaDTO;
import com.example.lab4.Services.TeaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TeaController {
    private final ModelMapper modelMapper;
    private final TeaService teaService;

    @GetMapping("/tea")
    public List<TeaDTO> getTea() {
        return teaService.getTea().stream()
                .map(tea -> modelMapper.map(tea, TeaDTO.class))
                .toList();
    }

    @PostMapping("/tea")
    public TeaDTO createTea(TeaDTO teaDTO) {
        teaService.createTea(teaDTO);
        return teaDTO;
    }

    @DeleteMapping("/tea/{id}")
    public StatusDTO deleteTea(@PathVariable Long id) {
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setStatus(teaService.deleteTea(id));
        return statusDTO;
    }

    @PutMapping("/tea/{id}")
    public TeaDTO updateTea(@PathVariable Long id, @RequestBody TeaDTO teaDTO) {
        return modelMapper.map(teaService.updateTea(id, teaDTO), TeaDTO.class);
    }
}
