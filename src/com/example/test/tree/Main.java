package com.example.test.tree;


import com.example.utils.printer.BinaryTrees;

@SuppressWarnings("unused")
public class Main {

	static void test4() {
		Integer data[] = new Integer[] {
				55, 87, 5
		};
		
		RBTree<Integer> rb = new RBTree<>();
		for (int i = 0; i < data.length; i++) {
			rb.add(data[i]);
		}

		BinaryTrees.println(rb);

		for (int i = 0; i < data.length; i++) {
			rb.remove(data[i]);
			System.out.println("---------------------------------------");
			System.out.println("【" + data[i] + "】");
			BinaryTrees.println(rb);
		}
	}
	
	public static void main(String[] args) {
		test4();
	}
}
