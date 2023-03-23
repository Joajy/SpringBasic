package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
        //꼭 필요한 위치부터 컴포넌트 탐색
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        //스프링 빈 등록 시 제외할 목록 작성
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

}
