package DAO;

import java.util.List;

/**
 *
 * @param <T> Father Entity
 * @param <E> Children entity
 */
public abstract class DbUnion<T, E> {

    public abstract List<Long> ListAll(T type);

    public abstract boolean Insert(T type, List<E> childrens);

    public abstract boolean Update(T type, List<E> childrens);

    /**
     * Deleta registros de UMA unica linha de uma tabela de união
     *
     * @param type
     * @param childrens
     * @return
     */
    public abstract boolean Delete(T type, List<E> childrens);

    /**
     * Deleta multiplos registros de multplicas linhas de uma tabela de união
     *
     * @param type
     * @param childrens
     * @return
     */
    public abstract boolean DeleteMultiples(List<E> childrens);
}
