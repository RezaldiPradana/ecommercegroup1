//package id.bootcamp.pembekalan2024.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor())
//                .addPathPatterns("/**") // Sesuaikan dengan pola URL yang ingin Anda intersep
//                .excludePathPatterns("/"); // Anda dapat mengecualikan pola URL tertentu jika diperlukan
//    }
//}