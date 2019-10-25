package cn.yxvk.spring.cloud.alibaba.consumer.service.fallback;

import cn.yxvk.spring.cloud.alibaba.consumer.service.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(String msg) {
        return "你的网络有问题";
    }
}
