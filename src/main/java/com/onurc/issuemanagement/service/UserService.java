package com.onurc.issuemanagement.service;

import com.onurc.issuemanagement.entity.IssueHistory;
import com.onurc.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);

    User getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    User getByUserName(String userName);
}
