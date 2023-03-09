import React from "react";
import { Label, Input, FormFeedback } from "reactstrap";
import { useField, useFormikContext } from "formik";
import _ from 'lodash';
import { useTranslation } from "react-i18next";

const BaseInput = (props) => {
  const { t } = useTranslation();
  const {id, title, name, textformat, msgerror } = props;
  const { errors, touched, handleChange, handleBlur } = useFormikContext();
  const [field] = useField(name);


  const isError = !!_.get(errors, name);
  const isTouch = !!_.get(touched, name);
  return (
    <div>
      <Label htmlFor="name-field" className="form-label">
        {t(title)}
      </Label>
      <Input
        name={name}
        id={id}
        className="form-control"
        type={textformat || "text"}
        validate={{
          required: { value: true },
        }}
        onChange={handleChange}
        onBlur={handleBlur}
        {...field}
        {...props}
        invalid={
          isTouch && isError ? true : false
        }
      />
      {isTouch && isError ? (
        <FormFeedback type="invalid">{msgerror || ""}</FormFeedback>
      ) : null}
    </div>
  );
};

export default BaseInput;
