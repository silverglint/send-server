package com.hxgis.send.action;

import com.hxgis.send.service.ReceiveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by sk on 2019/4/25
 */

@Api(description = "查询发送记录")
@RestController
@RequestMapping("receive")
public class ReceiveAction {

    private ReceiveService receiveService;

    @Autowired
    public ReceiveAction(ReceiveService receiveService) {
        this.receiveService = receiveService;
    }

    @ApiOperation("根据taskId查询发送记录")
    @RequestMapping(method = RequestMethod.GET)
    public Object getReceive(@RequestParam String taskId) {
        return receiveService.getReceive(taskId);
    }
}
