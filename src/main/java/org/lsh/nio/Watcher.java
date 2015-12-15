package org.lsh.nio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

/**
 * 测试使用NIO.2里的变更通知机制<br>
 * 比较java早期版本的轮询来说更加简单易用。
 * 注：在命令行中运行
 * @author JohnnyLiao
 * @date 2015年8月8日 上午10:33:56
 */
public class Watcher {

	public static void main(String[] args) {
		Path this_path = Paths.get(".");
		System.out.println("Now watching the current directory...");
		
		try {
			WatchService watcher = this_path.getFileSystem().newWatchService();
			this_path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);	// 监听事件种类： Directory entry created. 
			
			WatchKey watckKey = watcher.take();
			List<WatchEvent<?>> events = watckKey.pollEvents();
			for (WatchEvent<?> event : events) {
				System.out.println("Created file : " + event.context());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
