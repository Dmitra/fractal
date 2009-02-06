package com.tree.bush;

import static com.func.Puts.puts;
import com.tree.Bunch;

public class Gooseberry extends Bunch{ 					//крыжовник Gooseberry is a particular case of a bunch, so we use extension of a class Bunch
	private Gooseberry(){}							//private constructor restricts outside class access and ensures no default contstructor created
	static int sumGooseberry = 0;
	public static Gooseberry plant(){  	//allow creating objects in static method
		sumGooseberry++;							//count total amount of Gooseberry bunches in a plant
		puts("Gooseberry is planted");
		//if (sumGooseberry < 3){
			return new Gooseberry();
		//}	else	{puts("it should be no more then 3 Gooseberry bunches in the parcel");}
	}
	
}