package cn.itwhy.study.mq;

/**
 * @author 王浩宇
 * @version 1.0
 * @create 2023/06/13 21:33
 */
public class RabbitMQ {
    //channel:操作MQ的工具
    //exchange:路有消息到队列中
    //queue:缓存消息
    //virtual host:虚拟主机。是对queue、exchange等资源的逻辑分组

    //常见消息模型:
    //基本消息队列(BasicQueue)
    //工作消息队列(WorkQueue)
    //发布订阅(Publish、Subscribe)，有根据交换机类型不同分为三种:
    //Fanout Exchange:广播
    //Direct Exchange:路由
    //Topic Exchange:主题
}
