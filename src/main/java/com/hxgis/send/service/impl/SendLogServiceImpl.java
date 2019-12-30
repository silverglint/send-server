package com.hxgis.send.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hxgis.send.entity.SendLog;
import com.hxgis.send.enums.DriverEnum;
import com.hxgis.send.mapper.SendLogMapper;
import com.hxgis.send.service.SendLogService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sk on 2019/4/25
 */
@Service
public class SendLogServiceImpl extends ServiceImpl<SendLogMapper, SendLog> implements SendLogService {

    @Override
    public List<SendLog> selectByTaskId(String taskId) {
        EntityWrapper<SendLog> wrapper = new EntityWrapper<>();
        wrapper.eq("task_id", taskId);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<SendLog> selectNotFinish(DriverEnum driver) {
        EntityWrapper<SendLog> wrapper = new EntityWrapper<>();
        wrapper.eq("status", 0);
        wrapper.eq("driver_id", driver.getId());
        return baseMapper.selectList(wrapper);
    }
}
