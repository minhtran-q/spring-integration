package vn.tqminh.configuration.channels;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;

@Configuration
public class ChannelConfiguration {

    @Bean
    public DirectChannel producingChannel() {
      return new DirectChannel();
    }
    
    @Bean
    public DirectChannel consumingChannel() {
      return new DirectChannel();
    }
    
}