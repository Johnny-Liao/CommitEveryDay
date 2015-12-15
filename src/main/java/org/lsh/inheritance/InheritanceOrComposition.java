package org.lsh.inheritance;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * ���̳к���ϵļ�������˵�����������̳�.<tt>�ʼ�</tt>
 * 
 * @author JohnnyLiao
 */
public class InheritanceOrComposition {
	/**
	 * �ȼ�ס���㣺<br>
	 * 1���̳д����˷�װ�ԡ�<br>
	 * 2�������Ǵ����ģ����ܸ���ĸı������<br>
	 * 3��(����)��������ʵ��ϸ�ڣ�������һ�ֳ�����<br>
	 */

	/**
	 * ���濴��������ı��Ӱ��������Ϊ���³�������ӣ�<br>
	 * 1��������������˴洢Ԫ�صķ���������ԭ�洢Ԫ�ط����а�ȫ�����ƣ�������ӷ����ޣ����°�ȫ©����<br>
	 * 2����������ӷ����������������������⡣<br>
	 */

	/**
	 * ת��(�Ǵ������װ��ģʽ)���̳к����֮�����ӹ֮����<br>
	 * ����������һ�������������˽����Ȼ���������෽���п��Ե��ð���������ʵ���ķ������������Ľ��(��Ϊת��)�������еķ�������Ϊת��������<br>
	 * Decoratorģʽ(װ��ģʽ)
	 */

	// Reusable forwarding class
	class ForwardingSet<E> implements Set<E> {
		private final Set<E> s;

		public ForwardingSet(Set<E> s) {
			this.s = s;
		}

		@Override
		public int size() {
			return s.size();
		}

		@Override
		public boolean isEmpty() {
			return s.isEmpty();
		}

		@Override
		public boolean contains(Object o) {
			return s.contains(o);
		}

		@Override
		public Iterator<E> iterator() {
			return s.iterator();
		}

		@Override
		public Object[] toArray() {
			return s.toArray();
		}

		@Override
		public <T> T[] toArray(T[] a) {
			return s.toArray(a);
		}

		@Override
		public boolean add(E e) {
			return s.add(e);
		}

		@Override
		public boolean remove(Object o) {
			return s.remove(o);
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return s.containsAll(c);
		}

		@Override
		public boolean addAll(Collection<? extends E> c) {
			return s.addAll(c);
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			return s.retainAll(c);
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			return s.removeAll(c);
		}

		@Override
		public void clear() {
			s.clear();
		}

	}

	// Wrapper class - uses composition in place of inheritance
	// ��װ�� Decoratorģʽ
	// ���˾��ÿ���ֱ����ForwardingSet�����InstrumentedSet����ӵĹ��ܣ���ʡ��
	class InstrumentedSet<E> extends ForwardingSet<E> {
		private int addCount = 0;

		public InstrumentedSet(Set<E> s) {
			// TODO Auto-generated constructor stub
			super(s);
		}

		@Override
		public boolean add(E e) {
			addCount++;
			return super.add(e);
		}

		@Override
		public boolean addAll(Collection<? extends E> c) {
			addCount += c.size();
			return super.addAll(c);
		}

		// ���ӵĹ���
		public int getAddCount() {
			return addCount;
		}

	}

	/**
	 * ������֮��ȷʵ��is-a��ϵʱ����Ӧ��ʹ�ü̳л���<br>
	 * Javaƽ̨�����Ҳ�в���Υ����������ĵط����磺<br>
	 * 1��stack������vector<br>
	 * 2��Properties������Hashtable<br>
	 * ���������кܶ�©�� �����һ��������������ͼ��չ���࣬����API����û��ȱ���أ�
	 */

	/**
	 * �����֮���̳еĹ��ܷǳ�ǿ�󣬵�Ҳ��������⣬��Ϊ��Υ���˷�װԭ��(��������Ĵ�����)��<br>
	 * Ϊ��������Կ��Կ�����<tt>��Ϻ�ת������</tt>������̳С�<br>
	 * ��ӿڵİ�װ�಻����������ӽ�׳���Ҹ���ǿ��
	 */
}
