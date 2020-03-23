package br.com.emersonmorgado.sistemaAcademico.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FilterJava implements Filter {

    private Logger logger = LoggerFactory.getLogger(FilterJava.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("Chegou a requisição de acesso");
        HttpServletRequest req = (HttpServletRequest) request;
        Enumeration<String> headerNames = req.getHeaderNames();
        Map<String, String> mapHeaders = Collections.list(headerNames)
                .stream()
                .collect(Collectors.toMap(it -> it, req::getHeader));
        if(mapHeaders.get("authorization") != null && mapHeaders.get("authorization").equals("batatinha")){
            chain.doFilter(request,response);//Quando chegar neste ponto ele vai para o método correspontede.
        }else {
            HttpServletResponse res = (HttpServletResponse) response;
            logger.info("Não autorizado");
            res.sendError(403);
        }

        logger.info("Terminou o acesso");
    }
}
