package com.tiendd.bookservice.api.endpoint;

import com.tiendd.bookservice.api.model.Record;
import com.tiendd.bookservice.api.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/record")
public class RecordEndpoint {
    @Autowired
    private RecordService recordService;

    @GetMapping("/all")
    public List<Object> getListRecord() {
        return recordService.findAll();
    }

    @GetMapping("/")
    public Record getDetailRecord(@PathVariable(name = "id") Long id){
        return (Record) recordService.findById(id);
    }

    @PutMapping("/")
    public Record edit(@RequestBody Record record){
        return (Record) recordService.editItem(record);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(name = "id") Long id){
        boolean result = recordService.deleteItem(id);
        if(result){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public Record add(@RequestBody Record record) {
        return (Record) recordService.addItem(record);
    }
}
