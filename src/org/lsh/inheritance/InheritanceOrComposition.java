package org.lsh.inheritance;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 简介继承和组合的几种区别，说明组合优先与继承.<tt>笔记</tt>
 * 
 * @author JohnnyLiao
 */
public class InheritanceOrComposition {
	/**
	 * 先记住几点：<br>
	 * 1、继承打破了封装性。<br>
	 * 2、子类是脆弱的，易受父类的改变而出错。<br>
	 * 3、(父类)自用性是实现细节，而不是一种承若。<br>
	 */

	/**
	 * 下面看两个父类改变而影响子类行为导致出错的例子：<br>
	 * 1、父类中有添加了存储元素的方法，子类原存储元素方法有安全检查机制，但新添加方法无，导致安全漏洞。<br>
	 * 2、父类中添加方法和子类自身方法重名问题。<br>
	 */

	/**
	 * 转发(非代理而是装饰模式)：继承和组合之间的中庸之道：<br>
	 * 新类中增加一个引用现有类的私有域。然后用现有类方法中可以调用包含现有类实例的方法并返回它的结果(称为转发)。新类中的方法被称为转发方法。<br>
	 * Decorator模式(装饰模式)
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
	// 包装类 Decorator模式
	// 个人觉得可以直接在ForwardingSet中完成InstrumentedSet中添加的功能，更省事
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

		// 增加的功能
		public int getAddCount() {
			return addCount;
		}

	}

	/**
	 * 当两者之间确实有is-a关系时，才应该使用继承机制<br>
	 * Java平台类库中也有不少违反这条规则的地方，如：<br>
	 * 1、stack并不是vector<br>
	 * 2、Properties并不是Hashtable<br>
	 * 导致其中有很多漏洞 最后考虑一条：对于你正试图扩展的类，它的API中有没有缺陷呢？
	 */

	/**
	 * 简而言之，继承的功能非常强大，但也有诸多问题，因为它违背了封装原则(导致子类的脆弱性)。<br>
	 * 为避免脆弱性可以考虑用<tt>组合和转发机制</tt>来代替继承。<br>
	 * 如接口的包装类不仅比子类更加健壮而且更加强大。
	 */
}
