package com.example;

import org.hibernate.annotations.common.reflection.XAnnotatedElement;
import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.annotations.common.reflection.XProperty;
import org.hibernate.cfg.AccessType;
import org.hibernate.internal.util.StringHelper;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
                processProperty(xProperty, path, columnOverride, embeddedPrefixAnnotation.value());
            }
        }
    }

    //todo possible infinity recursion!
    private static void processProperty(XProperty xProperty, String path,
                                        Map<String, Column[]> columnOverride,
                                        String prefix) {
            XClass xClass = xProperty.getClassOrElementClass();
            if (xClass != null){
                List<XProperty> declaredProperties = xClass.getDeclaredProperties(AccessType.FIELD.getType());
                for (XProperty declaredProperty : declaredProperties) {
                    Embedded embeddedAnnotation = declaredProperty.getAnnotation(Embedded.class);
                    if (embeddedAnnotation != null){
                        processProperty(declaredProperty, path+ "."+declaredProperty.getName(), columnOverride, prefix);
                    }
                    Column columnAnnotation = declaredProperty.getAnnotation(Column.class);
                    if (columnAnnotation != null){
                        Column newAnnotation = ColumnAnnotationProvider.getInstance(prefix, columnAnnotation);
                        columnOverride.put(StringHelper.qualify(path, declaredProperty.getName()), new Column[] { newAnnotation });
                    }
                }
            }

    }
}
