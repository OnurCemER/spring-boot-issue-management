package com.onurc.issuemanagement.api;


import com.onurc.issuemanagement.DTO.IssueDto;
import com.onurc.issuemanagement.service.impl.IssueServiceImpl;
import com.onurc.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueServiceImpl issueService;

    public IssueController(IssueServiceImpl issueService) {
        this.issueService = issueService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issueDto = issueService.getById(1L);
        return ResponseEntity.ok(issueDto);
    }

    @PostMapping
    public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueService.save(issue));
    }

    @PutMapping
    public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto project) {
        return ResponseEntity.ok(issueService.update(id, project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueService.delete(id));
    }
}
