package com.hxgis.send.config;


import com.hxgis.send.exception.BaseException;
import com.hxgis.send.model.ResultInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class WebAspect {

    //拦截接口数据类
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *) ")
    public void pointcut() {
    }


    /**
     * 对于一切后台接口进行拦截  进行cookie 处理
     *
     * @param pjp
     * @return
     */
    @Around(value = "pointcut()")
    public Object after(ProceedingJoinPoint pjp) {
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (BaseException e) {
            e.printStackTrace();
            return e.getResultInfo();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResultInfo.error(e.getMessage());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return ResultInfo.error("操作失败;请联系管理员");
        }
        return ResultInfo.success(proceed);
    }
}
