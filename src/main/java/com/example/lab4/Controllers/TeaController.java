package com.example.lab4.Controllers;

import com.example.lab4.DTO.ResponseDTO;
import com.example.lab4.DTO.StatusDTO;
import com.example.lab4.DTO.TeaDTO;
import com.example.lab4.Exceptions.EmptyResponceException;
import com.example.lab4.Exceptions.PostTeaException;
import com.example.lab4.Exceptions.PutIdException;
import com.example.lab4.Exceptions.WrongTeaIdException;
import com.example.lab4.Services.TeaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TeaController {
    private final ModelMapper modelMapper;
    private final TeaService teaService;

    @GetMapping("/tea")
    public ResponseDTO getTea() throws EmptyResponceException {
        List<TeaDTO> teaDTOList = teaService.getTea().stream()
                .map(tea -> modelMapper.map(tea, TeaDTO.class))
                .toList();
        if (teaDTOList.size() == 0){
            throw new EmptyResponceException("Empty response");
        }
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(teaDTOList);
        responseDTO.setStatus("Success");
        return responseDTO;
    }

    @ExceptionHandler(EmptyResponceException.class)
    public ResponseDTO emptyHandler(EmptyResponceException e){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("empty");
        responseDTO.setData(e.getMessage());
        return responseDTO;
    }

    @PostMapping("/tea")
    public ResponseDTO createTea(@RequestBody TeaDTO teaDTO) throws Exception {
        try{
            teaService.createTea(teaDTO);
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Success");
            responseDTO.setData(teaDTO);
            return responseDTO;
        } catch (Exception e) {
            throw new Exception("bad request");
        }
    }
    @ExceptionHandler(Exception.class)
    public ResponseDTO handleException(Exception e) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("Failed");
        responseDTO.setData(e.getMessage());
        return responseDTO;
    }

    @DeleteMapping("/tea/{id}")
    public ResponseDTO deleteTea(@PathVariable Long id) throws WrongTeaIdException {
        try {
            StatusDTO statusDTO = new StatusDTO();
            String status = teaService.deleteTea(id);
            if (status.equals("Not found")){
                throw new WrongTeaIdException("Wrong tea id");
            }
            statusDTO.setStatus(status);
            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setStatus("Delete Success");
            responseDTO.setData(statusDTO);
            return responseDTO;
        } catch (Exception e){
            throw new WrongTeaIdException("Wrong tea id");
        }

    }

    @ExceptionHandler(WrongTeaIdException.class)
    public ResponseDTO wrongTeaIdHandler(WrongTeaIdException e){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("Delete Failed");
        responseDTO.setData(e.getMessage());
        return responseDTO;
    }

    @PutMapping("/tea/{id}")
    public TeaDTO updateTea(@PathVariable Long id, @RequestBody TeaDTO teaDTO) throws PutIdException {
        if (!teaService.existsById(id)){
            throw new PutIdException("Not found");
        }
        return modelMapper.map(teaService.updateTea(id, teaDTO), TeaDTO.class);
    }

    @ExceptionHandler(PutIdException.class)
    public ResponseDTO putIdHandler(PutIdException e){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatus("Update Failed");
        responseDTO.setData(e.getMessage());
        return responseDTO;
    }
}
