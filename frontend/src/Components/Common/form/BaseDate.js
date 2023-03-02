import React from "react";
import { Label, FormFeedback } from "reactstrap";
import { useFormikContext } from "formik";
import _ from "lodash";
import Flatpickr from "react-flatpickr";

const BaseDate = (props) => {
  const { id, title, name, placeholder, value, msgerror, handleChange } = props;
  const { errors, touched,  } = useFormikContext();
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
          dateFormat: "d-m-Y",
          locale: "vn"
        }}
        style={{borderColor: isTouch && isError ? 'red' : "#ced4da",}}
        onChange={handleChange}
        value={value}
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
