package PriorityQueue;

import java.util.Arrays;

class Person implements Comparable<Person> {
	String name;
	int age;

	@Override
	public int compareTo(Person o) {
		// 기준 명시
		// 1. 나이에 대한 내림차순 정렬
		if (this.age > o.age) {
			return -1; // 내가 더 작아야 내림차순 정렬이 되기 때문에 -1 음수를 반환 (상대의 우선순위가 높음)
		} else if (this.age < o.age) {
			return 1; // 내가 상대방 보다 더 늦게 나와야하니 상대방의 우선순위가 더 낮아야함
		} else {

			return 0;	
		}
	}
}
return this.name.compareTo(o.name);


// Comparable을 통해 정렬 기준을 정의 할 수 있음
// Comparable을 상속 받으면 compareTo을 오버라이드 해야하는 강제성이 부여된다

/*
 * 두 개의 객체만 생각하여 정렬한다. 1. this.o (나) 2. o 받아오는 객체
 * 
 * 리턴은 항상 양수 or 0 or 음수 compareTo의 결과는 항상 this의 우선 순위를 부여 양수 : this.o (나)의 우선순위가
 * 더 높다. 0 : this.o와 o의 우선순위가 같다 음수 : o의 우선순위가 더 높다. 다른 조건이 없다면 오름차순으로 이루어진다.
 */

public class compare_test {
	public static void main(String[] args) {
		Person[] persons = new Person[3];
		persons[1] = new Person();
		persons[2] = new Person();
		persons[3] = new Person();

		// 오류 발생 -> 어떤 기준으로 정렬해야하는지 모르기 때문
		// 숫자의 경우 기준이 명확하기 때문에 정렬이 가능하지만 해당 부분에서는 가능
		Arrays.sort(persons);
	}

}
