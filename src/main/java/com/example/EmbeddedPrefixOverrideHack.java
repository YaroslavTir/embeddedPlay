package com.example;

import org.hibernate.annotations.common.reflection.XAnnotatedElement;
import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.annotations.common.reflection.XProperty;
import org.hibernate.cfg.AccessType;
import org.hibernate.internal.util.StringHelper;

import javax.persistence.Column;
import java.util.List;
import java.util.Map;

/**
 * @author ymolodkov on 09.09.16.
 */
public class EmbeddedPrefixOverrideHack {

    public static void embeddedPrefixOverride(XAnnotatedElement element, String path, Map<String, Column[]> columnOverride) {
        EmbeddedPrefix embeddedPrefixAnnotation = element.getAnnotation(EmbeddedPrefix.class);
        if (embeddedPrefixAnnotation != null){
            if (element instanceof XProperty){
                XProperty xProperty = (XProperty) element;
                XClass xClass = xProperty.getClassOrElementClass();
                if (xClass != null){
                    List<XProperty> declaredProperties = xClass.getDeclaredProperties(AccessType.FIELD.getType());
                    for (XProperty declaredProperty : declaredProperties) {
                        Column annotation = declaredProperty.getAnnotation(Column.class);
                        Column newAnnotation = ColumnAnnotationProvider.getInstance(embeddedPrefixAnnotation.value(), annotation);
                        columnOverride.put(StringHelper.qualify(path, declaredProperty.getName()), new Column[] { newAnnotation });
                    }
                }
            }
        }
    }
}
