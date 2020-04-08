package com.avl.sonar.controller;

import com.avl.sonar.dto.BaseResponse;
import com.avl.sonar.dto.NoticeDto;
import com.avl.sonar.service.NoticeService;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notices")
@Slf4j
public class NoticeController {
  @Autowired
  NoticeService noticeService;


  @GetMapping
  public ResponseEntity<BaseResponse> getAllNotices(){
    log.info("Controller: getAllNotices");
    List<NoticeDto> notices = noticeService.getAllNotices();
    return new ResponseEntity(BaseResponse.create(notices), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Boolean> createNotice(@RequestBody NoticeDto request){
    log.info("Controller: createNotice");
    Boolean result = noticeService.createNotice(request);
    return new ResponseEntity(BaseResponse.create(result), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> deleteNotice(@PathVariable(value = "id") UUID id){
    Boolean result = noticeService.deleteNoticeById(id);
    return new ResponseEntity(BaseResponse.create(result), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<NoticeDto> getNotice(@PathVariable(value = "id") UUID id){
    NoticeDto notice = noticeService.getNoticeById(id);
    return new ResponseEntity(BaseResponse.create(notice), HttpStatus.OK);
  }
}
