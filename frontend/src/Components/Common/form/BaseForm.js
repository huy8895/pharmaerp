import React, { forwardRef, useState, useImperativeHandle } from "react";
import { Label, Input, FormFeedback } from "reactstrap";

const BaseForm = (props) => {
  const { title } = props;
  return (
    <div>
      <Label htmlFor="name-field" className="form-label">
        {title}
      </Label>
      <Input
        name="name"
        id="customername-field"
        className="form-control"
        placeholder="Enter Name"
        type="text"
        validate={{
          required: { value: true },
        }}
        onChange={validation.handleChange}
        onBlur={validation.handleBlur}
        value={validation.values.name || ""}
        invalid={
          validation.touched.name && validation.errors.name ? true : false
        }
      />
      {validation.touched.name && validation.errors.name ? (
        <FormFeedback type="invalid">{validation.errors.name}</FormFeedback>
      ) : null}
    </div>
  );
};

export default BaseForm;
