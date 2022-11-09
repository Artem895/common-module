package corelog.acpectlog;

import corelog.model.DbLogModel;
import corelog.repository.LogEntityRepo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class MyAspect {
    @Autowired
    private LogEntityRepo logEntityRepo;

    @Pointcut("@annotation(corelog.myanotation.DbLog)")
    public  void logableMethods(){};

    @Around("logableMethods()")
    public Object applictionLoger(ProceedingJoinPoint pjp){
        DbLogModel dbLogModel=new DbLogModel();
        String methoName=pjp.getSignature().getName();
        String pjpClass=pjp.getTarget().getClass().toString();
        Object[] array=pjp.getArgs();
        log.info(methoName+"  "+pjpClass+" "+ Arrays.toString(array));
        dbLogModel.setMethodParams(methoName+""+ Arrays.toString(array));
        dbLogModel.setSystemTypeId(1l);
        logEntityRepo.save(dbLogModel);
        Object result=null;
        try {
            result =pjp.proceed();
        }catch (Throwable e){
            log.info("Отловил ошибку");
        }
        return result;
    }
}
