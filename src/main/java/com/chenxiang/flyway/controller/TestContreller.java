package com.chenxiang.flyway.controller;

import com.alibaba.excel.metadata.Sheet;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenxiang.flyway.model.Node;
import com.chenxiang.flyway.model.Table;
import com.chenxiang.flyway.model.User;
import com.chenxiang.flyway.service.TestService;
import com.chenxiang.flyway.service.UserService;
import com.chenxiang.flyway.service.UsersService;
import com.chenxiang.flyway.util.ExcelUtil;
import com.chenxiang.flyway.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cx
 * @version 1.0
 * @date 2020/8/21 15:11
 */
@Controller
public class TestContreller {

    @Autowired
    TestService testService;

    @Autowired
    UserService userService;

    @Autowired
    UsersService usersService;

    @RequestMapping("/test")
    @ResponseBody
    public void  read(){
      String path = "D:\\study\\test.xlsx";
      ExcelUtil.readLessThan1000Row(path);
        ArrayList<ExcelUtil.MultipleSheelPropety> list1 = new ArrayList<>();
        for(int j=0 ;j<2;j++) {
            List<Table> list=new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                Table table = new Table();
                table.setAge(10 + i);
                table.setName("陈翔");
                table.setSchool("北京大学");
                list.add(table);

            }
            Sheet sheet=new Sheet(j,0);
            sheet.setSheetName(j+"陈翔");
            ExcelUtil.MultipleSheelPropety multipleSheelPropety = new ExcelUtil.MultipleSheelPropety();
            multipleSheelPropety.setData(list);
            multipleSheelPropety.setSheet(sheet);
            list1.add(multipleSheelPropety);

        }
        ExcelUtil.writeWithMultipleSheel(path,list1);


    }

    @ResponseBody
    @RequestMapping("get")
    public void get(){
        String path = "D:\\study\\test.xlsx";
        List<Object> lists= ExcelUtil.readLessThan1000Row(path);
        List<Table> list=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Table table = new Table();
            table.setAge(10 + i);
            table.setName("陈翔");
            table.setSchool("北京大学");
            list.add(table);

        }



    }


    @ResponseBody
    @RequestMapping("/test1")
    public  String  test1(String name ,String age){

        return  name+">>>"+age ;


    }
    @ResponseBody
    @RequestMapping("/test2")
    public String test2(String name){
        int[] arr=new int[]{1,2,3,4,5};
        Node node=testService.trance(arr);
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.forEach(x -> System.out.println(x));
        return  testService.test1(name);

    }

    @ResponseBody
    @RequestMapping("/test3")
    public String test3() throws  Exception{
        //企业微信集成
        String json= HttpUtil.doGet("https://qyapi.weixin.qq.com/cgi-bin/gettoken"+"?corpid="+"ww1ca3141beb36002c"+"&corpsecret="+"HR1Tz5kkJuElOjB1_4kxUIZLGpOaZR52VUXtrKMkPtI");
        JSONObject object=JSONObject.parseObject(json);
        String accessToken=object.getString("access_token");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("touser","ChenXiang");
        jsonObject.put("msgtype","text");
        jsonObject.put("agentid","1000002");
        JSONObject context=new JSONObject();
        context.put("content","测试消息推送");
        jsonObject.put("text",context);
        String result=HttpUtil.doPost("https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token="+accessToken,jsonObject.toJSONString());
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        IPage<User> page=new Page<>(1,1);
        QueryWrapper<User> queryWrapper1=new QueryWrapper<>();
        queryWrapper.eq("id","123");
        page= usersService.page(page,queryWrapper);
        User user=  userService.getById("1");
        List<User> list=new ArrayList<>();
        list.add(new User("a","2",9));
        list.add(new User("b","2",12));
        list.add(new User("c","2",12));
        list.stream().filter(x-> x.getAge()>10).distinct().collect(Collectors.toList());
        list.stream().map(x->x.getAge()).collect(Collectors.toList());

        return  testService.test();

    }



}
