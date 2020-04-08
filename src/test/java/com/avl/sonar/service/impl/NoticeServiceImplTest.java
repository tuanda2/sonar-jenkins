package com.avl.sonar.service.impl;

import com.avl.sonar.dto.NoticeDto;
import com.avl.sonar.service.impl.NoticeServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NoticeServiceImplTest {

  @Mock
  NoticeServiceImpl noticeServiceImpl;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetAllNotices(){
    List<NoticeDto> notices = new ArrayList<>();
    notices.add(new NoticeDto());
    Mockito.when(noticeServiceImpl.getAllNotices()).thenReturn(notices);
    List<NoticeDto> actual = noticeServiceImpl.getAllNotices();
    Assert.assertEquals(1, actual.size());
  }

  @Test
  public void testCreateNotice(){
    NoticeDto notice = new NoticeDto();
    notice.setMessage("bye bye");
    notice.setSendFrom("anonymous");
    notice.setSendTo("all");

    Mockito.when(noticeServiceImpl.createNotice(Mockito.any())).thenReturn(true);
    Boolean actual = noticeServiceImpl.createNotice(notice);
    Assert.assertEquals(true, actual);
  }
}
