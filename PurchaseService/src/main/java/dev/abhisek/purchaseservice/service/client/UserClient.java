package dev.abhisek.purchaseservice.service.client;

import dev.abhisek.purchaseservice.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    User getUserById(@PathVariable Integer id);
}
