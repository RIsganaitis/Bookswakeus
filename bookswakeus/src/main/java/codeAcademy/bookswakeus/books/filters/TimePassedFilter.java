package codeAcademy.bookswakeus.books.filters;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TimePassedFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //laikas prieš
        System.out.println("--------------- filter start");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        filterChain.doFilter(servletRequest, servletResponse);

        stopWatch.stop();

        System.out.printf("--------------- filter stop--time passed: %d ms %n", stopWatch.getLastTaskTimeMillis());

        //laikas po
    }
}
