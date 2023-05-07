package it.templatespringboot.service.impl;

import java.util.List;

public interface ICrudService<T, L> {

	public List<T> findAll();
	
	public T get(final L id);
	
	public L create(final T dto);

	public void update(final L id, final T dto);

	public void delete(final L id);

}
