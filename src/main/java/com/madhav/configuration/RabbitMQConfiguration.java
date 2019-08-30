package com.madhav.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

	@Bean
	public Queue queue() {
		return new Queue("Q1", true);
	}
	@Bean
	public DirectExchange exchange() {
		return new DirectExchange("E1");
	}
	@Bean
	public Binding createBinding(Queue queue, DirectExchange exchange) {
		Binding binding = BindingBuilder.bind(queue).to(exchange).with("RK1");
		return binding;
	}
	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	/*
	 * @Bean public AmqpTemplate rt(ConnectionFactory connectionFactory) { final
	 * RabbitTemplate rt = new RabbitTemplate(connectionFactory);
	 * rt.setMessageConverter(jsonMessageConverter()); return rt; }
	 */
}
