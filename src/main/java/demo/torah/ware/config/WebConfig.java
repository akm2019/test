package demo.torah.ware.config;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@MapperScan("demo.torah.ware.mapper")
public class WebConfig implements WebMvcConfigurer{
	
	@Autowired
    CertificationInterceptor certificationInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

        List<String> pathPatternList = new ArrayList<>();
        pathPatternList.add("/board/regist");
        pathPatternList.add("/board/edit/**");
        pathPatternList.add("/board/delete/**");
        pathPatternList.add("/mypage/**");

        registry.addInterceptor(certificationInterceptor)
                .addPathPatterns(pathPatternList)
                .excludePathPatterns("/mypage/main");

    }

}
