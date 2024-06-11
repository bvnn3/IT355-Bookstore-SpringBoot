package com.bookstore.IT355_Project.controller;

import com.bookstore.IT355_Project.entity.Writer;
import com.bookstore.IT355_Project.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/writer")
@RequiredArgsConstructor
public class WriterController {

    private final WriterService writerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Writer>> getAll(){
        return ResponseEntity.ok(writerService.findAll());
    }

    @GetMapping("/{writerId}")
    public ResponseEntity<Writer> getById(@PathVariable Integer writerId){
        return ResponseEntity.ok(writerService.findById(writerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "writerNotFound")));
    }
    
    @PostMapping("/addWriter")
    public ResponseEntity<Writer> save(@RequestBody Writer writer){
        return ResponseEntity.ok(writerService.save(writer));
    }
    
    @PutMapping("/updateWriter")
    public ResponseEntity<Writer> update(@RequestBody Writer writer){
        return ResponseEntity.ok(writerService.update(writer));
    }
    @DeleteMapping("/{writerId}")
    public ResponseEntity<Writer> deleteById(@PathVariable Integer writerId){
        writerService.deleteById(writerId);
        return ResponseEntity.ok().build();
    }
    
}
