package demo.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.service.SleepService;

@RestController
@RequestMapping("/")
public class HelloController {

	@RequestMapping("/scale/{threadCount}")
	public void createTrouble(@PathVariable Integer threadCount) {
		sleep(threadCount);
	}

	private void sleep(Integer threadCount) {
		ExecutorService executor = Executors.newFixedThreadPool(100000);
		for (int i = 0; i < threadCount; i++) {
			System.out.println("Loop count - " + i);
			Runnable runnable = new SleepService();
			executor.execute(runnable);
		}
		executor.shutdown();

		while (!executor.isTerminated()) {
		}

		System.out.println("\nFinished all threads");
	}
}
