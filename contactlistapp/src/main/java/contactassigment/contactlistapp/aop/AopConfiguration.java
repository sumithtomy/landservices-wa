package contactassigment.contactlistapp.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@EnableAspectJAutoProxy
@Aspect
public class AopConfiguration {

  @Pointcut("execution(* contactassigment.contactlistapp.web.*Controller.*(..))")
  public void monitor() {}
  
  @Bean
  public MyPerformanceMonitorInterceptor myPerformanceMonitorInterceptor() {
    return new MyPerformanceMonitorInterceptor(true);
  }

  @Bean
  public Advisor performanceMonitorAdvisor() {
    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    pointcut.setExpression("contactassigment.contactlistapp.aop.AopConfiguration.monitor()");
    return new DefaultPointcutAdvisor(pointcut,
        myPerformanceMonitorInterceptor());
  }
  
 

}
