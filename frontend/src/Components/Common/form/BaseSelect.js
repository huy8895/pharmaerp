import React from "react";
import { Label, FormFeedback } from "reactstrap";
import { useFormikContext } from "formik";
import _ from "lodash";
import Select from "react-select";

const BaseSelect = (props) => {
  const { id, title, isMulti, name, options, value, msgerror, handleChange } = props;
  const { errors, touched } = useFormikContext();
  const isError = !!_.get(errors, name);
  const isTouch = !!_.get(touched, name);
  return (
    <div>
      <Label htmlFor="name-field" className="form-label">
        {title}
      </Label>
      <Select
        isMulti={isMulti || false}
        value={value}
        onChange={(e) => handleChange(e)}
        className="mb-0"
        styles={{
          control: (baseStyles) => ({
            ...baseStyles,
            borderColor: isTouch && isError ? "red" : "#ced4da",
          }),
        }}
        options={options}
        id={id}
      ></Select>
      {isTouch && isError ? (
        <FormFeedback style={{ display: "block" }} type="invalid">
          {msgerror || ""}
        </FormFeedback>
      ) : null}
    </div>
  );
};

export default BaseSelect;
