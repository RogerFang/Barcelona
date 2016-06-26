package edu.whu.irlab.module.redis.springdataredis.sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roger on 2016/6/14.
 */
@Service
public class SubscribeService implements MessageListener {

    @Autowired
    private ChannelTopic channelTopic;

    @Autowired
    private RedisTemplate redisTemplate;

    private List<String> messageList = new ArrayList<>();

    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println(channelTopic.getTopic() + ": " + message.toString());

        byte[] body = message.getBody();//请使用valueSerializer
        byte[] channel = message.getChannel();
        //请参考配置文件，本例中key，value的序列化方式均为string。
        //其中key必须为stringSerializer。和redisTemplate.convertAndSend对应
        String itemValue = (String)redisTemplate.getValueSerializer().deserialize(body);
        String topic = (String)redisTemplate.getStringSerializer().deserialize(channel);
        //直接使用message.toString() 对于其他的Serializer会出现乱码
        messageList.add(itemValue);
    }

    public List<String> getMessageList(){
        return messageList;
    }
}
