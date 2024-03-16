//package id.bootcamp.pembekalan2024.config;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//public class MyInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        // Method ini dipanggil sebelum penanganan permintaan aktual (controller method)
//        return true; // Return true jika permintaan harus dilanjutkan, false jika tidak
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//        // Method ini dipanggil setelah penanganan permintaan aktual tetapi sebelum menampilkan tampilan
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//            throws Exception {
//        // Method ini dipanggil setelah penanganan permintaan selesai, termasuk menampilkan tampilan
//    }
//}
