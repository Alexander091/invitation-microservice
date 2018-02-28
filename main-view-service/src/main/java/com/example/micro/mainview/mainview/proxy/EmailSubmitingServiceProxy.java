package com.example.micro.mainview.mainview.proxy;

import com.example.micro.mainview.mainview.model.SimpleModel;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="submiting-email-service")
@RibbonClient(name="submiting-email-service")
public interface EmailSubmitingServiceProxy {
    @PostMapping("/email")
    void submitEmail(@RequestBody SimpleModel model);
}
