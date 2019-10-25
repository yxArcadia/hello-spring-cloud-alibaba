package cn.yxvk.spring.cloud.alibaba.consumer.controller;

import cn.yxvk.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class TestController {
    private final RestTemplate restTemplate;

    @Autowired
    private EchoService echoService;

    @Value("${user.name}")
    private String username;

    @Autowired
    public TestController(RestTemplate template){
        this.restTemplate=template;
    }

    @GetMapping("echo/{str}")
    public String echo(@PathVariable("str") String str){
        return restTemplate.getForObject("http://service-provider/echo/"+str,String.class);
    }

    @GetMapping("fegin/echo/{msg}")
    public String feginEcho(@PathVariable String msg){
        return echoService.echo(msg);
    }

    @GetMapping("getname")
    public String getName(){
        return username;
    }


}
