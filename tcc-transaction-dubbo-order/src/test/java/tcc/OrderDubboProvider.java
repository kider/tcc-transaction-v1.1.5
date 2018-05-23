/*
 * ========================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/course/view/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ========================================================================
 */
package tcc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @描述: 启动Dubbo服务用的MainClass.
 * @作者: WuShuicheng .
 * @创建时间: 2016-06-22,下午9:47:55 .
 * @版本: 1.0 .
 */
public class OrderDubboProvider {
	private static final Log log = LogFactory.getLog(OrderDubboProvider.class);
	
    public static void main(String[] args) {
    	
        try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/spring/local/appcontext.xml");
			context.start();
		} catch (Exception e) {
			log.error("== OrderDubboProvider context start error:",e);
		}
        
        synchronized (OrderDubboProvider.class) {
            while (true) {
                try {
                    OrderDubboProvider.class.wait();
                } catch (InterruptedException e) {
                	log.error("== synchronized error:",e);
                }
            }
        }
    }
    
}