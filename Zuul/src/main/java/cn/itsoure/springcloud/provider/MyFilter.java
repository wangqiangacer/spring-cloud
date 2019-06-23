package cn.itsoure.springcloud.provider;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

/**
 * @author wangqiang
 * @version V1.0
 * @date 2019/6/23 19:00
 */
@Component
public class MyFilter extends ZuulFilter {

    private final static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        //		pre：路由之前
//		routing：路由之时
//		post： 路由之后
//		error：发送错误调用
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取request
        HttpServletRequest request = ctx.getRequest();
        System.out.println(request.getMethod() + "--" + request.getRequestURL().toString());


        Object token = request.getParameter("token");
        logger.info("token:{}"+token);
        //设置相应的编码
        ctx.getResponse().setContentType("text/html;charset=UTF-8");
        if(!Optional.ofNullable(token).isPresent()){
            ctx.setSendZuulResponse(false);//没有token就不向网关发请求
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("你没有访问权限");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
