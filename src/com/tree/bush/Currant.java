package com.tree.bush;

import com.tree.Bunch;
import static com.func.Puts.*;

public class Currant extends Bunch{
	private Currant(){}
	public static Currant plant(){
		puts("Currant is planted");
		Currant curr = new Currant();				//only one object created
		return curr;								//return link to this object
	}
	@Override public String getType(){				//ensures that method is overridden but not overloaded переопределен(по отношению к такому же в базовом классе), а не перегружен (именены входные параметры)
		return "Currant";
	}
}