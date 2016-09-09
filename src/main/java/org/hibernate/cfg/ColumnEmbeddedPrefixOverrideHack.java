package org.hibernate.cfg;

import org.hibernate.annotations.common.reflection.XProperty;

import javax.persistence.Column;
import java.util.Optional;

/**
 * @author ymolodkov on 09.09.16.
 */
public class ColumnEmbeddedPrefixOverrideHack extends EmbeddedPrefixOverrideHack<Column> {

    protected Optional<Column[]> createOverrideAnnotation(String path, String prefix, XProperty declaredProperty) {
        Column columnAnnotation = declaredProperty.getAnnotation(Column.class);
        if (columnAnnotation != null){
            return Optional.of(new Column[]{AnnotationProvider.createColumnAnnotation(prefix, columnAnnotation)});
        }
        return Optional.empty();
    }

}
