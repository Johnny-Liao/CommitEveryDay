package org.lsh.thread;

/**
 * ��ʾ�������ǿ�����ģ���ȡ���Ĳ����������̡߳�
 * Created by Johnny Liao on 2016/3/5.
 */
public class LoggingWidget extends Widget {

    @Override
    public synchronized void doSomething() {
        System.out.println("Logging Widget do something");
        super.doSomething();        // ����������룬�˴����ᷢ������
    }

    public static void main(String[] args) {
        new LoggingWidget().doSomething();
    }
}
