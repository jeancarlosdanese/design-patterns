package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext contex) throws Exception {

		long millis = System.currentTimeMillis();

		String identificacao = contex.getTarget().getClass().getSimpleName() + "->" + contex.getMethod().getName();

		Object o = contex.proceed();

		System.out.println("[INFO] Tempo gasto por, " + identificacao + " no acesso ao BD: "
				+ (System.currentTimeMillis() - millis) + "ms");

		return o;

	}
}
