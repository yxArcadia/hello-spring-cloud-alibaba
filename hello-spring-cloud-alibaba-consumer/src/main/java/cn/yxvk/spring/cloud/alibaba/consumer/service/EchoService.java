package cn.yxvk.spring.cloud.alibaba.consumer.service;

import cn.yxvk.spring.cloud.alibaba.consumer.service.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-provider",fallback = EchoServiceFallback.class)
public interface EchoService {
    @GetMapping("/echo/{msg}")
    public String echo(@PathVariable("msg") String msg);
}
