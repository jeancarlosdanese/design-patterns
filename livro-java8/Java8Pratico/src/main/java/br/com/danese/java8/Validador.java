package br.com.danese.java8;

@FunctionalInterface
interface Validador<T> {

	boolean valida(T t);
}