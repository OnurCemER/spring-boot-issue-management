package com.onurc.issuemanagement.service;

import com.onurc.issuemanagement.DTO.IssueDto;
import com.onurc.issuemanagement.entity.Issue;
import com.onurc.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long id);

    IssueDto update(Long id, IssueDto issue);
}
