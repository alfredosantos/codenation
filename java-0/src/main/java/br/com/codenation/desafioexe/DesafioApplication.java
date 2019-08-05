package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.codenation.TestadorFibonacci;
import br.com.codenation.annotation.Desafio;

public class DesafioApplication {

	public static void main(String[] args) {
		new TestadorFibonacci().testaDesafio(DesafioApplication.class);
	}

	@Desafio("Fibonacci")
	public static List<Integer> fibonacci() {
		int n = 0;
		List<Integer> list = new ArrayList<>();
		Collections.addAll(list, 0, 1);
		while(true){
		  final int last = list.get(list.size() - 1);
		  final int beforeLast = list.get(list.size() - 2);
		  final int next = last + beforeLast;
		  if (next > 350) {
			break;
		  }
		  list.add(next);
		}
		return list;
	}

	@Desafio("isFibonacci")
	public static Boolean isFibonacci(Integer a) {
		final List<Integer> list = fibonacci();
	return list.contains(a);
  }
}
