package com.example.lab4.Controllers;

import com.example.lab4.DTO.ResponseDTO;
import com.example.lab4.DTO.StatusDTO;
import com.example.lab4.DTO.TeaDTO;
import com.example.lab4.Exceptions.EmptyResponseException;
import com.example.lab4.Exceptions.PostTeaException;
import com.example.lab4.Exceptions.PutIdException;
import com.example.lab4.Exceptions.WrongTeaIdException;
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
    public ResponseDTO getTea() throws EmptyResponseException {
        List<TeaDTO> teaDTOList = teaService.getTea().stream()
                .map(tea -> modelMapper.map(tea, TeaDTO.class))
                .toList();
        if (teaDTOList.isEmpty()) {
            throw new EmptyResponseException("404", "Чай закончился");
        }
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(teaDTOList);
        responseDTO.setStatus("Success");
        return responseDTO;
    }


    @PostMapping("/tea")
    public ResponseDTO createTea(@RequestBody TeaDTO teaDTO) throws PostTeaException {
        if (teaDTO.getName().isEmpty()) {
            throw new PostTeaException("400", "Название чая не может быть пустым");
        }
        teaService.createTea(teaDTO);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("Теперь на один сорт чая больше");
        responseDTO.setData(teaDTO);
        return responseDTO;

    }


    @DeleteMapping("/tea/{id}")
    public ResponseDTO deleteTea(@PathVariable Long id) throws WrongTeaIdException {
        StatusDTO statusDTO = new StatusDTO();
        String status = teaService.deleteTea(id);
        if (status.equals("Not found")) {
            throw new WrongTeaIdException("400", "Неверный id чая");
        }
        statusDTO.setStatus(status);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("Такого чая больше нет");
        responseDTO.setData(statusDTO);
        return responseDTO;

    }

    @PutMapping("/tea/{id}")
    public TeaDTO updateTea(@PathVariable Long id, @RequestBody TeaDTO teaDTO) throws PutIdException {
        if (!teaService.existsById(id)) {
            throw new PutIdException("404", "Такого чая нет");
        }
        return modelMapper.map(teaService.updateTea(id, teaDTO), TeaDTO.class);
    }
}
