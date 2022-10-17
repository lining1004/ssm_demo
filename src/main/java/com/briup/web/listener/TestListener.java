package com.briup.web.listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器的工作机制：根据对象的的生命周期进行方法的自动调用
 *  / /* /** 基于请求的路径匹配成功，自动调用方法
 * @Author lining
 * @Date 2022/10/17
 * 监听的是ServletContext对象的创建和销毁
 * ServletContext对象表示整个web项目
 */
@WebListener
@Log4j
public class TestListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.debug("项目启动");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.debug("项目停止");
        //解决项目重启时，无法注销驱动对象.手动停止 mysql 8.0以上驱动版本
        AbandonedConnectionCleanupThread.checkedShutdown();
    }
}
