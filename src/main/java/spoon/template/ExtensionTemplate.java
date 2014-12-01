package spoon.template;

import spoon.reflect.code.CtCodeElement;
import spoon.reflect.declaration.CtAnonymousExecutable;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtSimpleType;
import spoon.reflect.declaration.CtType;
import spoon.reflect.reference.CtTypeReference;
import spoon.support.template.Parameters;

/**
 * Inserts all the methods, fields, constructors, initialization blocks (if
 * target is a class), inner types, and super interfaces (except
 * {@link Template}) from a given template by substituting all the template
 * parameters by their values. Members annotated with
 * {@link spoon.template.Local} or {@link Parameter} are not inserted.
 * 
 */
public class ExtensionTemplate extends AbstractTemplate<CtType<?>> {
	@Override 
	public CtType<?> apply(CtSimpleType<?> target) { 
		if (!(target instanceof CtType)) {
			throw new TemplateException();
		}
		CtClass targetType = (CtClass) target;
		Substitution.insertAll(targetType, this);
		return targetType;
	}
}
