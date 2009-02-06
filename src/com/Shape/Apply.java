package com.Shape;
import static com.func.Puts.*;

public class Apply{						//Этот класс предназначен для пакетной обработки Shape разными Processor
	public static void process(Processor p, Shape s){
		puts("Applying processor: "+p.name());
		p.process(s);
	}
	public static void drawTrace(Orbicular shape){
		puts("Draw trace: "+shape.roll());
	}
}