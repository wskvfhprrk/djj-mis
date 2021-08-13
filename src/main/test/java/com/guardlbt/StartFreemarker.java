package com.guardlbt;

import com.guardlbt.autoCode.AutoCode;
import com.guardlbt.autoCode.CreateCodeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Created by Administrator on 2017/7/7 0007.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StartFreemarker {

    @Autowired
    private CreateCodeService c;

    @Test
    public void createCode() {
        Map map=new HashMap<>();
        map.put("business_district","商圈");
//        map.put("coupon","代金券");
//        map.put("coupon_history","代金券历史");
//        map.put("coupon_stock","代金券明细");
//        map.put("goods","商品");
//        map.put("index_coupon","首页促销代金券");
//        map.put("index_images","轮播图");
//        map.put("index_shop","首页促销店铺");
//        map.put("member","会员");
//        map.put("member_operation_history","会员操作记录历史");
//        map.put("operation_type","操作类型");
//        map.put("report_site","定位信息上报");
//        map.put("schedule_job","定时任务");
//        map.put("schedule_job_log","定时任务日志");
        //生成代码
//        map.forEach((k,v)->{
//            AutoCode code = new AutoCode(k.toString(), v.toString());
//            c.start(code);
//        });
        //生成菜单数据
//        createSql("map");
    }

    private void createSql(String s) {
        String path=AutoCode.sqlPath;
        File file=new File(path);
        if(!file.exists())file.canExecute();
        try {
            BufferedWriter out=new BufferedWriter(new FileWriter(file));
            out.write(s+"\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }

}
