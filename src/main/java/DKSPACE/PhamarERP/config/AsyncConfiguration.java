package DKSPACE.PhamarERP.config;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Slf4j
@Configuration
@EnableAsync
@EnableScheduling
@RequiredArgsConstructor
public class AsyncConfiguration {
	private final TaskExecutionProperties taskExecutionProperties;
	
	
	@Bean(name = "taskExecutor")
	public Executor getAsyncExecutor() {
		log.debug("Creating Async Task Executor");
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(taskExecutionProperties.getPool().getCoreSize());
		executor.setMaxPoolSize(taskExecutionProperties.getPool().getMaxSize());
		executor.setQueueCapacity(taskExecutionProperties.getPool().getQueueCapacity());
		executor.setThreadNamePrefix(taskExecutionProperties.getThreadNamePrefix());
		return executor;
	}
}
