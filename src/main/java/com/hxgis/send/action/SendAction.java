package com.hxgis.send.action;

import com.hxgis.send.model.baseway.BaseSendModel;
import com.hxgis.send.model.SendBaseCont;
import com.hxgis.send.service.SendService;
import com.hxgis.send.utils.UUIDUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sk on 2019/4/24
 */
@RestController
@Api(description = "发送服务")
public class SendAction {


    private SendService sendService;

    @Autowired
    public SendAction(SendService sendService) {
        this.sendService = sendService;
    }

    @ApiOperation("根据传入配置发送，返回taskId")
    @RequestMapping(value = "send", method = RequestMethod.POST)
    public Object send(@RequestBody SendBaseCont sendBaseCont) {
        BaseSendModel[] baseSendModels = sendBaseCont.getData();
        String taskId = sendBaseCont.getTaskId();
        taskId = StringUtils.isEmpty(taskId) ? UUIDUtils.getUUID() : taskId;
        for (BaseSendModel baseSendModel : baseSendModels) {
            sendService.send(taskId, baseSendModel);
        }
        return taskId;
    }

}
