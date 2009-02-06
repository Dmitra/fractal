package com.Shape;

public class FilterSepiaAdaptor implements Processor{
	Filter filter;
	private Effect eff = new Effect("Sepia");
	public FilterSepiaAdaptor(Filter filter){		//Конструктор принимает фильтр, чтобы из него сделать реализацию интерфейса Processor
		this.filter = filter;
	}
	@Override
	public String name() {
		return "Filter: "+eff.getName();
	}

	@Override
	public Shape process(Shape input) {
		
		return input;
	}
	
}