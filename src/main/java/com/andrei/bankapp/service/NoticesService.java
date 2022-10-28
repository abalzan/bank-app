package com.andrei.bankapp.service;

import com.andrei.bankapp.model.Notice;
import com.andrei.bankapp.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticesService {

    private final NoticeRepository noticeRepository;
    public List<Notice> getAllNotices() {
        return noticeRepository.findAllActiveNotices();
    }
}
