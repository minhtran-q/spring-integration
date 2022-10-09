package vn.tqminh.configuration.endpoints;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.jms.ChannelPublishingJmsMessageListener;
import org.springframework.integration.jms.JmsMessageDrivenEndpoint;
import org.springframework.jms.listener.AbstractMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.messaging.SubscribableChannel;

@Configuration
public class JmsMessageDrivenEndpointConfiguration {

    // JmsMessageDrivenEndpoint that can receive JMS messages.
    @Bean
    public JmsMessageDrivenEndpoint jmsMessageDrivenEndpoint(ConnectionFactory connectionFactory,
            AbstractMessageListenerContainer simpleMessageListenerContainer,
            ChannelPublishingJmsMessageListener channelPublishingJmsMessageListener,
            SubscribableChannel consumingChannel) {

        final JmsMessageDrivenEndpoint endpoint = new JmsMessageDrivenEndpoint(simpleMessageListenerContainer,
                channelPublishingJmsMessageListener);
        endpoint.setOutputChannel(consumingChannel);

        return endpoint;
    }

    @Bean
    public MessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setDestinationName("");
        return container;
    }
    
    // ChannelPublishingJmsMessageListener creates a listener that converts a JMS
    // Message into a Spring Integration Message and sends that message to a
    // channel.
    @Bean
    public ChannelPublishingJmsMessageListener channelPublishingJmsMessageListener() {
        return new ChannelPublishingJmsMessageListener();
    }

}
