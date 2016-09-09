package org.hibernate.cfg;

import org.hibernate.annotations.common.reflection.XProperty;

import javax.persistence.JoinColumn;
import java.util.Optional;

/**
 * @author ymolodkov on 09.09.16.
 */
public class JoinColumnEmbeddedPrefixOverrideHack extends EmbeddedPrefixOverrideHack<JoinColumn> {

    protected Optional<JoinColumn[]> createOverrideAnnotation(String path, String prefix, XProperty declaredProperty) {
        JoinColumn columnAnnotation = declaredProperty.getAnnotation(JoinColumn.class);
        if (columnAnnotation != null){
            return Optional.of(new JoinColumn[]{AnnotationProvider.createJoinColumnAnnotation(prefix, columnAnnotation)});
        }
        return Optional.empty();
    }

}
