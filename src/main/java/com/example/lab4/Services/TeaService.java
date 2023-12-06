package com.example.lab4.Services;

import com.example.lab4.DTO.TeaDTO;
import com.example.lab4.Models.Tea;
import com.example.lab4.Repositories.TeaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeaService {
    private final TeaRepository teaRepository;


    public List<Tea> getTea() {
        return teaRepository.findAll();
    }

    public void createTea(TeaDTO teaDTO) {
        Tea tea = new Tea();
        tea.setName(teaDTO.getName());
        tea.setPrice(teaDTO.getPrice());
        teaRepository.save(tea);
    }

    public String deleteTea(Long id) {
        if(!teaRepository.existsById(id)){
            return "Not found";
        }
        teaRepository.deleteById(id);
        return "Deleted";
    }
    public Tea updateTea(Long id, TeaDTO teaDTO) {
        Tea tea = teaRepository.findById(id).orElseThrow();
        tea.setName(teaDTO.getName());
        tea.setPrice(teaDTO.getPrice());
        return teaRepository.save(tea);
    }
    public boolean existsById(Long id) {
        return teaRepository.existsById(id);
    }
}
