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
 * ����ʹ��NIO.2��ı��֪ͨ����<br>
 * �Ƚ�java���ڰ汾����ѯ��˵���Ӽ����á�
 * ע����������������
 * @author JohnnyLiao
 * @date 2015��8��8�� ����10:33:56
 */
public class Watcher {

	public static void main(String[] args) {
		Path this_path = Paths.get(".");
		System.out.println("Now watching the current directory...");
		
		try {
			WatchService watcher = this_path.getFileSystem().newWatchService();
			this_path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);	// �����¼����ࣺ Directory entry created. 
			
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
