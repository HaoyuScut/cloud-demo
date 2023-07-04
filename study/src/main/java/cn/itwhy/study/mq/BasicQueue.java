package cn.itwhy.study.mq;

/**
 * @author 王浩宇
 * @version 1.0
 * @create 2023/06/15 19:37
 * 对应HelloWorld
 */
public class BasicQueue {
    /**
     * publisher:消息发布者，将消息发送到队列queue
     * queue:消息队列，负责接收并缓存消息
     * consumer:订阅队列，处理队列中的消息
     *
     * 基本消息队列的消息发送流程:
     * 1．建立connection
     * 2．创建channel
     * 3．利用channel声明队列
     * 4．利用channel向队列发送消息
     *
     * 基本消息队列的消息接收流程:
     * 1．建立connection
     * 2．创建channel
     * 3．利用channel声明队列
     * 4．定义consumer的消费行为handleDelivery()
     * 5．利用channel将消费者与队列绑定
     */


}
