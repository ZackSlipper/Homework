package com.kitm;

public class MyComplex {
	private double real = 0.0;
	private double imag = 0.0;

	public MyComplex() {
	}
	
	public MyComplex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public void setValue(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	@Override
	public String toString() {
		return real + "+" + imag + "i";
	}

	public boolean isReal() {
		return imag == 0;
	}

	public boolean isImaginary() {
		return real == 0;
	}

	public boolean equals(double real, double imag) {
		return this.real == real && this.imag == imag;
	}

	public boolean equals(MyComplex another) {
		return this.real == another.real && this.imag == another.imag;
	}

	public double magnitude() {
		return Math.sqrt(real * real + imag * imag);
	}

	public MyComplex addInto(MyComplex right) {
		real += right.real;
		imag += right.imag;
		return this;
	}
	
	public MyComplex addNew(MyComplex right) {
		return new MyComplex(real + right.real, imag + right.imag);
	}
}
