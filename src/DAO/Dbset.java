package DAO;

import java.util.List;

/**
 *
 * @param <T>
 */
public abstract class Dbset<T> {

    public abstract List<T> ListAll();

    public abstract List<T> ListAllHasNoTracking();

    public abstract T GetById(long id);

    public abstract boolean Insert(T type);

    public abstract boolean Update(T type);

    public abstract boolean Delete(T type);

}
