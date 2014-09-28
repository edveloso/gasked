package br.com.eveloso.gasked.jetty.domain.persistence;

import java.util.List;

public interface IDAO<T> {

	public abstract Integer save(T entity);

	public abstract List<T> getAll();

}