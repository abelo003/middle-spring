/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.middle.validation;

import com.test.middle.annotations.ValidationLength;
import com.test.middle.exceptions.LengthFieldException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import com.test.middle.annotations.NotNullOrEmptyField;

/**
 *
 * @author acruzb
 */
public class Validator {

    public static void validateLength(Object objectToValidate) throws LengthFieldException, IllegalArgumentException, IllegalAccessException {

        Field[] declaredFields = objectToValidate.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                field.setAccessible(true);
                if (annotation instanceof ValidationLength) {
                    ValidationLength validationLength = (ValidationLength) annotation;
                    int longitud = validationLength.longitudMaxima();
                    if (longitud > 0) {
                        if (field.get(objectToValidate) == null || "".equals(field.get(objectToValidate))) {
                            throw new LengthFieldException(field.getName() + " no puede ser null o vacio.");
                        } else if (field.get(objectToValidate).toString().length() > longitud) {
                            throw new LengthFieldException(String.format("La longitud del campo %s superar los %d caracteres permitidos.", field.getName(), longitud));
                        }
                    }
                } else if (annotation instanceof NotNullOrEmptyField) {
                    if (field.get(objectToValidate) == null || "".equals(field.get(objectToValidate))) {
                        throw new LengthFieldException(field.getName() + " no puede ser null o vacio.");
                    }
                }
            }
        }
    }

}
