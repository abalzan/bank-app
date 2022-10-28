package com.andrei.bankapp.repository;

import com.andrei.bankapp.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    @Query(value = "from Notice n where CURDATE() BETWEEN noticeBegDate AND noticeEndDate")
    List<Notice> findAllActiveNotices();
}
