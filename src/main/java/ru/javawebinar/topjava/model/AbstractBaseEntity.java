package ru.javawebinar.topjava.model;
/**Хранит праймери ключ - id
 * уникальный идентификатор, который однозначно идентифицирует объект
 * есть метод isNew который показывает новый ли объект
 * если объект только пришел, то у него нет id
 * */
public abstract class AbstractBaseEntity {
    protected Integer id;

    protected AbstractBaseEntity(Integer id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public boolean isNew() {
        return this.id == null;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":" + id;
    }
}