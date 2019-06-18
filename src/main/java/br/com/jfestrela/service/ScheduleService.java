package br.com.jfestrela.service;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class ScheduleService {

	private AtomicInteger scheduleCountTime = new AtomicInteger();
	private AtomicInteger scheduleCountCron = new AtomicInteger();
	
	public Integer getScheduleCountTime() {
		return scheduleCountTime.get();
	}
	
	public Integer getScheduleCountCron() {
		return scheduleCountCron.get();
	}
	
	@Scheduled(every="5s")
	void incrementScheduleCountCron() {
		scheduleCountCron.incrementAndGet();
	}
	
	@Scheduled(cron="*/5 * * * * ?")
	void incrementScheduleCountTime() {
		scheduleCountTime.incrementAndGet();
	}
}
