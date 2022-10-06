# Spring Integration Knowledge

## Core
+ Provide a simple model for integration solutions.
+ Provide asynchronous, message-driven behavior in a Spring application.
+ Supports integration with external systems via declarative adapters.
+ Spring Integration typically implements a "pipes-and-filters" approach where the "filters" are components that produce or consume messages and the "pipes" transport messages.

### Messaging Channels

<details>
  <br/>
  <summary>What is Messaging Channels?</summary>
  The `MessageChannel` decouples message producers from messgae consumers.

  ```
  public interface MessageChannel {

      boolean send(Message message);

      boolean send(Message message, long timeout);
  }
  ```
  _`MessageChannel` interface_
</details>

<details>
  <br/>
  <summary>Type of Messaging Channels</summary>
  
   These two sub-interfaces that define the buffering (pollable) and non-buffering (subscribable) channel behavior.

   **PollableChannel**
   ```
   public interface PollableChannel extends MessageChannel {

    Message<?> receive();

    Message<?> receive(long timeout);

   }
   ```
   **SubscribableChannel**
   ```
   public interface SubscribableChannel extends MessageChannel {

    boolean subscribe(MessageHandler handler);

    boolean unsubscribe(MessageHandler handler);

   }
   ```
</details>

<details>
  <br/>
  <summary>Channel Interceptor</summary>
  
   
</details>

### Messages
The Spring Integration `Message` is a generic container for data.
```
public interface Message<T> {

    T getPayload();

    MessageHeaders getHeaders();

}
```
### Message Routing
### Message Transformation
### Message Endpoint
## HTTP
## JMS
