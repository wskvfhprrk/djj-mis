package com.guardlbt.wx;

import com.guardlbt.service.WxIndexService;
import com.guardlbt.wx.vo.GetAccessTokenVo;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class wxClientTest extends TestCase {
    @Autowired
    private WxIndexService wxIndexService;
    @Test
    public void code() throws Exception {
        GetAccessTokenVo getAccessTokenVo = wxIndexService.getAccessToken();
        System.out.println(getAccessTokenVo.toString());
    }

}