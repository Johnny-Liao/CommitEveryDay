package org.lsh.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Memory_Map_Ex {

	private static int mem_map_size = 20 * 1024 * 1024;
	private static String writeFileName = "src/org/lsh/nio/example_memory_mapped_file.txt";

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		RandomAccessFile memoryMappedFile = new RandomAccessFile(writeFileName, "rw");

		// Mapping a file into memory
		MappedByteBuffer out = memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, mem_map_size);

		// Writing into Memory Mapped File
		for (int i = 0; i < mem_map_size; i++)
			out.put((byte) 'A');
		System.out.println("File '" + writeFileName + "' is now " + Integer.toString(mem_map_size) + " bytes full.");

		// Read from memory-mapped file.
		for (int i = 0; i < 30; i++) 
			System.out.print((char) out.get(i));
		System.out.println("\nReading from memory-mapped file '" + writeFileName + "' is complete.");
	}
}
