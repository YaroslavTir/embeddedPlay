package org.hibernate.cfg;

import org.hibernate.annotations.common.reflection.XAnnotatedElement;
import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.annotations.common.reflection.XProperty;
import org.hibernate.internal.util.StringHelper;

import javax.persistence.Embedded;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author ymolodkov on 09.09.16.
 */
public abstract class EmbeddedPrefixOverrideHack<T> {

    public static final String PATH_DELIMITER = ".";

    public void embeddedPrefixOverride(XAnnotatedElement element, String path, Map<String, T[]> columnOverride) {
        EmbeddedPrefix embeddedPrefixAnnotation = element.getAnnotation(EmbeddedPrefix.class);
        if (embeddedPrefixAnnotation != null) {
            if (element instanceof XProperty) {
                XProperty xProperty = (XProperty) element;
                processProperty(xProperty, path, columnOverride, embeddedPrefixAnnotation.value());
            }
        }
    }

    private void processProperty(XProperty xProperty, String path, Map<String, T[]> columnOverride, String prefix) {
        XClass xClass = xProperty.getClassOrElementClass();
        if (xClass != null) {
            List<XProperty> declaredProperties = xClass.getDeclaredProperties(AccessType.FIELD.getType());
            for (XProperty declaredProperty : declaredProperties) {
                Embedded embeddedAnnotation = declaredProperty.getAnnotation(Embedded.class);
                if (embeddedAnnotation != null) {
                    String subPath = path + PATH_DELIMITER + declaredProperty.getName();
                    processProperty(declaredProperty, subPath, columnOverride, prefix);
                }
                createOverrideAnnotation(path, prefix, declaredProperty)
                        .ifPresent(c -> columnOverride.put(StringHelper.qualify(path, declaredProperty.getName()), c));
            }
        }

    }

    protected abstract Optional<T[]> createOverrideAnnotation(String path, String prefix, XProperty declaredProperty);
}
