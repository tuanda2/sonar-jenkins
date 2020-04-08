package com.avl.sonar.service.impl;

import com.avl.sonar.dto.NoticeDto;
import com.avl.sonar.service.NoticeService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NoticeServiceImpl implements NoticeService {

  private static List<NoticeDto> notices = new ArrayList<>();

  @Override
  public NoticeDto getNoticeById(UUID id) {
    return notices.stream().filter(e -> e.getId().equals(id)).findFirst()
        .orElse(new NoticeDto());
  }

  @Override
  public Boolean createNotice(NoticeDto dto) {
    log.info("Service: createNotice");
    if (dto != null) {
      dto.setId(UUID.randomUUID());
      notices.add(dto);
      return true;
    }
    return false;
  }

  @Override
  public List<NoticeDto> getAllNotices() {
    log.info("Service: getAllNotices");
    return notices;
  }

  @Override
  public boolean deleteNoticeById(UUID id) {
    notices.removeIf(e -> e.getId().equals(id));
    return true;
  }
}
