import React from "react";
import { Label, FormFeedback } from "reactstrap";
import { useFormikContext } from "formik";
import _ from "lodash";
import Select from "react-select";

const BaseDate = (props) => {
  const { id, title, name, options, value, msgerror, handleChange } = props;
  const { errors, touched } = useFormikContext();
  const isError = !!_.get(errors, name);
  const isTouch = !!_.get(touched, name);
  return (
    <div>
      <Label htmlFor="name-field" className="form-label">
        {title}
      </Label>
      <Flatpickr
        name={name}
        id={id}
        className="form-control"
        placeholder={placeholder}
        options={{
          altInput: true,
          altFormat: "d M, Y",
          dateFormat: "d M, Y",
        }}
        onChange={(e) => dateformate(e)}
        value={validation.values.date || ""}
      />
      {isTouch && isError ? (
        <FormFeedback style={{ display: "block" }} type="invalid">
          {msgerror || ""}
        </FormFeedback>
      ) : null}
    </div>
  );
};

export default BaseDate;
