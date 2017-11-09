package com.prahlad.hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HackerRankInString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            System.out.println(checkIfIsHacker(s));
        }
        in.close();
	}

	private static String checkIfIsHacker(String s) {
		Queue q = new LinkedList();
		q.add('h');
		q.add('a');
		q.add('c');
		q.add('k');
		q.add('e');
		q.add('r');
		q.add('r');
		q.add('a');
		q.add('n');
		q.add('k');
		if(q.size() > s.length())
			return "NO";
		for(int i=0;i<s.length();i++)
		{
			if (s.charAt(i) == (char)q.peek())
				q.remove();

			if (q.size() == 0)
				return "YES";
		}

		return "NO";
	}

}
