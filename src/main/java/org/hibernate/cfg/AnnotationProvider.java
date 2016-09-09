package org.hibernate.cfg;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import java.lang.annotation.Annotation;

/**
 * @author ymolodkov on 09.09.16.
 */
public class AnnotationProvider {

    public static final String DELIMITER = "_";

    public static Column createColumnAnnotation(final String prefix, final Column column) {
        return new Column() {
            @Override
            public String name() {
                return getNewName(prefix, column.name());
            }

            @Override
            public boolean unique() {
                return column.unique();
            }

            @Override
            public boolean nullable() {
                return column.nullable();
            }

            @Override
            public boolean insertable() {
                return column.insertable();
            }

            @Override
            public boolean updatable() {
                return column.updatable();
            }

            @Override
            public String columnDefinition() {
                return column.columnDefinition();
            }

            @Override
            public String table() {
                return column.table();
            }

            @Override
            public int length() {
                return column.length();
            }

            @Override
            public int precision() {
                return column.precision();
            }

            @Override
            public int scale() {
                return column.scale();
            }

            @Override
            public Class<? extends Column> annotationType() {
                return Column.class;
            }
        };
    }
    public static JoinColumn createJoinColumnAnnotation(final String prefix, final JoinColumn joinColumn){
        return new JoinColumn(){
            @Override
            public String name() {
                return getNewName(prefix, joinColumn.name());
            }

            @Override
            public String referencedColumnName() {
                return joinColumn.referencedColumnName();
            }

            @Override
            public boolean unique() {
                return joinColumn.unique();
            }

            @Override
            public boolean nullable() {
                return joinColumn.nullable();
            }

            @Override
            public boolean insertable() {
                return joinColumn.insertable();
            }

            @Override
            public boolean updatable() {
                return joinColumn.updatable();
            }

            @Override
            public String columnDefinition() {
                return joinColumn.columnDefinition();
            }

            @Override
            public String table() {
                return joinColumn.table();
            }

            @Override
            public ForeignKey foreignKey() {
                return joinColumn.foreignKey();
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return JoinColumn.class;
            }
        };
    }

    private static String getNewName(String prefix, String annotationName) {
        return prefix + DELIMITER + annotationName;
    }
}