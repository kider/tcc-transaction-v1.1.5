/*
 * ========================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/course/view/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ========================================================================
 */
package org.mengyun.tcctransaction.spring.support;

import org.mengyun.tcctransaction.TransactionManager;
import org.mengyun.tcctransaction.TransactionRepository;
import org.mengyun.tcctransaction.recover.RecoverConfig;
import org.mengyun.tcctransaction.spring.recover.DefaultRecoverConfig;
import org.mengyun.tcctransaction.support.TransactionConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TCC事务配置器.
 * Created by changmingxie on 11/11/15.
 */
public class TccTransactionConfigurator implements TransactionConfigurator {

	/**
	 * 事务库
	 */
    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * 事务恢复配置
     */
    @Autowired(required = false)
    private RecoverConfig recoverConfig = DefaultRecoverConfig.INSTANCE;

    /**
     * 根据事务配置器创建事务管理器.
     */
    private TransactionManager transactionManager = new TransactionManager(this);

    /**
     * 获取事务管理器.
     */
    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    /**
     * 获取事务库.
     */
    @Override
    public TransactionRepository getTransactionRepository() {
        return transactionRepository;
    }

    /**
     * 获取事务恢复配置.
     */
    @Override
    public RecoverConfig getRecoverConfig() {
        return recoverConfig;
    }
}
/*
 * ========================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/course/view/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ========================================================================
 */