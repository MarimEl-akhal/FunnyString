package org.example.database;

import java.lang.reflect.InvocationTargetException;

public interface DataBaseManagerInterface <T> {
    /*
    Object that contains a field called id and some other fields
    it should use the class name as the table name and fill the fields from the columns and return

    // table is ExampleEntity
public class ExampleEntity {
        // table id
        private Long id;
        // column userName
        private String userName;
    }
     */

//    ? get();
    public T getById(long id , Class <T> clazz) throws InvocationTargetException, InstantiationException, IllegalAccessException;

     /*
     the inserted object class name is the table name
     and the fields added should be inserted into the table
     // table is ExampleEntity
    public class ExampleEntity {
        // table id
        private Long id;
        // column userName
        private String userName;
    }
      */
//    insert(?)
   public void  insert(T entity);
}
