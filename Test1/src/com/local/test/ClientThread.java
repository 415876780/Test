package com.local.test;

public class ClientThread extends Thread {
	private ProductService productService;
	public ClientThread(ProductService productService){
		this.productService=productService;
	}
	public void run(){
		System.out.println(Thread.currentThread().getName());
		productService.updateProductPrice(1, 3000);
	}
}
