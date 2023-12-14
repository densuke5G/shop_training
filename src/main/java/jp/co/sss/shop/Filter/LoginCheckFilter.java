//package jp.co.sss.shop.Filter;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class LoginCheckFilter extends HttpFilter {
//
//	@Override
//	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		String requestURL = request.getRequestURI();
//
//		if (requestURL.endsWith("/loginWithValidation")) {
//			chain.doFilter(request, response);
//
//		} else {
//			HttpSession session = request.getSession();
//			Integer userId = (Integer) session.getAttribute("userId");
//
//			if (userId == null) {
//				response.sendRedirect("/shop/loginWithValidation");
//				return;
//			} else {
//				chain.doFilter(request, response);
//
//			}
//		}
//	}
//
//}
