package com.springboot.hibernate.converters;

import com.springboot.hibernate.enums.Gender;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GenderConverter
    implements AttributeConverter<Gender, Character> {

  public Character convertToDatabaseColumn(Gender value) {
    if (value == null) {
      return null;
    }

    return value.getCode();
  }

  public Gender convertToEntityAttribute(Character value) {
    if (value == null) {
      return null;
    }

    return Gender.fromCode(value);
  }
}