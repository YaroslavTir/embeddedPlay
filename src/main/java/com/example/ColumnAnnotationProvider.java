package com.example;

import javax.persistence.Column;

/**
 * @author ymolodkov on 09.09.16.
 */
public class ColumnAnnotationProvider {
    public static Column getInstance(final String prefix, final Column column) {
        return new Column() {
            @Override
            public String name() {
                return prefix + "_" + column.name();
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
}