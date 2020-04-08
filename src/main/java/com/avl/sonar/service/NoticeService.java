package com.avl.sonar.service;

import com.avl.sonar.dto.NoticeDto;
import java.util.List;
import java.util.UUID;

public interface NoticeService {
  NoticeDto getNoticeById(UUID id);
  Boolean createNotice(NoticeDto dto);
  List<NoticeDto> getAllNotices();
  boolean deleteNoticeById(UUID id);
}
