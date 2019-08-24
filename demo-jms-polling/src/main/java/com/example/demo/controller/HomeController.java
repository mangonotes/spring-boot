package com.example.demo.controller;

import com.example.demo.messages.IMessageSender;
import com.example.demo.service.employee.IEmployeeService;
import com.example.demo.service.message.IMessageService;
import com.example.demo.ui.dto.EmployeeDTO;
import com.example.demo.ui.dto.JmsResult;
import com.example.demo.ui.dto.MessageJsonDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
public class HomeController {
    private final Map<Integer ,DeferredResult<JmsResult>> jmsRequest = new ConcurrentHashMap<Integer, DeferredResult<JmsResult>>();
    @Autowired
    private final IEmployeeService employeeService;
    @Autowired
    private IMessageService messageService;
    public HomeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping ("/insert")
    public ResponseEntity <String> getInsert(@RequestBody  EmployeeDTO employeeDTO){
        System.out.println(employeeDTO.getName() + employeeDTO.getNationality() + employeeDTO.getDoj());
         employeeService.insert(employeeDTO);
        return new ResponseEntity<String>("testing" + "save data", HttpStatus.ACCEPTED) ;
    }
    @GetMapping("allEmployees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees()
    {
    return new ResponseEntity<List<EmployeeDTO>>(employeeService.getAllEmployee(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/sendMessage")
    public DeferredResult<JmsResult> sendMessage(@RequestParam("message") String message)
    {
        int id = messageService.saveDataAndSend(message);
        JmsResult jmsResult = new JmsResult();
        jmsResult.setId(id);
        jmsResult.setMessage(message);
        final DeferredResult<JmsResult> deferredResult = new DeferredResult<JmsResult>(18000l,jmsResult);
        jmsRequest.put(id, deferredResult);
        deferredResult.onCompletion( () -> {
           jmsRequest.remove(id);
        } );

        System.out.println("started saved date id" + id);
        return deferredResult;
    }
    @Scheduled(fixedRate = 1000)
    private void running()
    {
        jmsRequest.forEach((k,v)->{
                     if (messageService.isReceivedResponse(k))
            {
               String message = messageService.updateStatusData(k, 3);
                JmsResult result1 = new JmsResult();
                result1.setId(k);
                result1.setMessage(message);
                v.setResult(result1);
            }
        });

    }
}
